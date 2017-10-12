
package calendar.pkg2;

import java.util.Scanner;

/**
 *
 * @author Rolf Kinder Gilet
 *
 */
public class Calendar {

    public static int GetStartDay(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = M + 12 * ((14 - M) / 12) - 2;
        int d = (D + x + (31 * m) / 12) % 7;
        return d;
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int getMonthNumber(String s) {
        switch (s.toLowerCase()) {
            case "jan":
                return 1;
            case "feb":
                return 2;
            case "mar":
                return 3;
            case "apr":
                return 4;
            case "may":
                return 5;
            case "jun":
                return 6;
            case "jul":
                return 7;
            case "aug":
                return 8;
            case "sep":
                return 9;
            case "oct":
                return 10;
            case "nov":
                return 11;
            case "dec":
                return 12;
            default:
                return -1;
        }
    }

    public static int GetYear(String s) {
        s=s.replace(" ", "");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false) {
                return -1;
            }
            if (s.charAt(i) == '.') {
                return -1;
            }
        }
        int retu = Integer.parseInt(s);
        if (retu < 1990 || retu > 2099) {
            return -1;
        }
        return retu;

    }

    public static void displayCalendar(int d, int days) {
        // Pad space before the first day of the month

        for (int i = 0; i < d; i++) {
            System.out.print("     ");
        }
        for (int i = 1; i <= days; i++) {
            System.out.printf("%3d  ", i);
            if (((i + d) % 7 == 0) || (i == days)) {
                System.out.println();

            }
        }

    }

    public static void monthsnumberdays(String s, int M, int Y) {
        getMonthNumber(s);

        int[] days = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if (M == 2 && isLeapYear(Y)) {
            days[M] = 29;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        boolean run = true;
        while (run) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the Month and a year between 1900 and 2099. Example: JAN 1994");
            String imput;
            String s;
            imput = sc.nextLine();
            int M;
            int Y;
            if (imput.length() <= 3) {
                M = -1;
            } else {

                s = imput.substring(0, 3);
                M = getMonthNumber(s);
            }
            if (imput.length() <= 4) {
                Y = -1;
            } else {

                s = imput.substring(4, imput.length());
                Y = GetYear(s);
            }

            for (int i = 1; i <= 3; i++) {
                if (i == 3) {
                    System.exit(1);
                }
                if (Y == -1 || M == -1) {
                    System.out.println("ERROR in imput. Try again.");
                    imput = sc.nextLine();
                    if (imput.length() <= 3) {
                        M = -1;
                    } else {

                        s = imput.substring(0, 3);
                        M = getMonthNumber(s);
                    }
                    
                    if (imput.length() <= 4) {
                        Y = -1;
                    } else {

                        s = imput.substring(4, imput.length());
                        Y = GetYear(s);
                    }
                } else {
                    break;
                }
            }

            String[] months = {
                "",
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
            };

            int[] days = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };

            if (M == 2 && isLeapYear(Y)) {
                days[M] = 29;
            }

            System.out.println("           " + months[M] + " " + Y);

            System.out.println(" Sun  Mon  Tue  Wen  Thu  Fri  Sat");

            int d = GetStartDay(M, 1, Y);
            displayCalendar(d, days[M]);

            System.out.println("Do you want to continue: Yes/No");
            imput = sc.next();
            imput = imput.toLowerCase();

            for (int y = 1; y <= 3; y++) {
                if (y == 3) {
                    System.exit(1);
                }

                switch (imput) {
                    case "y":
                        run = true;
                        y = -1;
                        break;
                    case "yes":
                        run = true;
                        y = -1;
                        break;
                    case "n":
                        run = false;
                        y = -1;
                        break;
                    case "no":
                        run = false;
                        y = -1;
                        break;
                }
                if (y == -1) {
                    break;
                }
                System.out.println("Error in imput. Try again");
                imput = sc.next();
                imput = imput.toLowerCase();

            }

        }
    }

}
