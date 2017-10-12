package generics.ex;

/**
 *
 * @author Rolf Kinder Gilet
 */
public class Triple<E extends Comparable<? super E>> {

    // The fields 

    private E first;
    private E second;
    private E third;

    /**
     * Creates a new instance of Triple with the parameters item1, item2, item3
     */
    public Triple(E item1, E item2, E item3) {
        first = item1;
        second = item2;
        third = item3;
    }

    // sort first, second, and third such that the smallest is in first, the in between
    // in second and the largest is in third

    public void sort() {
        // if first > second swap them
        if (first.compareTo(second) > 0) {
            // swap them
            E temp = first;
            first = second;
            second = temp;

        }
// if second > third, swap them
        if (second.compareTo(third) > 0) {
            E temp = second;
            second = third;
            third = temp;
        }
        // if first > second, swap them
        if (first.compareTo(second) > 0) {
            E temp = first;
            first = second;
            second = temp;
        }
    }

    // get the first field
    public E getFirst() {
        return first;
    }

    // get the second

    public E getSecond() {
        return second;
    }

    // get the third

    public E getThird() {
        return third;
    }

}
