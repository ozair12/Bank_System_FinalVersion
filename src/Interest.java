import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Interest {



    public static void main(String[] args) {

        ArrayList<ISAAccount> isaAccounts = new ArrayList<>();

        ISAAccount isaAccount = new ISAAccount();
        ISAAccount JSISA = new ISAAccount("Jon Smith", isaAccount.getSortCode(), 12345678, 90.00);
        ISAAccount BJISA = new ISAAccount("Boris Johnson", isaAccount.getSortCode(), 99655642, 1000.0);
        ISAAccount MSISA = new ISAAccount("Mursal Sediq", isaAccount.getSortCode(), 866454567, 1000.0);

        isaAccounts.add(JSISA);
        isaAccounts.add(BJISA);
        isaAccounts.add(MSISA);
        LocalDate ld1 = LocalDate.now();

        //can be used
        for (int i = 0; i < isaAccounts.toArray().length; i++) {
            isaAccounts.get(i).setLocalDate(ld1);

            if (isaAccounts.get(i).getLocalDate() == ld1) {

                System.out.println("true");
                System.out.println(isaAccounts.get(i).getLocalDate());

            } else {
                System.out.println("false");

            }
        }

        LocalDate ld = LocalDate.of(2022, 4, 2);
        String ly = String.valueOf(ld);
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        int year = ld.getYear();

        if (ld.equals("jun")) {

        }

        int[][] yearlyClosingBalance = new int[367][3];


        int sum = 0;
        int avg = 0;
        int closingBalance = (int) (Math.random() * 100);
        closingBalance = closingBalance + 1;

        System.out.println("random num " + closingBalance);


        double Interest = 0;

        for (int i = 0; i < yearlyClosingBalance.length; i++) {
            for (int k = 0; k < 366; k++) {
                closingBalance = (int) (Math.random() * 1000);

            }
            for (int j = 0; j < yearlyClosingBalance[i].length; j++) {
                yearlyClosingBalance[i][j] = closingBalance;
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
        System.out.println(Interest);

    }

}
