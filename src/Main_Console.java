import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_Console {

    protected static ArrayList<CurrentAccount> Currentacc = new ArrayList<>();
    protected static ArrayList<BusinessAccount> businessAccounts = new ArrayList<>();
    protected static ArrayList<ISAAccount> isaAccounts = new ArrayList<>();
    public static void main(String[]args){


        Acc_Methods method = new Acc_Methods();


        CurrentAccount currentAcc = new CurrentAccount();
        BusinessAccount businessAccount = new BusinessAccount();
        ISAAccount isaAccount = new ISAAccount();
        businessAccount.setSortCode("098765");
        currentAcc.setSortCode("123456");
        isaAccount.setSortCode("456789");

        CurrentAccount JSCA=new CurrentAccount("Jon Smith",currentAcc.getSortCode(),87654321,1000.00);
        CurrentAccount BJCA=new CurrentAccount("Boris Johnson",currentAcc.getSortCode(),87654324,0.00);
        BusinessAccount JSBA= new BusinessAccount("Jon Smith",businessAccount.getSortCode(),97531864,10000.00, true);
        BusinessAccount BJBA =new BusinessAccount("Boris Johnson", businessAccount.getSortCode(),95498621,1000.0, true);
        ISAAccount JSISA =new ISAAccount("Jon Smith", isaAccount.getSortCode(), 12345678,90.00);
        ISAAccount BJISA=new ISAAccount("Boris Johnson",isaAccount.getSortCode(),99655642,1000.0);


        businessAccounts.add(JSBA);
        businessAccounts.add(BJBA);

        Currentacc.add(BJCA);
        Currentacc.add(JSCA);

        isaAccounts.add(JSISA);
        isaAccounts.add(BJISA);

        Scanner name = new Scanner(System.in);

        System.out.println("Enter the account sort code");
        String sortCode = name.next();

        System.out.println("Enter the account number");
        int accountNumber = name.nextInt();

        System.out.println("Which service do you require");
        System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money");
        System.out.println("Enter 1 , 2, 3 or 4");

        Scanner input = new Scanner(System.in);
        int service = input.nextInt();
        if (service == 1){
            System.out.println("Enter the amout you wish to deposit");
            double amount = input.nextDouble();
            method.DepositMoney(sortCode, accountNumber, amount, service);

        } else if (service == 2){
            System.out.println("Enter the amount you wish to withdraw");
            double amount = input.nextDouble();
            method.WithDrawMoney(sortCode, accountNumber, amount, service);
        } else if (service == 3){
//            System.out.println("Enter the amount you wish to deposit");
//            double amount = input.nextDouble();
            method.CheckBalance(sortCode, accountNumber, service);
        }else if (service == 4){
            System.out.println("Enter the sort code of the account you want to transfer to: ");
            String selectionSortCode = input.next();
            System.out.println("Enter the account number you wish to deposit to: ");
            int selectionAccountNo = input.nextInt();
            System.out.println("Enter the amount you wish to deposit");
            double amount = input.nextDouble();
            method.TransferMoney(sortCode, accountNumber, amount, service, selectionSortCode, selectionAccountNo);
        }


        while(service < 1 || service > 4){
            System.out.println("Enter a value between 1, 2, 3 or 4");
            service = input.nextInt();

        }


    }

}


