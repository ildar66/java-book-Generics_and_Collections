package chapter01.section04;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Methods and var arguments.
 */
public class GenericMethodsAndVarargs {

    public static void main(String[] args) {
        List<Integer> ints = Lists.toList(new Integer[] {1, 2, 3});
        List<String> words = Lists.toList(new String[] {"hello", "world"});

        //Now the method may be invoked as follows:
        ints = Lists2.toList(1, 2, 3);
        words = Lists2.toList("hello", "world");

        ints = new ArrayList<Integer>();
        addAll(ints, 1, 2);
        addAll(ints, new Integer[] {3, 4});
        assert ints.toString().equals("[1, 2, 3, 4]");

        //In the preceding examples, the type parameter to the generic method is inferred,
        // but it may also be given explicitly, as in the following examples:
        ints = Lists2.<Integer>toList(1, 2, 3);
        List<Object> objs = Lists2.<Object>toList(1, "two");
    }

    // Any number of arguments may precede a last vararg argument.
    public static <T> void addAll(List<T> list, T... arr) {
        for (T elt : arr) list.add(elt);
    }
}

// Here is a method that accepts an array of any type and converts it to a list:
class Lists {

    // The static method toList accepts an array of type T[] and returns a list of type  List<T>, and does so for any type T.
    public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }
}

/** At run time, the arguments are packed into an array which is passed to the method, just as in {@link Lists}. */
class Lists2 {

    // To use this feature, we replace T[] with T… in the method declaration:
    public static <T> List<T> toList(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }
}
