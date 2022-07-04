import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ISAAccount extends Account{


    LocalDate localDate;
    String date;
    public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
    }
    public LocalDate getLocalDate(){
        return localDate;
    }

    public void  setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }


    public ISAAccount(String name, String sortCode, int accountNumber, double balance) {
        super(name, sortCode, accountNumber, balance);
    }

    public ISAAccount() {




    }
    public ISAAccount(String name, String sortCode, int accountNumber, double balance , LocalDate localDate){

    }




}
