package chapter02.section08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Restrictions on Wildcards.
 */
public class RestrictionsOnWildcards {

    public static void main(String[] args) {
        // INSTANCE CREATION:
        // List<?> list = new ArrayList<?>(); // compile-time error
        // Map<String, ? extends Number> map = new HashMap<String, ? extends Number>(); // compile-time error

        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i = 0; i < 10; i++) sink.add(i);
        double sum = 0;
        for (Number num : source) sum += num.doubleValue();

        // Nested wildcards are permitted. Hence, the following is legal:
        List<List<?>> lists = new ArrayList<List<?>>();
        lists.add(Arrays.asList(1, 2, 3));
        lists.add(Arrays.asList("four", "five"));
        assert lists.toString().equals("[[1, 2, 3], [four, five]]");
        // The wildcard type prohibits us from extracting elements from the inner lists as any type other than Object,
        // but since that is the type used by toString, this code is well typed.

        // GENERIC METHOD CALLS:
        List<?> list = Lists.factory();
        List<?> list2 = Lists.<Object>factory();
        // List<?> list3 = Lists.<?>factory(); // compile-time error
        List<List<?>> list4 = Lists.<List<?>>factory(); // ok
    }

}

class Lists {

    public static <T> List<T> factory() {
        return new ArrayList<T>();
    }
}