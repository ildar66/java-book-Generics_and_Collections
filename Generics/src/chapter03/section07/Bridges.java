package chapter03.section07;

import java.lang.reflect.Method;

/**
 * Bridges.
 */
public class Bridges {

    public static void main(String[] args) {
        // You can see the bridge if you apply reflection:
        for (Method m : Integer.class.getMethods())
            if (m.getName().equals("compareTo"))
                System.out.println(m.toGenericString());
    }
}
// Legacy code for comparable integers:
/* interface Comparable {
    public int compareTo(Object o);
}
class Integer implements Comparable {
    private final int value;
    public Integer(int value) { this.value = value; }
    public int compareTo(Integer i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
    // The second method is necessary in order to override the compareTo method in the Comparable interface,
    // because overriding occurs only when the method signatures are identical. This second method is called a bridge.
    public int compareTo(Object o) {
        return compareTo((Integer)o);
    }
}*/

// Generic code for comparable integers
interface Comparable<T> {

    public int compareTo(T o);
}

class Integer implements Comparable<Integer> {

    private final int value;

    public Integer(int value) {
        this.value = value;
    }

    public int compareTo(Integer i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
}
