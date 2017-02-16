package chapter02.section06;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Wildcards Versus Type Parameters.
 */
public class WildcardsVersusTypeParameters {

    /* Wildcards. Here are the types that the methods have in Java with generics:
    interface Collection<E> {
        ...
        public boolean contains(Object o);
        public boolean containsAll(Collection<?> c);
        ...
    }*/

    /* Type Parameters. You might reasonably choose an alternative design for collections
    — a design in which you can only test containment for subtypes of the element type:*/
    interface MyCollection<E> { // alternative design

        // ...
        public boolean contains(E o);

        public boolean containsAll(Collection<? extends E> c);
        // ...
    }

    public static void main(String[] args) {
        // These methods let us test for membership and containment:
        Object obj = "one";
        List<Object> objs = Arrays.<Object>asList("one", 2, 3.14, 4);
        List<Integer> ints = Arrays.asList(2, 4);
        assert objs.contains(obj);
        assert objs.containsAll(ints);
        assert !ints.contains(obj);
        assert !ints.containsAll(objs);

        /* In this case, the object may be contained in the list of integers because it happens to be an integer,
         and the list of objects may be contained within the list of integers because every object in the list happens to be an integer.*/
        obj = 1;
        objs = Arrays.<Object>asList(1, 3);
        ints = Arrays.asList(1, 2, 3, 4);
        assert ints.contains(obj);
        assert ints.containsAll(objs);

        // Say we have a class MyList that implements MyCollection. Now the tests are legal only one way around:
        /*
        Object obj = "one";
        MyList<Object> objs = MyList.<Object>asList("one", 2, 3.14, 4);
        MyList<Integer> ints = MyList.asList(2, 4);
        assert objs.contains(obj);
        assert objs.containsAll(ints)
        assert !ints.contains(obj); // compile-time error
        assert !ints.containsAll(objs); // compile-time error
        */
    }
}
