import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    String sortCodeCurrent="123456";
    CurrentAccount JSCA = new CurrentAccount("Jon Smith", sortCodeCurrent, 87654321, 1000.00);
CurrentAccount BSCA = new CurrentAccount("Boris helm", sortCodeCurrent, 78782828, 300.0);
    protected static ArrayList<CurrentAccount> Currentacc = new ArrayList<>();


    @org.junit.jupiter.api.Test
    void getName() {
        String name=JSCA.getName();
        String expectedName= "Jon Smith";
        assertEquals(name,expectedName);
    }

    @org.junit.jupiter.api.Test
    void getSortCode() {
        String sortcode=JSCA.getSortCode();
        assertEquals(sortcode,sortCodeCurrent);

    }

    @org.junit.jupiter.api.Test
    void getAccountNumber() {
        int accountNo = JSCA.getAccountNumber();
        assertEquals(accountNo, 87654321);
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        double balance = JSCA.getBalance();
        assertEquals(balance, 1000.00);
    }

    @org.junit.jupiter.api.Test
    void depositMoney() {
        double depositing = 300;
        double updatedBalance = depositing + JSCA.getBalance();
        JSCA.setBalance(updatedBalance);
        assertEquals(JSCA.getBalance(), 1300);
    }

    @org.junit.jupiter.api.Test
    void withDrawMoney() {
        double withdrawing = 300;
        double updatedBalance = JSCA.getBalance() - withdrawing;
        JSCA.setBalance(updatedBalance);
        assertEquals(JSCA.getBalance(), 700);

    }

    @org.junit.jupiter.api.Test
    void checkBalance() {
        String name = JSCA.getName();
        double balance = JSCA.getBalance();
        int acc = JSCA.getAccountNumber();
        String checkBalance = name + " " + acc + " "  + balance;
        assertEquals(checkBalance, "Jon Smith" + " " + JSCA.accountNumber + " " + JSCA.getBalance());

    }

    @org.junit.jupiter.api.Test
    void transferMoney() {
        double transfer = 300;
        double withdraw = JSCA.getBalance() - 300;
        double add = BSCA.getBalance() + transfer;
         BSCA.setBalance(add);
         assertEquals(BSCA.getBalance(), add);


    }

    @org.junit.jupiter.api.Test
    void addingInterest() {
        Currentacc.add(JSCA);
        Currentacc.add(BSCA);

        LocalDate CurrentDate = LocalDate.now();
        LocalDate PreSetDATE = LocalDate.of(2022, 7, 04);
        String presetDate = String.valueOf(PreSetDATE);
        String currentdate = String.valueOf(CurrentDate);


        double Interest = 30;
        for (int i = 0; i < Currentacc.toArray().length; i++) {

            if (currentdate.equals(presetDate)) {

               double addingInterest = Currentacc.get(i).getBalance() + Interest;
                Currentacc.get(i).setBalance(addingInterest);
                System.out.println("Interest added to " + " " + Currentacc.get(i).getName() + "Current account balance " + " " + Currentacc.get(i).getBalance());

            } else {
                System.out.println("Date has not been met to add annual interest");
            }
        }
        assertEquals(BSCA.getBalance(), BSCA.getBalance());
    }

    @org.junit.jupiter.api.Test
    void annualCharge() {

        LocalDate CurrentDate = LocalDate.now();
        LocalDate PreSetDATE = LocalDate.of(2022, 7, 04);
        String presetDate = String.valueOf(PreSetDATE);
        String currentdate = String.valueOf(CurrentDate);

double annualCharge = 25;
for(int i = 0;i < Currentacc.toArray().length; i++){
    if (currentdate.equals(presetDate)) {

        System.out.println("true");
        double newcharge = Currentacc.get(i).getBalance() - annualCharge;
        Currentacc.get(i).setBalance(newcharge);
        System.out.println("Remaining balance in " + " " + Currentacc.get(i).getName() + " " + "is" + Currentacc.get(i).getBalance());
    }else{
        System.out.println("Date has not been met to add annual business charge");
    }
}
    }

    @org.junit.jupiter.api.Test
    void testCheckBalance() {
    }
}