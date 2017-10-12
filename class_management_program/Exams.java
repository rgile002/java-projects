
package assignment.pkg4;

/**
 *
 * @author GRK
 */
public class Exams {
    
private int score1;
    private int score2;
    private int score3;

    public Exams( ) {
        score1 = 0;
        score2 = 0;
        score3 = 0;

    }

    public void setScore1(int sc) {
        score1 = sc;
       
    }

    public void setScore2(int sc) {
        score2 = sc;
    }

    public void setScore3(int sc) {
        score3 = sc;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    public String toStrign() {
        
        return (Integer.toString(score1) + "  " + (Integer.toString(score2)) + "  " + (Integer.toString(score3)));
    }

}

