package ren.dy.entitiy;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MonthlyPayment {
    private int bulan;
    private LocalDate tanggalBayar;
    private BigDecimal bayarBulanan;
    private BigDecimal bayarBunga;
    private BigDecimal bayarPokok;
    private BigDecimal sisaPlafon;
    public MonthlyPayment(int bulan, LocalDate tanggalBayar, BigDecimal bayarBulanan, BigDecimal bayarBunga,
                          BigDecimal bayarPokok, BigDecimal sisaPlafon) {
        this.bulan = bulan;
        this.tanggalBayar = tanggalBayar;
        this.bayarBulanan = bayarBulanan;
        this.bayarBunga = bayarBunga;
        this.bayarPokok = bayarPokok;
        this.sisaPlafon = sisaPlafon;
    }

    public int getBulan() {
        return bulan;
    }
    public LocalDate getTanggalBayar() {
        return tanggalBayar;
    }
    public BigDecimal getBayarBulanan(){
        return bayarBulanan;
    }
    public BigDecimal getBayarBunga(){
        return bayarBunga;
    }
    public BigDecimal getBayarPokok(){
        return bayarPokok;
    }

    public BigDecimal getSisaPlafon(){
        return sisaPlafon;
    }

}