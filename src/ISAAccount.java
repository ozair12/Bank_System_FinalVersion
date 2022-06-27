import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ISAAccount extends Account{


    LocalDate localDate;
    public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
    }
    public LocalDate getLocalDate(){
        return localDate;
    }

    public ISAAccount(String name, String sortCode, int accountNumber, double balance) {
        super(name, sortCode, accountNumber, balance);
    }

    public ISAAccount() {

    }
    public ISAAccount(String name, String sortCode, int accountNumber, double balance , LocalDate localDate){

    }
}
