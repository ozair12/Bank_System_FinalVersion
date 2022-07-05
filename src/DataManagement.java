import java.util.ArrayList;

public class DataManagement {
    //THIS IS WHERE INITAIL DATA IS CREATED AT AND LATER LOADED AND SAVED TO
    protected static ArrayList<CurrentAccount> Currentacc = new ArrayList<>();
    protected static ArrayList<BusinessAccount> businessAccounts = new ArrayList<>();
    protected static ArrayList<ISAAccount> isaAccounts = new ArrayList<>();

    public static void main(String[] args) {
        Account acc = new Account();

        CurrentAccount currentAcc = new CurrentAccount();
        BusinessAccount businessAccount = new BusinessAccount();
        ISAAccount isaAccount = new ISAAccount();

        businessAccount.setSortCode("098765");
        currentAcc.setSortCode("123456");
        isaAccount.setSortCode("456789");


        CurrentAccount JSCA = new CurrentAccount("Jon Smith", currentAcc.getSortCode(), 87654321, 2000);
        CurrentAccount BJCA = new CurrentAccount("Boris Johnson", currentAcc.getSortCode(), 87654324, 3000);
        BusinessAccount JSBA = new BusinessAccount("Jon Smith", businessAccount.getSortCode(), 97531864, 3000, true);
        BusinessAccount BJBA = new BusinessAccount("Boris Johnson", businessAccount.getSortCode(), 95498621, 1000.0, true);
        ISAAccount JSISA = new ISAAccount("Jon Smith", isaAccount.getSortCode(), 12345678, 90.00);
        ISAAccount BJISA = new ISAAccount("Boris Johnson", isaAccount.getSortCode(), 99655642, 1000.0);

        businessAccounts.add(JSBA);
        businessAccounts.add(BJBA);

        Currentacc.add(BJCA);
        Currentacc.add(JSCA);

        isaAccounts.add(JSISA);
        isaAccounts.add(BJISA);
    }





}
