import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private String description;

    public Transaction(Date date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date) + " - " + description + ": " + amount;
    }
}
