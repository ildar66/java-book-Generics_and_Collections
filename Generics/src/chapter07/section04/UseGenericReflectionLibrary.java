package chapter07.section04;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * As an example of the use GenericReflection library.
 */
public class UseGenericReflectionLibrary {

    public static <T, C extends Collection<T>> C copy(C coll) throws InvocationTargetException, NoSuchMethodException,
                                                                     InstantiationException, IllegalAccessException {
        C copy = GenericReflection.newInstance(coll);
        copy.addAll(coll);
        return copy;
    }

    public static <T> T[] toArray(Collection<T> c, T[] a) {
        if (a.length < c.size())
            a = GenericReflection.newArray(a, c.size());
        int i = 0;
        for (T x : c) a[i++] = x;
        if (i < a.length) a[i] = null;
        return a;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> copyList = copy(list);

        HashSet<String> set = new HashSet<>();
        HashSet<String> copySet = copy(set);
    }
}
