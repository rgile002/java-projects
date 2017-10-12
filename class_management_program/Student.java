
package assignment.pkg4;

/**
 *
 * @author GRK
 */
public class Student {
    
private String fname;
    private String lname;
    private Exams scores; 
    Student(String f, String l) {
        fname = f;
        lname = l;
        scores= new Exams();
    }

    public void setScore1(int sc) {
        scores.setScore1(sc);
    }

    public void setScore2(int sc) {
        scores.setScore2(sc);
    }

    public void setScore3(int sc) {
        scores.setScore3(sc);
    }

    public double getAverage() {
        return (scores.getScore1() + scores.getScore2() + scores.getScore3()) / 3;
    }

    public int getScore1() {
        int y = scores.getScore1();
        return y;
    }

    public int getScore2() {
        int y = scores.getScore2();
        return y;
    }

    public int getScore3() {
        int y = scores.getScore3();
        return y;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String toStrign() {
        String s = scores.toString();

        String d = (fname + " \t " + lname + " \t  " + s);

        return d;

    }

    public int compareTo(Student s) {
        String StudentN = lname + " " + fname;
        String StudentS = s.lname + " " + s.fname;
        return StudentN.compareTo(StudentS);

    }
}

