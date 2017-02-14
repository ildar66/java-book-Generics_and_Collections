package chapter02.section03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Wildcards with super examples.
 */
public class WildcardsWithSuper {

    // from the convenience class Collections:
    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static void main(String[] args) {
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        assert objs.toString().equals("[5, 6, four]");

        /* As with any generic method, the type parameter may be inferred or may be given explicitly.
        In this case, there are four possible choices, all of which type-check and all of
        which have the same effect:*/
        Collections.copy(objs, ints);
        Collections.<Object>copy(objs, ints);
        Collections.<Number>copy(objs, ints);
        Collections.<Integer>copy(objs, ints);
    }
}
