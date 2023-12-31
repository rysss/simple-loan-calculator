package ren.dy.service;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Singleton;
import ren.dy.entitiy.LoanInput;
import ren.dy.entitiy.MonthlyPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class LoanCalculator {

    public List<MonthlyPayment> calculateLoan(JsonObject input) {

       /* L = (I / 360).H.P
        L- besarnya angsuran bunga
        I - suku bunga per tahun
        H- Jumlah haari dalam 1 bulan(asumsikan setiap bulan 30 hari)
        P- Sisa angsuran pokok*/

        List<MonthlyPayment> monthlyPayments = new ArrayList<>();
        LoanInput loanInput = new LoanInput() ;

        BigDecimal cicilan = BigDecimal.valueOf(Integer.parseInt(input.getString("cicilan")));
        loanInput.setCicilan(cicilan);

        LocalDate tanggalMulai = LocalDate.parse(input.getString("tanggalMulai","YYYY-mm-dd"));
        loanInput.setTanggalMulai(tanggalMulai);

        BigDecimal sukuBunga = BigDecimal.valueOf(Double.parseDouble(input.getString("sukuBunga")));
        loanInput.setSukuBunga(sukuBunga);

        BigDecimal plafon = BigDecimal.valueOf(Double.parseDouble(input.getString("plafon")));
        loanInput.setPlafon(plafon);

        double bungaBulananDouble = sukuBunga.doubleValue()/360*30/100;
        BigDecimal bungaBulanan =  BigDecimal.valueOf(bungaBulananDouble);

        //Cicilan = Pokok pinjaman x suku bunga / 1- (1 + suku bunga)⁻ⁿ.
        BigDecimal numerator = bungaBulanan.multiply(plafon);

        double denominator = 1 - Math.pow((1 + bungaBulanan.doubleValue()),-cicilan.intValue());

        BigDecimal bayarBulanan = numerator.divide(BigDecimal.valueOf(denominator), 2, RoundingMode.HALF_UP);

        BigDecimal sisaPlafon = plafon;
        LocalDate tanggalBayar = loanInput.getTanggalMulai();

        for (int bulan = 1; bulan <= cicilan.intValue(); bulan++) {
            BigDecimal bayarBunga = sisaPlafon.multiply(bungaBulanan).setScale(0, RoundingMode.HALF_UP);
            BigDecimal bayarPokok = bayarBulanan.subtract(bayarBunga).setScale(0, RoundingMode.HALF_UP);
            sisaPlafon = sisaPlafon.subtract(bayarPokok).setScale(0, RoundingMode.HALF_UP);


            if(sisaPlafon.compareTo(BigDecimal.ZERO) <= 0 ) {
                sisaPlafon = BigDecimal.ZERO;
            }
            tanggalBayar = tanggalBayar.plusMonths(1);
            MonthlyPayment payment = new MonthlyPayment(bulan, tanggalBayar, bayarBulanan, bayarBunga, bayarPokok, sisaPlafon);
            monthlyPayments.add(payment);


        }
        return monthlyPayments;

    }
}
