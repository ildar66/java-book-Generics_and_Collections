package chapter02.section04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The Get and Put Principle examples.
 */
public class TheGetAndPutPrinciple {

    // Whenever you use an iterator, you get values out of a structure, so use an extends wildcard.
    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) {
            s += num.doubleValue();
        }
        return s;
    }

    // Whenever you use the add method, you put values into a structure, so use a super wildcard.
    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }

    // Whenever you both put values into and get values out of the same structure, you should  not use a wildcard.
    public static double sumCount(Collection<Number> nums, int n) {
        count(nums, n);
        return sum(nums);
    }

    public static void main(String[] args) {
        // Since this uses extends, all of the following calls are legal:
        List<Integer> ints = Arrays.asList(1, 2, 3);
        assert sum(ints) == 6.0;
        List<Double> doubles = Arrays.asList(2.78, 3.14);
        assert sum(doubles) == 5.92;
        List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
        assert sum(nums) == 8.92;

        // Since this uses super, all of the following calls are legal:
        ints = new ArrayList<Integer>();
        count(ints, 5);
        assert ints.toString().equals("[0, 1, 2, 3, 4]");
        nums = new ArrayList<Number>();
        count(nums, 5);
        nums.add(5.0);
        assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");
        List<Object> objs = new ArrayList<Object>();
        count(objs, 5);
        objs.add("five");
        assert objs.toString().equals("[0, 1, 2, 3, 4, five]");

        // Since there is no wildcard, the argument must be a collection of Number.
        nums = new ArrayList<Number>();
        double sum = sumCount(nums, 5);
        assert sum == 10;
    }

}
