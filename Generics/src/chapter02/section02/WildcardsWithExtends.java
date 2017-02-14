package chapter02.section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wildcards with extends examples.
 */
public class WildcardsWithExtends {
    // The question mark is called a wildcard, since it stands for some type that is a subtype of E.
    /* interface Collection<E> {
        ...
        public boolean addAll(Collection<? extends E> c);
        ...
    }*/

    public static void main(String... args) {
        // The first call is permitted because nums has type List<Number>, which is a subtype of Collection<Number>,
        // and ints has type List<Integer>, which is a subtype of Collection<? extends Number>.. The second call is similarly permitted.
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");

        ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums2 = ints;
        // because you cannot add a double to a List<? extends Number>, since it might be a list of some other subtype of number
        // nums2.add(3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
    }
}
