import java.io.Serializable;

public class CurrentAccount extends Account implements Serializable {
    public CurrentAccount(String name, String sortCode, int accountNumber, double balance) {
        super(name, sortCode, accountNumber, balance);
    }


    public CurrentAccount() {

    }
    public void setSortCode(){

    }

}
