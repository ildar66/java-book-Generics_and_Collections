package chapter06.section08;

import java.util.Arrays;
import java.util.List;

/**
 * Array Creation and Varargs.
 */
public class ArrayCreationAndVarargs {

    public static void main(String[] args) {
        // Here are three calls to this method:
        // public static <E> List<E> asList(E... arr):
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        List<List<Integer>> x = Arrays.asList(a, b); // generic array creation

        // these three calls are equivalent to the following:
        a = Arrays.asList(new Integer[] {1, 2, 3});
        b = Arrays.asList(new Integer[] {4, 5, 6});
        // List<List<Integer>> x = Arrays.asList(new List<Integer>[] {a, b}); // generic array creation

    }

    public static <E> List<E> singleton(E elt) {
        return Arrays.asList(elt); // generic array creation
    }
}
