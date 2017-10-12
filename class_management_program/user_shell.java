
package assignment.pkg4;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author GRK
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
   
    
 public static void prompt() {
        System.out.println("a or add to add a student in the class roll ");
        System.out.println("sa or average to sort the students based on their average ");
        System.out.println("sn or names to sort the students based on their last names");
        System.out.println("r or remove to remove a student from the class roll");
        System.out.println("s or save to save the list of students back to the input datafile ");
        System.out.println("c1 or change1 to change score 1 of a student");
        System.out.println("c2 or change2 to change score 2 of a student");

        System.out.println("c3 or change3 to change score 3 of a student");
        System.out.println("f or find to find a student in the class roll");
        System.out.println("d or display to display the class roll");
        System.out.println("q or quit to exit the program");
    }

    public static void main(String[] args) throws IOException {

        System.out.print("What is the name of input file: ");

        Scanner kb = new Scanner(System.in);
        ClassRoll cop2210 = new ClassRoll(kb.next());
        System.out.println(" ");
        System.out.println("Enter one of the following commands");
        System.out.println(" ");
        prompt();
        boolean isDone = false;
        while (!isDone) {
            System.out.println(" ");
            System.out.print("Enter the next command: ");
            String imput = kb.next();
            switch (imput.toLowerCase()) {
                case "a":
                case "add":
                    cop2210.add();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "r":
                case "remove":
                    cop2210.remove();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "sn":
                case "names":
                    cop2210.sortNames();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "sa":
                case "average":
                    cop2210.sortAverage();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "s":
                case "save":
                    cop2210.save();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "c1":
                case "change1":
                    cop2210.changeScore1();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "c2":
                case "change":
                    cop2210.changeScore2();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "c3":
                case "change3":
                    cop2210.changeScore3();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "f":
                case "find":
                    cop2210.find();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "d":
                case "display":
                    cop2210.display();
                    System.out.println(" ");
                    System.out.println("Enter one of the following commands");
                    System.out.println(" ");
                    prompt();
                    break;
                case "q":
                case "quit":
                    System.out.println("Good Bye");
                    isDone = true;
                    break;

                default:
                    System.out.println("Command not found");
            }
        }

    }
}
