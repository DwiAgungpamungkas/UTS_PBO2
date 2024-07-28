import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Akun> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Akun> getAccounts() {
        return accounts;
    }

    public void addAccount(Akun account) {
        accounts.add(account);
    }

    public void removeAccount(Akun account) {
        accounts.remove(account);
    }
}
