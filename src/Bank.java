import java.util.Date;

public class Transaksi {

    private String keterangan;
    private double nominal;
    private Date tanggal;

    public Transaksi(String keterangan, double nominal) {
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.tanggal = new Date();
    }

    public String getKeterangan() {
        return keterangan;
    }

    public double getNominal() {
        return nominal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {
        return keterangan + ": Rp" + nominal + " (" + tanggal.toString() + ")";
    }
}