package chapter03.section02;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Maximum of a Collection.
 */
public class MaximumOfCollection {

    // Takes a collection of type Collection<T> and returns a T, and it does this for any type T such that T is a subtype of Comparable<T>
    public static <T extends Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

    public static void main(String[] args) {
        // Since lnteger implements Comparable<Integer>):
        List<Integer> ints = Arrays.asList(0, 1, 2);
        // assert Collections.max(ints) == 2;
        // assert max(ints) == 2;
        assert max3(ints) == 2;
        System.out.println(max3(ints) == 2);

        // Since String implements Comparable<String>)
        List<String> strs = Arrays.asList("zero", "one", "two");
        // assert Collections.max(strs).equals("zero");
        // assert max(strs).equals("zero");
        assert max3(strs).equals("zero");
        System.out.println(max3(strs).equals("zero"));

        // But we may not choose T to be Number (since Number does not implement Comparable):
        List<Number> nums = Arrays.asList(0, 1, 2, 3.14);
        // assert max(nums) == 3.14; // compile-time error
    }

    // If efficiency is a pressing concern, you might want to rewrite the method to use an explicit iterator, as follows:
    // This allocates an iterator once instead of twice and performs one less comparison.
    public static <T extends Comparable<T>> T max2(Collection<T> coll) {
        Iterator<T> it = coll.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T elt = it.next();
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> T max3(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }
}
