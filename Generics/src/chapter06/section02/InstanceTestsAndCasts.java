package chapter06.section02;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Instance Tests and Casts.
 */
public class InstanceTestsAndCasts {

    /* The cast does not report a warning because the source of the cast has type Collection<T>,
    and any object with this type that implements the interface List must, in fact, have type List<T>.*/
    public static <T> List<T> asList(Collection<T> c) throws /*Invalid*/IllegalArgumentException {
        if (c instanceof List<?>) {
            return (List<T>) c;
        } else throw new /*Invalid*/IllegalArgumentException("Argument not a list");
    }
}

/*
    // This code works because Integer is a reifiable typetype:
    // all of the information needed to check whether an object is an instance of Integer is available at run time.
public class Integer extends Number {
    private final int value;
    public Integer(int value) { this.value=value; }
    public int intValue() { return value; }
    public boolean equals(Object o) {
        if (o instanceof Integer) {
            return value == ((Integer)o).intValue();
        } else return false;
    }
    ...
}*/

/*
    // This code does not work because List<E> is not a reifiable type:
    // some of the information needed to check whether an object is an instance of List<E> is not available at run time.
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    public boolean equals(Object o) {
        if (o instanceof List<E>) { // compile-time error
            Iterator<E> it1 = iterator();
            Iterator<E> it2 = ((List<E>) o).iterator(); // unchecked cast
            while (it1.hasNext() && it2.hasNext()) {
                E e1 = it1.next();
                E e2 = it2.next();
                if (!(e1 == null ? e2 == null : e1.equals(e2)))
                    return false;
            }
            return !it1.hasNext() && !it2.hasNext();
        } else return false;
    }
    ...
}*/

// To fix the problem, we replace the nonreifiable type List<E> with the reifiable type List<?>.
/*public*/ abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    public boolean equals(Object o) {
        if (o instanceof List<?>) {
            Iterator<E> it1 = iterator();
            Iterator<?> it2 = ((List<?>) o).iterator();
            while (it1.hasNext() && it2.hasNext()) {
                E e1 = it1.next();
                Object e2 = it2.next();
                if (!(e1 == null ? e2 == null : e1.equals(e2)))
                    return false;
            }
            return !it1.hasNext() && !it2.hasNext();
        } else return false;
    }

    // ...
}