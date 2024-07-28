import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bankA = new Bank("Bank Mandiri");
        Bank bankB = new Bank("Bank BCA");

        // Membuat beberapa akun bank
        Akun acc1 = new Akun("Budi", 100.000, bankA);
        Akun acc2 = new Akun("Asep", 200.000, bankA);
        Akun acc3 = new Akun("Galuh", 300.000, bankB);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Input Saldo");
            System.out.println("3. Transfer");
            System.out.println("4. Rekap Transaksi Perbulan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Masukkan nama akun: ");
                    String name = scanner.next();
                    Akun acc = findAccountByName(name, bankA, bankB);
                    if (acc != null) {
                        System.out.println("Saldo: " + acc.checkBalance());
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 2:
                    System.out.println("Masukkan nama akun: ");
                    name = scanner.next();
                    acc = findAccountByName(name, bankA, bankB);
                    if (acc != null) {
                        System.out.println("Masukkan jumlah yang akan disetor: ");
                        double amount = scanner.nextDouble();
                        acc.deposit(amount);
                        System.out.println("Saldo baru: " + acc.checkBalance());
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("Masukkan nama akun pengirim: ");
                    String fromName = scanner.next();
                    Akun fromAcc = findAccountByName(fromName, bankA, bankB);
                    if (fromAcc != null) {
                        System.out.println("Masukkan nama akun penerima: ");
                        String toName = scanner.next();
                        Akun toAcc = findAccountByName(toName, bankA, bankB);
                        if (toAcc != null) {
                            System.out.println("Masukkan jumlah yang akan ditransfer: ");
                            double amount = scanner.nextDouble();
                            fromAcc.transfer(toAcc, amount);
                            System.out.println("Saldo pengirim baru: " + fromAcc.checkBalance());
                            System.out.println("Saldo penerima baru: " + toAcc.checkBalance());
                        } else {
                            System.out.println("Akun penerima tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Akun pengirim tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("Masukkan nama akun: ");
                    name = scanner.next();
                    acc = findAccountByName(name, bankA, bankB);
                    if (acc != null) {
                        acc.printMonthlyTransactions();
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static Akun findAccountByName(String name, Bank... banks) {
        for (Bank bank : banks) {
            for (Akun acc : bank.getAccounts()) {
                if (acc.getOwner().equals(name)) {
                    return acc;
                }
            }
        }
        return null;
    }
}
