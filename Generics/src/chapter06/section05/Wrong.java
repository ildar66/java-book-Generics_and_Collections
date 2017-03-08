package chapter06.section05;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Wrong {

    public static <T> T[] toArray(Collection<T> c) {
        T[] a = (T[]) new Object[c.size()]; // unchecked cast
        int i = 0;
        for (T x : c) a[i++] = x;
        return a;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two");
        String[] a = toArray(strings); // class cast error
    }
}

// In order to see what went wrong with this program, let’s look at how the program is translated using erasure.
class Wrong_Translated {

    public static Object[] toArray(Collection c) {
        Object[] a = (Object[]) new Object[c.size()]; // unchecked cast
        int i = 0;
        for (Object x : c) a[i++] = x;
        return a;
    }

    public static void main(String[] args) {
        List strings = Arrays.asList(args);
        String[] a = (String[]) toArray(strings); // class cast error
    }
}