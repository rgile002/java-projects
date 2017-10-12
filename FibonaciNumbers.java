
package fibonacinumbers;

/**
 *
 * @author Rolf Kinder Gilet 
 */
public class FibonaciNumbers {

    public static void main(String[] args) {
        for (int i=0; i<7; i++){
        System.out.println(recursivFib(i));
         System.out.println("Geoff (i) = " + Geoff(i));
         System.out.println("Geoff (i) = " + interativegeoff(i));
        }
    }

    public static long recursivFib(int n) {
        // the base cases
        if (n == 0 || n == 1) {
            return 1L;
        }
        return recursivFib(n - 1) + recursivFib(n - 2);
    }


          
 public static long interativegeoff(int n) {
       long last = 0l;
        long current = 1l;
        
        if (n < 0) {
            throw new IllegalArgumentException("negative number");
        }
        if (n ==0) {
            return 0l;
        }
        if (n <2) {
            return 1l;
        }
        for (int i = 1; i < n; i++) {
            long temp = current;
            current += 2*last;           
            last = temp;          
        }
        return current;
 }

          // compute the n-th Geoff number
          private static long Geoff(int n)
          {
              if (n <= 0)
                  return 0L;
              if (n == 1)
                  return 1L;
              return Geoff(n-1) + 2 * Geoff(n-2); // recurse

           }
}
