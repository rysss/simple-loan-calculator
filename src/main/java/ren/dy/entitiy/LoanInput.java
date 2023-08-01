package ren.dy.entitiy;

import java.math.BigDecimal;
import java.time.LocalDate;
public class LoanInput {
    private BigDecimal cicilan;
    private BigDecimal sukuBunga;
    private LocalDate tanggalMulai;
    private BigDecimal plafon;

    public LoanInput() {

    }

    public LoanInput(BigDecimal cicilan,  LocalDate tanggalMulai, BigDecimal sukuBunga,BigDecimal plafon) {
        this.cicilan = cicilan;
        this.sukuBunga = sukuBunga;
        this.tanggalMulai = tanggalMulai;
        this.plafon = plafon;

        System.out.println(cicilan);
    }


    public BigDecimal setCicilan(BigDecimal cicilan) {
        return cicilan;
    }
    public BigDecimal getCicilan() {
        return cicilan;
    }


    public BigDecimal getSukuBunga() {
        return sukuBunga;
    }

    public void setSukuBunga(BigDecimal sukuBunga) {
        this.sukuBunga = sukuBunga;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public BigDecimal getPlafon() {
        return plafon;
    }

    public void setPlafond(BigDecimal plafon) {
        this.plafon = plafon;
    }
}