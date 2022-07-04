import java.sql.Struct;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Account extends Main_Console {
    String name;
    String sortCode = " ";
    int accountNumber = 0;
    double balance = 0;


    public Account(String name, String sortCode, int accountNumber, double balance) {
        this.name = name;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


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

    public static void switchCase(String sortCode, int accountNumber, double amount, int service) {

        Main_Console main1 = new Main_Console();

        if (service == 1) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {
                            double totalAmount = amount + Currentacc.get(i).getBalance();
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("completed");
                            System.out.println(Currentacc.get(i).getName() + " " + "new current account balance is: " + Currentacc.get(i).getBalance());

                        }
                    }
                    break;

                case "098765":
                    for (int i = 0; i < businessAccounts.toArray().length; i++) {
                        if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = amount + businessAccounts.get(i).getBalance();
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("completed");
                            System.out.println(businessAccounts.get(i).getName() + " " + "New Business account balance is: " + businessAccounts.get(i).getBalance());

                        }
                    }
                    break;

                case "456789":
                    for (int i = 0; i < isaAccounts.toArray().length; i++) {
                        if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = amount + isaAccounts.get(i).getBalance();
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("completed");
                            System.out.println(isaAccounts.get(i).getName() + " " + "New ISA account balance: " + isaAccounts.get(i).getBalance());

                        }
                    }
            }
        } else if (service == 2) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {
                            if (Currentacc.get(i).getBalance() != amount || Currentacc.get(i).getBalance() < amount) {
                                double totalAmount = Currentacc.get(i).getBalance() - amount;
                                Currentacc.get(i).setBalance(totalAmount);
                                System.out.println("completed");
                                System.out.println("Your new balance: " + Currentacc.get(i).getBalance());
                                System.out.println(Currentacc.get(i).getAccountNumber());

                            } else {
                                System.out.println("Can not withdraw money");
                                System.out.println("Insufficient account balance ");
                                System.out.println(Currentacc.get(i).getName() + "has " + Currentacc.get(i).getBalance());

                            }

                        }


                    }
                    break;

                case "098765":
                    for (int i = 0; i < businessAccounts.toArray().length; i++) {
                        if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = businessAccounts.get(i).getBalance() - amount;
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("completed");
                            System.out.println("Your new balance: " + businessAccounts.get(i).getBalance());

                        }
                    }
                    break;

                case "456789":
                    for (int i = 0; i < isaAccounts.toArray().length; i++) {
                        if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                            double totalAmount = isaAccounts.get(i).getBalance() - amount;
                            isaAccounts.get(i).setBalance(totalAmount);
                            System.out.println("completed");
                            System.out.println("Your new balance: " + isaAccounts.get(i).getBalance());

                        }
                    }
            }
        } else if (service < 1 || service > 3) {
            System.out.println("Error!");
        }
    }

    public static void TransferMoney(String sortCode, int accountNumber, double amount, int service, String selectionSortCode, int selectionAccountNo) {
        Main_Console main1 = new Main_Console();
        switch (sortCode) {
            case "123456":
                for (int i = 0; i < Currentacc.toArray().length; i++) {
                    if (Currentacc.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = Currentacc.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("456789")) {
                            for (int y = 0; y < isaAccounts.toArray().length; y++) {
                                if (selectionSortCode.equals(isaAccounts.get(y).getSortCode()) && selectionAccountNo == isaAccounts.get(y).getAccountNumber()) {
                                    double transfer = amount + isaAccounts.get(y).getBalance();
                                    isaAccounts.get(y).setBalance(transfer);
                                    System.out.println("Your new ISA account balance is " + " " + isaAccounts.get(y).getName() + " " + "is: " + " " + isaAccounts.get(y).getBalance());
                                }
                            }

                        } else if (selectionSortCode.equals("098765")) {
                            for (int j = 0; j < businessAccounts.toArray().length; j++) {
                                if (selectionSortCode.equals(businessAccounts.get(j).getSortCode()) && selectionAccountNo == businessAccounts.get(j).getAccountNumber()) {
                                    double transfer = amount + businessAccounts.get(j).getBalance();
                                    businessAccounts.get(j).setBalance(transfer);
                                    System.out.println("Your new Business account balance is " + " " + " " + businessAccounts.get(j).getName() + "is: " + " " + " " + businessAccounts.get(j).getBalance());
                                }
                            }
                            Currentacc.get(i).setBalance(totalAmount);
                            System.out.println("The remaining balance in your current is" + Currentacc.get(i).getName() + " is: " + Currentacc.get(i).getBalance());
                        }
                    }
                }
                break;

            case "098765":
                for (int i = 0; i < businessAccounts.toArray().length; i++) {
                    if (businessAccounts.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = businessAccounts.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("456789")) {
                            for (int y = 0; y < isaAccounts.toArray().length; y++) {
                                if (selectionSortCode.equals(isaAccounts.get(y).getSortCode()) && selectionAccountNo == isaAccounts.get(y).getAccountNumber()) {
                                    double transfer = amount + isaAccounts.get(y).getBalance();
                                    isaAccounts.get(y).setBalance(transfer);
                                    System.out.println("The remaining balance in your ISA account is" + " " + isaAccounts.get(y) + " " + " is: " + " " + isaAccounts.get(y).getBalance());
                                }
                            }
                            //businessAccounts.get(i).setBalance(totalAmount);
                            //System.out.println("The amount in the business account for " + businessAccounts.get(i).getName() + " is: " + businessAccounts.get(i).getBalance());
                        } else if (selectionSortCode.equals("123456")) {
                            for (int j = 0; j < Currentacc.toArray().length; j++) {
                                if (selectionSortCode.equals(Currentacc.get(j).getSortCode()) && selectionAccountNo == Currentacc.get(j).getAccountNumber()) {
                                    double transfer = amount + Currentacc.get(j).getBalance();
                                    Currentacc.get(j).setBalance(transfer);
                                    System.out.println("The remaining balance in your Current account is" + " " + Currentacc.get(i).getName() + " " + " is: " + " " + Currentacc.get(j).getBalance());
                                }
                            }
                            businessAccounts.get(i).setBalance(totalAmount);
                            System.out.println("The remaining balance in your business is" + businessAccounts.get(i).getName() + " is: " + businessAccounts.get(i).getBalance());
                        }
                    }
                }
                break;

            case "456789":
                for (int i = 0; i < isaAccounts.toArray().length; i++) {
                    if (isaAccounts.get(i).getAccountNumber() == accountNumber) {

                        double totalAmount = isaAccounts.get(i).getBalance() - amount;


                        if (selectionSortCode.equals("123456")) {
                            for (int y = 0; y < Currentacc.toArray().length; y++) {
                                if (selectionSortCode.equals(Currentacc.get(y).getSortCode()) && selectionAccountNo == Currentacc.get(y).getAccountNumber()) {
                                    double transfer = amount + Currentacc.get(y).getBalance();
                                    Currentacc.get(y).setBalance(transfer);
                                    System.out.println("The remaining balance in your Current account is" + " " + Currentacc.get(i).getName() + " " + " is: " + " " + Currentacc.get(y).getBalance());
                                }
                            }
                            // isaAccounts.get(i).setBalance(totalAmount);
                            // System.out.println("The amount in the ISA account for" + isaAccounts.get(i).getName() + " is: " + isaAccounts.get(i).getBalance());
                        } else if (selectionSortCode.equals("098765")) {
                            for (int j = 0; j < businessAccounts.toArray().length; j++) {
                                if (selectionSortCode.equals(businessAccounts.get(j).getSortCode()) && selectionAccountNo == businessAccounts.get(j).getAccountNumber()) {
                                    double transfer = amount + businessAccounts.get(j).getBalance();
                                    businessAccounts.get(j).setBalance(transfer);
                                    System.out.println("The remaining balance in your Current account is" + " " + isaAccounts.get(i).getName() + " " + " is: " + " " + businessAccounts.get(j).getBalance());
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

    public static void AddingInterest() {

        ISAAccount isaAccount = new ISAAccount();

        LocalDate CurrentDate = LocalDate.now();
        LocalDate PreSetDATE = LocalDate.of(2022, 5, 31);
        String presetDate = String.valueOf(PreSetDATE);
        String currentdate = String.valueOf(CurrentDate);
        int month = CurrentDate.getMonthValue();
        int day = CurrentDate.getDayOfMonth();
        int year = PreSetDATE.getYear();


// Array to store the users annual balance
        int[][] yearlyClosingBalance = new int[367][3];

// random object used to generete random balances for test case
        Random arrRandom = new Random();

// Used to return the avrage to 2 decimal places
        DecimalFormat Avgdf = new DecimalFormat("0.00");

        int closingBalance = 0;
        double Interest = 0;
        int sum = 0;
        int avg = 0;


        if (currentdate.equals(presetDate)) {
            System.out.println("interest day");
            for (int i = 0; i < yearlyClosingBalance.length; i++) {
                for (int k = 0; k < 366; k++) {
                    closingBalance = arrRandom.nextInt(100, 1000);
                }
                for (int j = 0; j < yearlyClosingBalance[i].length; j++) {
                    yearlyClosingBalance[i][j] = avg;
                    yearlyClosingBalance[i][j] = closingBalance;

                    for (int k = 0; k < isaAccounts.toArray().length; k++) {
                        yearlyClosingBalance[0][j] = isaAccounts.get(k).getAccountNumber();

                    }


                    System.out.printf("%13d", yearlyClosingBalance[i][j]);
                    sum += yearlyClosingBalance[1][0];
                    avg = sum / 366;
                    Interest = avg * 0.02;


                }


                System.out.println();

            }
            System.out.println(sum);
            System.out.println(avg);
            System.out.println(Avgdf.format(Interest));
            isaAccount.setDate("Interest added on " + " " + presetDate);
            System.out.println(isaAccount.getDate());

            for (int i = 0; i < isaAccounts.toArray().length; i++) {

                if (isaAccounts.get(i).getAccountNumber() == yearlyClosingBalance[0][1]) {
                    double addingInterest = isaAccounts.get(i).getBalance() + Interest;
                    isaAccounts.get(i).setBalance(addingInterest);
                    System.out.println("Interest added to " + " " + isaAccounts.get(i).getName() + "Current ISA balance " + " " + isaAccounts.get(i).getBalance());
                }

            }

        } else {
            System.out.println("incorrect date");
        }


    }

    public static void AnnualCharge() {

        LocalDate CurrentDate = LocalDate.now();
        LocalDate PreSetDATE = LocalDate.of(2022, 7, 04);
        String presetDate = String.valueOf(PreSetDATE);
        String currentdate = String.valueOf(CurrentDate);
        int month = CurrentDate.getMonthValue();
        int day = CurrentDate.getDayOfMonth();
        int year = PreSetDATE.getYear();

        double annualCharge = 25;
        for (int i = 0; i < businessAccounts.toArray().length; i++) {

            if (currentdate.equals(presetDate)) {
                System.out.println("true");
                double newcharge = businessAccounts.get(i).getBalance() - annualCharge;
                businessAccounts.get(i).setBalance(newcharge);
                System.out.println("Remaining balance in " + " " + businessAccounts.get(i).getName() + " " + "is" + businessAccounts.get(i).getBalance());
            } else {
                System.out.println("false");
            }
        }

    }

    public static void CheckBalance(String sortCode, int accountNumber, int service) {
        Main_Console main1 = new Main_Console();
        if (service == 3) {
            switch (sortCode) {
                case "123456":
                    for (int i = 0; i < Currentacc.toArray().length; i++) {
                        if (Currentacc.get(i).getAccountNumber() == accountNumber) {
                            System.out.println("The current balance is: " + Currentacc.get(i).getBalance());
                            System.out.println(Currentacc.get(i).getName());
                            System.out.println(Currentacc.get(i).getAccountNumber());
                        }

                    }
                    break;

                case "098765":
                    for (int i = 0; i < businessAccounts.toArray().length; i++) {
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
                    for (int i = 0; i < isaAccounts.toArray().length; i++) {
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
