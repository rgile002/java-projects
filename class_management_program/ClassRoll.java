
package assignment.pkg4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GRK
 */
public class ClassRoll {
     private ArrayList<Student> Students = new ArrayList<Student>();
    private String title;
    private String filename;

    ClassRoll(String f) throws IOException {
        filename = f;

        String inpFileName = filename;
        File inpFile = new File(inpFileName);
        Scanner in = new Scanner(inpFile);
        title = in.nextLine();
        while (in.hasNext()) {
            Student temp = new Student(in.next(), in.next());
            temp.setScore1(in.nextInt());
            temp.setScore2(in.nextInt());
            temp.setScore3(in.nextInt());
            Students.add(temp);
        }
    }

    public void remove() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();
        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(l) == 0) {
                Students.remove(yi);
                return;
            }
        }
        System.out.println("Students not found");
    }

    public void sortNames() {

        Student temp;

        for (int i = 0; i < Students.size(); i++) {
            for (int j = i + 1; j < Students.size(); j++) {
                if (Students.get(i).compareTo(Students.get(j)) > 0) {

                    temp = Students.get(j);

                    Students.set(j, Students.get(i));
                    Students.set(i, temp);
                }
            }
        }

    }

    public void save() throws IOException {

        String fileName = filename;
        PrintWriter outFile = new PrintWriter(fileName);
        outFile.println(title);
        for (int i = 0; i < Students.size(); i++) {
            outFile.println(Students.get(i).getFname() + "     " + "\t" + Students.get(i).getLname() + "\t" + "" + String.format(" %8d %8d %8d ",
                    Students.get(i).getScore1(), Students.get(i).getScore2(), Students.get(i).getScore3()));

        }

        outFile.close();
    }

    public void display() {
        System.out.println(title);
        double sum = 0;
        int n = 0;

        int d = 0;
        String Space = new String();
        for (int i = 0; i < Students.size(); i = i + 1) {
            if (d < Students.get(i).getFname().length()) {
                d = (Students.get(i).getFname().length());
            }
        }
        int sp = 0;
        String Space1 = new String();

        for (int i = 0; i < Students.size(); i = i + 1) {
            if (sp < Students.get(i).getLname().length()) {
                sp = (Students.get(i).getLname().length());
            }
        }

        for (int i = 0; i < Students.size(); i++) {
            int spaceCount = 0;
            spaceCount = Students.get(i).getFname().length();
            while (spaceCount < d) {
                Space += " ";
                spaceCount++;
            }
            int spacecounte = 0;
            spacecounte = Students.get(i).getLname().length();
            while (spacecounte < sp) {
                Space1 += " ";
                spacecounte++;
            }
            System.out.println(Students.get(i).getFname() + Space + "   " + Students.get(i).getLname() + Space1 +" " + String.format(" %8d %8d %8d ",
                    Students.get(i).getScore1(), Students.get(i).getScore2(), Students.get(i).getScore3()) + String.format("%8.2f", Students.get(i).getAverage()));
            sum += Students.get(i).getScore1() + Students.get(i).getScore2() + Students.get(i).getScore3();
            n++;
            Space = "";
            Space1 = "";

        }
        System.out.println("The class average is: " + String.format("%8.2f", sum / (n * 3)));
    }

    public void add() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name ");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();

        String a = (f.substring(0, 1).toUpperCase() + f.substring(1).toLowerCase());

        String b = (l.substring(0, 1).toUpperCase() + l.substring(1).toLowerCase());

        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(b) == 0) {
                System.out.print("Student already exist");
                return;

            }
        }
        System.out.println("Enter Student's first score");
        int n1 = kb.nextInt();
        System.out.println("Enter Student's second score");
        int n2 = kb.nextInt();
        System.out.println("Enter Student's third score");
        int n3 = kb.nextInt();

        Student temp = new Student(a, b);
        temp.setScore1(n1);
        temp.setScore2(n2);
        temp.setScore3(n3);
        Students.add(temp);

    }

    public void changeScore1() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();
        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(l) == 0) {
                System.out.println("Enter the new score");
                int n1 = kb.nextInt();
                Students.get(yi).setScore1(n1);
                return;
            }
        }
        System.out.println("Students not found");
    }

    public void changeScore2() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();
        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(l) == 0) {
                System.out.println("Enter the new score");
                int n1 = kb.nextInt();
                Students.get(yi).setScore2(n1);
                return;
            }
        }
        System.out.println("Students not found");
    }

    public void changeScore3() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();
        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(l) == 0) {
                System.out.println("Enter the new score");
                int n1 = kb.nextInt();
                Students.get(yi).setScore3(n1);
                return;
            }
        }
        System.out.println("Students not found");
    }

    public void find() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the student's first name");
        String f = kb.next();
        System.out.println("Enter the student's last name");
        String l = kb.next();
        for (int yi = 0; yi < Students.size(); yi++) {
            if (Students.get(yi).getFname().compareToIgnoreCase(f) == 0 && Students.get(yi).getLname().compareToIgnoreCase(l) == 0) {
                System.out.println(Students.get(yi).getFname() + "\t" + Students.get(yi).getLname() + String.format(" %4d %4d %4d ",
                        Students.get(yi).getScore1(), Students.get(yi).getScore2(), Students.get(yi).getScore3()) + String.format("%8.2f", Students.get(yi).getAverage()));
                return;
            }
        }
        System.out.println("Students not found");
    }

    public String properSpace(int a) {
        int d = 0;
        String Space = new String();
        for (int i = 0; i < Students.size(); i = i + 1) {
            if (d < Students.get(i).getFname().length()) {
                d = (Students.get(i).getFname().length());
            }
            for (int ff = 1; ff < d; ff += 1) {
                Space += " ";
            }

        }
        return (Space + "\t");
    }

    public void sortAverage() {
        Student temp;

        for (int i = 0; i < Students.size(); i++) {
            for (int j = i + 1; j < Students.size(); j++) {
                if (Students.get(i).getAverage() < Students.get(j).getAverage()) {

                    temp = Students.get(j);

                    Students.set(j, Students.get(i));
                    Students.set(i, temp);
                }
            }
        }

    }

}
