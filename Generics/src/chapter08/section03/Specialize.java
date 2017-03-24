package chapter08.section03;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

interface ListString extends List<String> {

}

/**
 * A more efficient version might skip the use of AbstractList and Abstract-SequentialList,
 * and instead directly delegate all 25 methods of the {@link List} interface together with the toString method
 * (see the source code for {@link java.util.Collections#checkedList(List, Class)}. for a model).
 */
class ListStrings {

    public static ListString wrap(final List<String> list) {

        /* Class Random implements the five methods that must be provided by a subclass of AbstractList */
        class Random extends AbstractList<String> implements ListString, RandomAccess {

            public int size() {
                return list.size();
            }

            public String get(int i) {
                return list.get(i);
            }

            public String set(int i, String s) {
                return list.set(i, s);
            }

            public String remove(int i) {
                return list.remove(i);
            }

            public void add(int i, String s) {
                list.add(i, s);
            }
        }

        /* Similarly, class Sequential implements the two methods that must be provided by a subclass of AbstractSequentialList,
           where the second of these returns a class that implements the nine methods of the ListIterato interface.*/
        class Sequential extends AbstractSequentialList<String> implements ListString {

            public int size() {
                return list.size();
            }

            public ListIterator<String> listIterator(int index) {
                final ListIterator<String> it = list.listIterator(index);
                return new ListIterator<String>() {

                    public void add(String s) {
                        it.add(s);
                    }

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public boolean hasPrevious() {
                        return it.hasPrevious();
                    }

                    public String next() {
                        return it.next();
                    }

                    public int nextIndex() {
                        return it.nextIndex();
                    }

                    public String previous() {
                        return it.previous();
                    }

                    public int previousIndex() {
                        return it.previousIndex();
                    }

                    public void remove() {
                        it.remove();
                    }

                    public void set(String s) {
                        it.set(s);
                    }
                };
            }
        }
        return list instanceof RandomAccess ? new Random() : new Sequential();
    }
}

class ArrayListString extends ArrayList<String> implements ListString {

    public ArrayListString() {
        super();
    }

    public ArrayListString(Collection<? extends String> c) {
        super(c);
    }

    public ArrayListString(int capacity) {
        super(capacity);
    }
}

/*
//The security properties of specialization by inheritance can be improved by declaring
//a specialized signature for any method that adds an element to the list or sets an element:
    class ArrayListString extends ArrayList<String> implements ListString {
    public ArrayListString() { super(); }
    public ArrayListString(Collection<? extends String> c) { this.addAll(c); }
    public ArrayListString(int capacity) { super(capacity); }
    public boolean addAll(Collection<? extends String> c) {
        for (String s : c) {} // check that c contains only strings
        return super.addAll(c);
    }
    public boolean add(String element) { return super.add(element); }
    public void add(int index, String element) { super.add(index, element); }
    public String set(int index, String element) {
        return super.set(index, element);
    }
}*/

class Test {

    public static void testDelegation() {
        List<? extends List<?>> lists =
                Arrays.asList(
                        ListStrings.wrap(Arrays.asList("one", "two")),
                        Arrays.asList(3, 4),
                        Arrays.asList("five", "six"),
                        ListStrings.wrap(Arrays.asList("seven", "eight"))
                );
        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists)
            if (list instanceof ListString)
                array[i++] = (ListString) list;
        assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
    }

    public static void testInheritance() {
        List<? extends List<?>> lists =
                Arrays.asList(
                        new ArrayListString(Arrays.asList("one", "two")),
                        Arrays.asList(3, 4),
                        Arrays.asList("five", "six"),
                        new ArrayListString(Arrays.asList("seven", "eight"))
                );
        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists)
            if (list instanceof ListString)
                array[i++] = (ListString) list;
        assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
    }

    public static void main(String[] args) {
        testDelegation();
        testInheritance();
        // specialization by delegation has better security properties than specialization by inheritance:
        testSecurity();
    }

    private static void testSecurity() {
        List<String> original = new ArrayList<String>();
        ListString delegated = ListStrings.wrap(original);
        ListString inherited = new ArrayListString(original);
        delegated.add("one");
        inherited.add("two");
        try {
            ((List) delegated).add(3); // unchecked, class cast error
        } catch (ClassCastException e) {
        }
        ((List) inherited).add(4); // unchecked, no class cast error!
        assert original.toString().equals("[one]");
        assert delegated.toString().equals("[one]");
        assert inherited.toString().equals("[two, 4]");
    }
}
