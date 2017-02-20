package chapter03.section01;

import java.math.BigDecimal;

/**
 * Comparable examples.
 */
public class ComparableSample {

    /* interface Comparable<T> {
           public int compareTo(T o);
       } */
    public static void main(String[] args) {
        // For instance, Integer implements Comparable<Integer>:
        Integer int0 = 0;
        Integer int1 = 1;
        assert int0.compareTo(int1) < 0;

        // Similarly, String implements Comparable<String>:
        String str0 = "zero";
        String str1 = "one";
        assert str0.compareTo(str1) > 0;

        // The type parameter to the interface allows nonsensical comparisons to be caught at compile time:
        Integer i = 0;
        String s = "one";
        // assert i.compareTo(s) < 0; // compile-time error

        // Comparison is not supported between arbitrary numerical types:
        Number m = new Integer(2);
        Number n = new Double(3.14);
        // assert m.compareTo(n) < 0; // compile-time error (Number class does not implement the Comparable interface.)

        // for java.math.BigDecimal, where the natural ordering is not consistent with equals:
        BigDecimal a = new BigDecimal("4.00");
        BigDecimal b = new BigDecimal("4.0");
        System.out.println("a.equals(b) = " + a.equals(b)); // a.equals(b) = false
        System.out.println("a.compareTo(b) = " + a.compareTo(b)); // a.compareTo(b) = 0

    }

    /*class Integer implements Comparable<Integer> {
        ...
        public int compareTo(Integer that) {
            return this.value < that.value ? -1 :
                   this.value == that.value ? 0 : 1 ;
        }
        ...
    }*/
    
    // But this code may give the wrong answer when there is overflow:
    /*
    class Integer implements Comparable<Integer> {
        ...
        public int compareTo(Integer that) {
            // bad implementation -- don't do it this way!
            return this.value - that.value;
        }
        ...
    }*/
}
