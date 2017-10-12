
import java.util.ArrayList;

/**
 *
 * @author GRK
 */
public class AvgLargest {

    public static void main(String[] args) {
    
        ArrayList<Integer> numbers;
        numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(100);
        numbers.add(10);
        System.out.println(numbers.size());
        
        System.out.println("The average is " + average (numbers));
        System.out.println("the largest integer is " + largest(numbers));
    }


    public static double average(ArrayList<Integer> v) {
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i);
        }
        double average = sum / v.size();    
        return average ;
    }

    public static int largest (ArrayList<Integer>v) {
        int Largest = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) > Largest)
            Largest = v.get(i);       
        }  
        return Largest ;
    }

}
