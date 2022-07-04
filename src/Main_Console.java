import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main_Console {

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


        CurrentAccount JSCA = new CurrentAccount("Jon Smith", currentAcc.getSortCode(), 87654321, 1000.00);
        CurrentAccount BJCA = new CurrentAccount("Boris Johnson", currentAcc.getSortCode(), 87654324, 0.00);
        BusinessAccount JSBA = new BusinessAccount("Jon Smith", businessAccount.getSortCode(), 97531864, 10000.00, true);
        BusinessAccount BJBA = new BusinessAccount("Boris Johnson", businessAccount.getSortCode(), 95498621, 1000.0, true);
        ISAAccount JSISA = new ISAAccount("Jon Smith", isaAccount.getSortCode(), 12345678, 90.00);
        ISAAccount BJISA = new ISAAccount("Boris Johnson", isaAccount.getSortCode(), 99655642, 1000.0);

        businessAccounts.add(JSBA);
        businessAccounts.add(BJBA);

        Currentacc.add(BJCA);
        Currentacc.add(JSCA);

        isaAccounts.add(JSISA);
        isaAccounts.add(BJISA);

// method for calculating interest when 31 april is detected
        Account.AddingInterest();

// business charge method will activate when the date has been met
        Account.AnnualCharge();

        Scanner name = new Scanner(System.in);

        System.out.println("Enter the account sort code");
        String sortCode = name.next();
        while (!sortCode.equals(isaAccount.getSortCode()) && (!sortCode.equals(currentAcc.getSortCode())) && (!sortCode.equals(businessAccount.getSortCode()))) {
            System.out.println("Sort code incorrect , No such sort code exists");
            System.out.println("Enter the account sort code");
            sortCode = name.next();
        }
        Scanner account = new Scanner(System.in);

        System.out.println("Enter the account number, must only be 8 digits");
        int accountNumber = account.nextInt();


        ArrayListChecks(sortCode, accountNumber);


        Scanner input = new Scanner(System.in);

        System.out.println("Which service do you require");
        System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money" + " " + "Press 5 to exit");
        System.out.println("Enter 1 , 2, 3, 4 or 5");
        System.out.println();
        int service = input.nextInt();

        while (service < 1 || service > 5) {
            System.out.println("Enter a value between 1, 2, 3, 4 or 5");
            service = input.nextInt();
        }


        while (service != 5) {

            if (service == 1) {
                System.out.println("Enter the amount you wish to deposit");
                double amount = input.nextDouble();
                Account.DepositMoney(sortCode, accountNumber, amount, service);
                System.out.println("Which service do you require");
                System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money" + " " + "Press 5 to exit");
                System.out.println("Enter 1 , 2, 3, 4 or 5");
                input = new Scanner(System.in);
                service = input.nextInt();

            } else if (service == 2) {
                System.out.println("Enter the amount you wish to withdraw");
                double amount = input.nextDouble();
                Account.WithDrawMoney(sortCode, accountNumber, amount, service);
                System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money" + " " + "Press 5 to exit");
                System.out.println("Enter 1 , 2, 3, 4 or 5");
                input = new Scanner(System.in);
                service = input.nextInt();
            } else if (service == 3) {
//            System.out.println("Enter the amount you wish to deposit");
//            double amount = input.nextDouble();
                Account.CheckBalance(sortCode, accountNumber, service);
                System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money" + " " + "Press 5 to exit");
                System.out.println("Enter 1 , 2, 3, 4 or 5");
                input = new Scanner(System.in);
                service = input.nextInt();
            } else if (service == 4) {
                System.out.println("Enter the sort code of the account you want to transfer to: ");
                String selectionSortCode = input.next();
                System.out.println("Enter the account number you wish to deposit to: ");
                int selectionAccountNo = input.nextInt();
                System.out.println("Enter the amount you wish to deposit");
                double amount = input.nextDouble();
                Account.TransferMoney(sortCode, accountNumber, amount, service, selectionSortCode, selectionAccountNo);
                System.out.println("1: Add money" + " " + "2: Withdraw money" + " " + "3:Check balance" + " " + "4:Transfer money" + " " + "Press 5 to exit");
                System.out.println("Enter 1 , 2, 3, 4 or 5");
                input = new Scanner(System.in);
                service = input.nextInt();
            }
        }


    }


    public static void ArrayListChecks(String sortCode, int accountNumber) {
        Scanner account = new Scanner(System.in);

        if (sortCode.equals("123456")) {

            Boolean bool = false;

            for (int i = 0; i < Currentacc.toArray().length; i++) {
                if (accountNumber != Currentacc.get(i).getAccountNumber()) {
                    bool = false;
                } else {
                    bool = true;
                    break;
                }
            }
            while (bool == false) {
                System.out.println("Account number does not exist");
                System.out.println("Enter the account number");

                accountNumber = account.nextInt();

                for (int i = 0; i < Currentacc.toArray().length; i++) {
                    if (accountNumber != Currentacc.get(i).getAccountNumber()) {
                        bool = false;
                    } else {
                        bool = true;
                        break;
                    }
                }
            }

        } else if (sortCode.equals("098765")) {

            Boolean bool = false;

            for (int i = 0; i < businessAccounts.toArray().length; i++) {
                if (accountNumber != businessAccounts.get(i).getAccountNumber()) {
                    bool = false;
                } else {
                    bool = true;
                    break;
                }
            }
            while (bool == false) {
                System.out.println("Account number does not exist");
                System.out.println("Enter the account number");

                accountNumber = account.nextInt();

                for (int i = 0; i < businessAccounts.toArray().length; i++) {
                    if (accountNumber != businessAccounts.get(i).getAccountNumber()) {
                        bool = false;
                    } else {
                        bool = true;
                        break;
                    }
                }
            }


        } else if (sortCode.equals("456789")) {

            Boolean bool = false;

            for (int i = 0; i < isaAccounts.toArray().length; i++) {
                if (accountNumber != isaAccounts.get(i).getAccountNumber()) {
                    bool = false;
                } else {
                    bool = true;
                    break;
                }
            }
            while (bool == false) {
                System.out.println("Account number does not exist");
                System.out.println("Enter the account number");

                accountNumber = account.nextInt();

                for (int i = 0; i < isaAccounts.toArray().length; i++) {
                    if (accountNumber != isaAccounts.get(i).getAccountNumber()) {
                        bool = false;
                    } else {
                        bool = true;
                        break;
                    }
                }
            }


        }


    }

}




