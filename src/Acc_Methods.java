import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Acc_Methods extends Main_Console {
    public static void DepositMoney(String sortCode, int accountNumber, double amount, int service) {

        Main_Console main1 = new Main_Console();
        switchCase(sortCode, accountNumber, amount, service);

    }

    public static void WithDrawMoney(String sortCode, int accountNumber, double amount, int service) {
        Main_Console main1 = new Main_Console();
        switchCase(sortCode, accountNumber, amount, service);

    }

    public static void CheckBalance(String sortCode, int accountNumber, double amount, int service) {
        Main_Console main1 = new Main_Console();
        switchCase(sortCode, accountNumber, amount, service);

    }

    public static void switchCase (String sortCode,int accountNumber, double amount, int service){

        Main_Console main1 = new Main_Console();

        if (service == 1) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < main1.Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = amount + Currentacc.get(i).getBalance();
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + Currentacc.get(i).getBalance());

                        }
                    }
                    break;

                case "098765":
                    for (int i = 0; i < main1.businessAccounts.toArray().length; i++) {
                        if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = amount + businessAccounts.get(i).getBalance();
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + businessAccounts.get(i).getBalance());

                        }
                    }
                    break;

                case "456789":
                    for (int i = 0; i < main1.isaAccounts.toArray().length; i++) {
                        if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = amount + isaAccounts.get(i).getBalance();
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + isaAccounts.get(i).getBalance());

                        }
                    }
            }
        }

        else if (service == 2) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < main1.Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {
                            if (Currentacc.get(i).getBalance() == Currentacc.get(i).getBalance() || Currentacc.get(i).getBalance() < Currentacc.get(i).getBalance()) {
                                System.out.println("Customer can not withdraw more money than they already have in their balance");
                                System.out.println(Currentacc.get(i).getName() + "has " + Currentacc.get(i).getBalance());
                            }

                            double totalAmount = Currentacc.get(i).getBalance() - amount;
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + Currentacc.get(i).getBalance());

                        }
                    }
                    break;

                case "098765":
                    for (int i = 0; i < main1.businessAccounts.toArray().length; i++) {
                        if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = businessAccounts.get(i).getBalance() - amount;
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + businessAccounts.get(i).getBalance());

                        }
                    }
                    break;

                case "456789":
                    for (int i = 0; i < main1.isaAccounts.toArray().length; i++) {
                        if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = isaAccounts.get(i).getBalance() - amount;
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount is: " + isaAccounts.get(i).getBalance());

                        }
                    }
            }
        }

        else if (service <1 || service >3) {
            System.out.println("Error!");}
    }

    public static void TransferMoney(String sortCode, int accountNumber, double amount, int service, String selectionSortCode, int selectionAccountNo) {
        Main_Console main1 = new Main_Console();
        switch (sortCode) {
            case "123456":
                for (int i = 0; i < main1.Currentacc.toArray().length; i++) {
                    if (Currentacc.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = Currentacc.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("456789")) {
                            for (int y = 0; y < main1.isaAccounts.toArray().length; y++) {
                                if (selectionSortCode.equals(isaAccounts.get(y).getSortCode()) && selectionAccountNo == isaAccounts.get(y).getAccountNumber()) {
                                    double transfer = amount + isaAccounts.get(y).getBalance();
                                    isaAccounts.get(y).setBalance(transfer);
                                    System.out.println("The amount in the business account for " + businessAccounts.get(y).getName() + " is: " + isaAccounts.get(y).getBalance());
                                }
                            }
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the current is: " + Currentacc.get(i).getBalance());
                        } else if (selectionSortCode.equals("098765")) {
                            for (int j = 0; j < main1.businessAccounts.toArray().length; j++) {
                                if (selectionSortCode.equals(businessAccounts.get(j).getSortCode()) && selectionAccountNo == businessAccounts.get(j).getAccountNumber()) {
                                    double transfer = amount + businessAccounts.get(j).getBalance();
                                    businessAccounts.get(j).setBalance(transfer);
                                    System.out.println("The amount in the business account for" + businessAccounts.get(j).getName() + " is: " + businessAccounts.get(j).getBalance());
                                }
                            }
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the current account for " + Currentacc.get(i).getName() + " is: " + Currentacc.get(i).getBalance());
                        }
                    }
                }
                break;

            case "098765":
                for (int i = 0; i < main1.businessAccounts.toArray().length; i++) {
                    if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = businessAccounts.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("456789")) {
                            for (int y = 0; y < main1.isaAccounts.toArray().length; y++) {
                                if (selectionSortCode.equals(isaAccounts.get(y).getSortCode()) && selectionAccountNo == isaAccounts.get(y).getAccountNumber()) {
                                    double transfer = amount + isaAccounts.get(y).getBalance();
                                    isaAccounts.get(y).setBalance(transfer);
                                    System.out.println("The amount in the ISA account for " + isaAccounts.get(y) + " is: " + isaAccounts.get(y).getBalance());
                                }
                            }
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the business account for " + businessAccounts.get(i).getName() + " is: " + businessAccounts.get(i).getBalance());
                        } else if (selectionSortCode.equals("123456")) {
                            for (int j = 0; j < main1.Currentacc.toArray().length; j++) {
                                if (selectionSortCode.equals(Currentacc.get(j).getSortCode()) && selectionAccountNo == Currentacc.get(j).getAccountNumber()) {
                                    double transfer = amount + Currentacc.get(j).getBalance();
                                    Currentacc.get(j).setBalance(transfer);
                                    System.out.println("The amount in the current account for " + Currentacc.get(i).getName() + " is: " + Currentacc.get(j).getBalance());
                                }
                            }
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the business account for " + businessAccounts.get(i).getName() + " is: " + businessAccounts.get(i).getBalance());
                        }
                    }
                }
                break;

            case "456789":
                for (int i = 0; i < main1.isaAccounts.toArray().length; i++) {
                    if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = isaAccounts.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("123456")) {
                            for (int y = 0; y < main1.Currentacc.toArray().length; y++) {
                                if (selectionSortCode.equals(Currentacc.get(y).getSortCode()) && selectionAccountNo == Currentacc.get(y).getAccountNumber()) {
                                    double transfer = amount + Currentacc.get(y).getBalance();
                                    Currentacc.get(y).setBalance(transfer);
                                    System.out.println("The amount in the Current account for " + Currentacc.get(i).getName() + " is: " + Currentacc.get(y).getBalance());
                                }
                            }
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the ISA account for" + isaAccounts.get(i).getName() + " is: " + isaAccounts.get(i).getBalance());
                        } else if (selectionSortCode.equals("098765")) {
                            for (int j = 0; j < main1.businessAccounts.toArray().length; j++) {
                                if (selectionSortCode.equals(businessAccounts.get(j).getSortCode()) && selectionAccountNo == businessAccounts.get(j).getAccountNumber()) {
                                    double transfer = amount + businessAccounts.get(j).getBalance();
                                    businessAccounts.get(j).setBalance(transfer);
                                    System.out.println("The amount in the Business account for " + isaAccounts.get(i).getName() + " is: " + businessAccounts.get(j).getBalance());
                                }
                            }
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The amount in the ISA account for " + isaAccounts.get(i).getName() + " is: " + isaAccounts.get(i).getBalance());
                        }
                    }
                }
                break;

        }
    }

    public static void AddingInterest(){}

    public static void AnnualCharge(){}

    public static void CheckBalance(String sortCode, int accountNumber, int service) {
        Main_Console main1 = new Main_Console();
        if (service == 3) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < main1.Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {
                            System.out.println("The current balance is: " + Currentacc.get(i).getBalance());
                            System.out.println(Currentacc.get(i).getName());
                            System.out.println(Currentacc.get(i).getAccountNumber());
                        }

                    }
                    break;

                case "098765":
                    for (int i = 0; i < main1.businessAccounts.toArray().length; i++) {
                        if (businessAccounts.get(i).getAccountNumber() == accountNumber) {
                            System.out.println("The current balance is: " + businessAccounts.get(i).getBalance());
                            System.out.println(businessAccounts.get(i).getName());
                            System.out.println(businessAccounts.get(i).getAccountNumber());

                        }
//                else{
//                    System.out.println("Error: did not find account!");
//
//                }
                    }
                    break;

                case "456789":
                    for (int i = 0; i < main1.isaAccounts.toArray().length; i++) {
                        if (isaAccounts.get(i).getAccountNumber() == accountNumber) {
                            System.out.println("The current balance is: " + isaAccounts.get(i).getBalance());
                            System.out.println(isaAccounts.get(i).getName());
                            System.out.println(isaAccounts.get(i).getAccountNumber());

                        }
//                else{
//                    System.out.println("Error: did not find account!");
//
                    }
            }
        }

    }
}
