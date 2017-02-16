package chapter02.section05;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays examples.
 */
public class ArraysExamples {

    public static void main(String[] args) {
        // When an array is allocated, it is tagged with its reified type (a run-time representation of its component type, in this case, Integer):
        Integer[] ints = new Integer[] {1, 2, 3};
        Number[] nums = ints;
        nums[2] = 3.14; // array store exception
        assert Arrays.toString(ints).equals("[1, 2, 3.14]"); // uh oh!

        // In contrast, the subtyping relation for generics is invariant, meaning that type List<S> is not considered to be a subtype of List<T>:
        List<Integer> intsList = Arrays.asList(1, 2, 3);
        // List<Number> numsList = intsList; // compile-time error
        // numsList.set(2, 3.14);
        assert intsList.toString().equals("[1, 2, 3.14]"); // uh oh!

        /* Wildcards reintroduce covariant subtyping for generics,
            in that type List<S> is considered to be a subtype of List<? extends T> when S is a subtype of T.
            As with arrays, the third line is in error, but, in contrast to arrays, the problem is detected
            at compile time, not run time. */
        intsList = Arrays.asList(1, 2, 3);
        List<? extends Number> numsList = intsList;
        // numsList.set(2, 3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
    }
}
