
package cashier.pkg1;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author Rolf Kinder Gilet
 *
 */
public class Cashier {

    public static void main(String[] args) {

        String Shundrade, Sfifty, Stwenty, Sten, Sfive, Sone, Squarter, Sdime, Snickel, Spenny, StotalCents;
        int hundrade, fifty, twenty, ten, five, one, quarter, dime, nickel, penny, totalCents;
        int k1;
        double AmountGiven;

        String s1 = JOptionPane.showInputDialog("Enter the purchase amount");

        if (!(s1 == null || s1.length() == 0)) {
            int count = s1.length() - s1.replace(".", "").length();
            if (count < 2) {
                int integerPlaces = s1.indexOf('.');
                int decimalPlaces;
                if (integerPlaces == -1) {
                    decimalPlaces = 0;
                } else {
                    decimalPlaces = s1.length() - integerPlaces - 1;
                }
                if (decimalPlaces <= 2) {
                    int sz = s1.length();

                    for (int i = 0; i < sz; i++) {
                        if (!(Character.isDigit(s1.charAt(i)) == false)) {

                            String s2 = JOptionPane.showInputDialog("Enter the payment amount");
                            if (!(s2 == null || s1.length() == 0)) {
                                count = s2.length() - s2.replace(".", "").length();
                                if (count < 2) {
                                    integerPlaces = s2.indexOf('.');
                                    if (integerPlaces == -1) {
                                        decimalPlaces = 0;
                                    } else {
                                        decimalPlaces = s1.length() - integerPlaces - 1;
                                    }
                                    if (decimalPlaces <= 2) {
                                        sz = s2.length();
                                        for (int y = 0; y < sz; y++) {
                                            if (!(Character.isDigit(s2.charAt(y)) == false)) {
                                                double PurchaseAmount = Double.parseDouble(s1);
                                                double tax = PurchaseAmount * .07;
                                                double total = PurchaseAmount + tax;
                                                double PaymentAmount = Double.parseDouble(s2);

                                                double Change = PaymentAmount - total;
                                                if (Change >= 0) {

                                                    totalCents = (int) (100 * Change);

                                                    hundrade = (totalCents / 10000);
                                                    k1 = hundrade * 10000;
                                                    fifty = ((totalCents - k1) / 5000);
                                                    k1 = k1 + fifty * 5000;
                                                    twenty = ((totalCents - k1) / 2000);
                                                    k1 = k1 + twenty * 2000;
                                                    ten = ((totalCents - k1) / 1000);
                                                    k1 = k1 + ten * 1000;
                                                    five = ((totalCents - k1) / 500);
                                                    k1 = k1 + five * 500;
                                                    one = ((totalCents - k1) / 100);
                                                    k1 = k1 + one * 100;
                                                    quarter = ((totalCents - k1) / 25);
                                                    k1 = k1 + quarter * 25;
                                                    dime = ((totalCents - k1) / 10);
                                                    k1 = k1 + dime * 10;
                                                    nickel = ((totalCents - k1) / 5);
                                                    k1 = k1 + nickel * 5;
                                                    penny = (totalCents - k1);

                                                    if (hundrade == 0) {
                                                        Shundrade = "";
                                                    } else if (hundrade > 1) {
                                                        Shundrade = "     " + hundrade + " Hundreds Dollar Bills\n";
                                                    } else {
                                                        Shundrade = "     1 Hundred Dollar Bill\n";
                                                    }

                                                    if (fifty == 0) {
                                                        Sfifty = "";
                                                    } else if (fifty > 1) {
                                                        Sfifty = "     " + fifty + " Fifty Dollar Bills\n";
                                                    } else {
                                                        Sfifty = "     1 Fifty Dollar Bill\n";
                                                    }

                                                    if (twenty == 0) {
                                                        Stwenty = "";
                                                    } else if (twenty > 1) {
                                                        Stwenty = "     " + twenty + " Twenty Dollar Bills\n";
                                                    } else {
                                                        Stwenty = "     1 Twenty Dollar Bill\n";
                                                    }

                                                    if (ten == 0) {
                                                        Sten = "";
                                                    } else if (hundrade > 1) {
                                                        Sten = "     " + ten + " Ten Dollar Bills\n";
                                                    } else {
                                                        Sten = "     1 Ten Dollar Bill\n";
                                                    }

                                                    if (five == 0) {
                                                        Sfive = "";
                                                    } else if (five > 1) {
                                                        Sfive = "     " + five + " Five Dollar Bills\n";
                                                    } else {
                                                        Sfive = "     1 Five Dollar Bill\n";
                                                    }

                                                    if (one == 0) {
                                                        Sone = "";
                                                    } else if (one > 1) {
                                                        Sone = "     " + one + " One Dollar Bills\n";
                                                    } else {
                                                        Sone = "     1 One Dollar Bill\n";
                                                    }

                                                    if (quarter == 0) {
                                                        Squarter = "";
                                                    } else if (quarter > 1) {
                                                        Squarter = "     " + quarter + " Quarters\n";
                                                    } else {
                                                        Squarter = "     1 Quarter\n";
                                                    }

                                                    if (dime == 0) {
                                                        Sdime = "";
                                                    } else if (dime > 1) {
                                                        Sdime = "     " + dime + " Dimes\n";
                                                    } else {
                                                        Sdime = "     1 Dime\n";
                                                    }

                                                    if (nickel == 0) {
                                                        Snickel = "";
                                                    } else if (nickel > 1) {
                                                        Snickel = "     " + nickel + " Nickels\n";
                                                    } else {
                                                        Snickel = "     1 Nickel\n";
                                                    }

                                                    if (penny == 0) {
                                                        Spenny = "";
                                                    } else if (penny > 1) {
                                                        Spenny = "     " + penny + "  Pennies\n";
                                                    } else {
                                                        Spenny = "     1 Penny\n";
                                                    }

                                                    JOptionPane.showMessageDialog(null, String.format("Sales Tax:        $%.2f", tax)
                                                            + String.format("\n Total Due:        $%.2f", total)
                                                            + String.format("\n Change :          $%.2f \n", Change)
                                                            + Shundrade + Sfifty + Stwenty + Sten + Sfive + Sone
                                                            + Squarter + Sdime + Snickel + Spenny);
                                                    y = sz + 1;
                                                    i = sz + 1;
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "given amount not enought to pay");
                                                    y = sz + 1;
                                                    i = sz + 1;
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "IS NOT A NUMBER");
                                                break;
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Too many decimals or to many spaces");
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "NOT A NUMBER");
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "IS NOT A NUMBER");
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "NOT A NUMBER");

                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Too many decimals or too many spaces");
                }

            } else {

                JOptionPane.showMessageDialog(null, "NOT A NUMBER");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NOT A NUMBER");

        }
    }

}
