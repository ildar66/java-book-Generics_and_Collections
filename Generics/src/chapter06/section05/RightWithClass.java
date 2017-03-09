package chapter06.section05;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class RightWithClass {

    public static <T> T[] toArray(Collection<T> c, Class<T> k) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(k, c.size()); // unchecked cast
        int i = 0;
        for (T x : c) a[i++] = x;
        return a;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two");
        String[] a = toArray(strings, String.class);
        assert Arrays.toString(a).equals("[one, two]");
    }
}
