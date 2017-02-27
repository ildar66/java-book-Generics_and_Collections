package chapter04.section04;

import java.util.Arrays;
import java.util.List;

/**
 * How Erasure Works.
 */
public class HowErasureWorks {

    public static void main(String[] args) {
        // assert Overloaded.sum(Arrays.asList(1,2,3)) == 6;
        assert Overloaded.sum(Arrays.asList("a", "b")).equals("ab");

        // assert Overloaded2.allZero(Arrays.asList(0,0,0));
        assert Overloaded2.allZero(Arrays.asList("", "", ""));
    }
}

/* Here are the erasures of the signatures of the two methods:
    // TODO  ??? (the signature of a method does not include its return type)
    int sum(List)
    String sum(List)*/
class Overloaded {

    /* public static int sum(List<Integer> ints) {
        int sum = 0;
        for (int i : ints) sum += i;
        return sum;
    }*/

    public static String sum(List<String> strings) {
        StringBuffer sum = new StringBuffer();
        for (String s : strings) sum.append(s);
        return sum.toString();
    }
}

/* We change the methods so that each appends its result to the end of the argument list rather than returning a value:
    boolean allZero(List)
    */
class Overloaded2 {

    // compile-time error, cannot overload two methods with same erasure
    /* public static boolean allZero(List<Integer> ints) {
        for (int i : ints) if (i != 0) return false;
        return true;
    }*/

    public static boolean allZero(List<String> strings) {
        for (String s : strings) if (s.length() != 0) return false;
        return true;
    }
}

/*
    // Here is a bad version of the integer class, that tries to make it possible to compare an integer with either an integer or a long:
    class Integer implements Comparable<Integer>, Comparable<Long> {
    // compile-time error, cannot implement two interfaces with same erasure
    private final int value;
    public Integer(int value) { this.value = value; }
    public int compareTo(Integer i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
    public int compareTo(Long l) {
        return (value < l.value) ? -1 : (value == l.value) ? 0 : 1;
    }
}*/
