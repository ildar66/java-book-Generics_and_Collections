package chapter06.section04;

import java.util.Arrays;
import java.util.List;

/**
 * Array Creation.
 */
public class ArrayCreation {

    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1, 2, 3};
        Number[] nums = ints;
        /* this is not compatible with the reified type attached to the array */
        nums[2] = 3.14; // array store exception
    }
}

/**
 * Because arrays must reify their component types,
 * it is an error to create a new array unless its component type is reifiable.
 */
class Annoying {
    /* public static <T> T[] toArray(Collection<T> c) {
        T[] a = new T[c.size()]; // compile-time error
        int i = 0;
        for (T x : c) a[i++] = x;
        return a;
    }*/
}

class AlsoAnnoying {

    public static List<Integer>[] twoLists() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        // return new List<Integer>[] {a, b}; // compile-time error
        return new List[] {a, b}; // Unchecked assignment !
    }
}
