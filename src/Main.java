import java.awt.*;
import java.util.ArrayList;

public class RekeningBank {

    private String nama;
    private String noRekening;
    private double saldo;
    private List<Transaksi> transaksiList = new ArrayList<>();

    public RekeningBank(String nama, String noRekening, double saldo) {
        this.nama = nama;
        this.noRekening = noRekening;
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void cekSaldo() {
        System.out.println("Saldo Rekening " + noRekening + ": Rp" + saldo);
    }

    public void inputSaldo(double nominal) {
        saldo += nominal;
        System.out.println("Saldo Rekening " + noRekening + " berhasil ditambahkan Rp" + nominal);
    }

    public void rekapTransaksiPerbulan(int bulan) {
        System.out.println("Rekap Transaksi Rekening " + noRekening + " Bulan " + bulan);
        for (Transaksi transaksi : transaksiList) {
            if (transaksi.getTanggal().getMonth() == bulan - 1) {
                System.out.println(" - " + transaksi);
            }
        }
    }

    public void transfer(RekeningBank rekeningTujuan, double nominalTransfer, double biayaTransfer) {
        if (saldo >= nominalTransfer + biayaTransfer) {
            saldo -= nominalTransfer + biayaTransfer;
            rekeningTujuan.saldo += nominalTransfer;
            Transaksi transaksiPengirim = new Transaksi("Transfer ke " + rekeningTujuan.getNama(), -nominalTransfer - biayaTransfer);
            Transaksi transaksiPenerima = new Transaksi("Transfer dari " + nama, nominalTransfer);
            transaksiList.add(transaksiPengirim);
            rekeningTujuan.transaksiList.add(transaksiPenerima);
            System.out.println("Transfer ke Rekening " + rekeningTujuan.getNoRekening() + " berhasil dilakukan dengan nominal Rp" + nominalTransfer);
        } else {
            System.out.println("Saldo tidak mencukupi untuk melakukan transfer");
        }
    }
}