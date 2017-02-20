package chapter03.section01;

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

    }
}
