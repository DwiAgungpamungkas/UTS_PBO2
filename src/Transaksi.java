import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi {
    private Date tanggal;
    private double jumlah;
    private String deskripsi;

    public Transaksi(Date tanggal, double jumlah, String deskripsi) {
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(tanggal) + " - " + deskripsi + ": " + jumlah;
    }
}
