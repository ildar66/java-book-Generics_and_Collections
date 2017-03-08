package chapter06.section05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Right {

    public static <T> T[] toArray(Collection<T> c, T[] a) {
        if (a.length < c.size())
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), c.size()); // unchecked cast
        int i = 0;
        for (T x : c) a[i++] = x;
        if (i < a.length) a[i] = null;
        return a;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two");
        String[] a = toArray(strings, new String[0]);
        assert Arrays.toString(a).equals("[one, two]");
        String[] b = new String[] {"x", "x", "x", "x"};
        toArray(strings, b);
        assert Arrays.toString(b).equals("[one, two, null, x]");
    }
}
