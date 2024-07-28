import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Akun {
    private String owner;
    private double balance;
    private Bank bank;
    private List<Transaksi> transaksi;

    public Akun(String owner, double initialBalance, Bank bank) {
        this.owner = owner;
        this.balance = initialBalance;
        this.bank = bank;
        this.transaksi = new ArrayList<>();
        bank.addAccount(this);
    }

    public String getOwner() {
        return owner;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transaksi.add(new Transaksi(new Date(), amount, "Deposit"));
    }

    public void transfer(Akun toAccount, double amount) {
        double fee = 0.0;
        if (!this.bank.getName().equals(toAccount.getBank().getName())) {
            fee = 5.0; // Biaya transfer antar bank
        }
        if (balance >= amount + fee) {
            this.balance -= (amount + fee);
            toAccount.balance += amount;
            transaksi.add(new Transaksi(new Date(), amount, "Transfer to " + toAccount.getOwner()));
            if (fee > 0) {
                transaksi.add(new Transaksi(new Date(), fee, "Transfer Fee"));
            }
            toAccount.transaksi.add(new Transaksi(new Date(), amount, "Transfer from " + this.owner));
        } else {
            System.out.println("Saldo tidak mencukupi untuk melakukan transfer.");
        }
    }

    public Bank getBank() {
        return bank;
    }

    public void printMonthlyTransactions() {
        System.out.println("Rekap transaksi untuk " + owner + ":");
        for (Transaksi transaksi : transaksi) {
            System.out.println(transaksi);
        }
    }
}
