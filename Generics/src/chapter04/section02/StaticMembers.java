package chapter04.section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Static Members.
 */
public class StaticMembers {

    public static void main(String[] args) {
        /* Because generics are compiled by erasure, at run time the classes List<Integer>, List<String>, and List<List<String>>
         are all implemented by a single class, namely List. You can see this using reflection:*/
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("one", "two");
        // Class associated with a list of integers at run time is the same as the class associated with a list of strings:
        assert ints.getClass() == strings.getClass();

        // Static members are shared across all instantiations of a class,
        // so the same count is incremented when allocating either a string or an integer cell.
        Cell<String> a = new Cell<String>("one");
        Cell<Integer> b = new Cell<Integer>(2);
        assert a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2;

        // The count is static, so it is a property of the class as a whole, not any particular instance.
        Cell.getCount(); // ok
        // Cell<Integer>.getCount(); // compile-time error
        // Cell<?>.getCount(); // compile-time error

        // For Cell2 - illegal:
        Cell2<String> a2 = new Cell2<String>("one");
        Cell2<Integer> b2 = new Cell2<Integer>(2);
        // assert Cell2.getValues().toString().equals("[one, 2]");

        // For Cell3 - ok:
        Cell3<String> a3 = new Cell3<String>("one");
        Cell3<Integer> b3 = new Cell3<Integer>(2);
        assert Cell3.getValues().toString().equals("[one, 2]");
    }
}

// Here is a class, Cell<T>, in which each cell has an integer identifier and a value of type T:
class Cell<T> {

    private final int id;
    private final T value;
    private static int count = 0;

    private static synchronized int nextId() {
        return count++;
    }

    public Cell(T value) {
        this.value = value;
        id = nextId();
    }

    public T getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static synchronized int getCount() {
        return count;
    }
}

// Second version of Cell, which attempts to use a static variable to keep a list of all values stored in any cell:
class Cell2<T> {

    private final T value;
    // private static List<T> values = new ArrayList<T>(); // illegal

    public Cell2(T value) {
        this.value = value;
        // values.add(value);
    }

    public T getValue() {
        return value;
    }

    // illegal:
    /*public static List<T> getValues() {
        return values;
    }*/
}

// If we want a list of all values kept in cells, then we need to use a list of objects, as in the following variant:
class Cell3<T> {

    private final T value;
    private static List<Object> values = new ArrayList<Object>(); // ok

    public Cell3(T value) {
        this.value = value;
        values.add(value);
    }

    public T getValue() {
        return value;
    }

    public static List<Object> getValues() {
        return values;
    } // ok
}
