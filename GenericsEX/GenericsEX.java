package generics.ex;

/**
 *
 * @author Rolf kinder Gilet
 */
public class GenericsEX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Triple<String> names = new Triple<String>("Mark","John","Bill");
        names.sort();
        System.out.println("The sorted names are : " + names.getFirst() + ", "
                + names.getSecond() + ", " + names.getThird() + ".");
 
    }
    
}
