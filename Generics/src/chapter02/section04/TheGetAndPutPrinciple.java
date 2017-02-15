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

        /* If an extends wildcard is present, pretty much all you will be able to do is get but not put values of that type.*/
        ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums2 = ints;
        double dbl = sum(nums2); // ok
        // nums2.add(3.14); // compile-time error

        /* if a super wildcard is present, pretty much all you will be able to do is put but not get values of that type.*/
        objs = new ArrayList<Object>();
        objs.add(1);
        objs.add("two");
        List<? super Integer> ints2 = objs;
        ints2.add(3); // ok
        // double dbl = sum(ints2); // compile-time error

        // You cannot put anything into a type declared with an extends wildcard—except for the value null, which belongs to every reference type:
        ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums3 = ints;
        nums3.add(null); // ok
        assert nums3.toString().equals("[1, 2, null]");

        // you cannot get anything out from a type declared with a super wildcard—
        // except for a value of type Object, which is a supertype of every reference type:
        objs = Arrays.<Object>asList(1, "two");
        List<? super Integer> ints3 = objs;
        String str = "";
        for (Object obj : ints3) str += obj.toString();
        assert str.equals("1two");
    }

}
