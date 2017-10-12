
package countword;

import java.io.File;
import java.io.*;

import java.util.Scanner;

/**
 *
 * @author GRK
 */
public class CountWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        Scanner in = null;
        String name = null;
        try {
            System.out.print("Enter the name of the file");
            name = keyBoard.next();
            File inFile = new File(name);
            in = new Scanner(inFile);

        } catch (IOException e) {
            System.err.println("The file cannot be opened.");
            System.exit(1);
        }
        System.out.println("the number of The in the file");

        int count = 0;
        while (in.hasNext()) {
            String Current = in.next();
            if (Current.equalsIgnoreCase("the")) {
                count++;
            }
        }
        System.out.println("there are " + count + " of the's in the file " + name + ".");
        System.exit(0);
    }

}
