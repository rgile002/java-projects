
package average;

import javax.swing.JOptionPane;

/**
 *
 * @author GRK
 */
public class Average {

    public static boolean isInteger(String s) {
        int start = 0;

        if ((s.charAt(0) == '-') || (s.charAt(0) == '+')) {
            if (s.length() > 1) {
                start = 1;
            } else {
                return false;
            }
        }

        for (int i = start; i < s.length(); i = i + 1) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int GetScore(int n) {
        String s;

        s = JOptionPane.showInputDialog("Enter score " + n + " of the student");
        if (s == null) {
            JOptionPane.showMessageDialog(null, "you press cancel");
            return -1;

        }
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "you press ok without intering a value");
            return -1;
        }

        if (!isInteger(s)) {
            JOptionPane.showMessageDialog(null, " You must enter an Integer");
            return -1;

        }

        int value = Integer.parseInt(s);

        if (value < 0 || value > 100) {
            JOptionPane.showMessageDialog(null, "Integer must Be betwen 0 and 100");
            return -1;
        }

        return value;
    }

    public static int GetScore3Time(int n) {
        int count = 1;
        int score;
        String s = "Tries";

        while (count <= 3) {
            score = GetScore(n);

            if (score < 0 || score > 100) {
                if ((3 - count) < 2) {
                    s = "try";
                }
                if (count == 3) {
                    JOptionPane.showMessageDialog(null, (3 - count) + " " + s + "Remaining");
                }

                JOptionPane.showMessageDialog(null, "Try again " + (3 - count) + " " + s + "Remaining");
                count = count + 1;
            } else {
                return score;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        final int NumberOfScore = 4;
        int score;

        double average;
        int count = 1;
        double total = 0;

        while (count <= NumberOfScore) {

            score = GetScore3Time(count);
            if (score < 0) {
                JOptionPane.showMessageDialog(null, "The Program is terminating");
                System.exit(0);
            }
            total = total + score;
            count = count + 1;
        }

        average = total / NumberOfScore;
        JOptionPane.showMessageDialog(null, "Student average is: " + String.format("%.2f", average));
    }

}
