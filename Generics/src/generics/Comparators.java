package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Comparators {

    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (cmp.compare(candidate, elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
        return max(coll, Comparators.<T>naturalOrder());
    }

    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp) {
        return max(coll, reverseOrder(cmp));
    }

    public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
        return max(coll, Comparators.<T>reverseOrder());
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return new Comparator<T>() {

            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
        return new Comparator<T>() {

            public int compare(T o1, T o2) {
                return cmp.compare(o2, o1);
            }
        };
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return new Comparator<T>() {

            public int compare(T o1, T o2) {
                return o2.compareTo(o1);
            }
        };
    }

    public static void main(String[] args) {
        Comparator<String> sizeOrder = new Comparator<String>() {

            public int compare(String s1, String s2) {
                return
                        s1.length() < s2.length() ? -1 :
                        s1.length() > s2.length() ? 1 :
                        s1.compareTo(s2);
            }
        };
        // Here is how to find the maximum and minimum of a list using the natural ordering and using the size ordering:
        Collection<String> strings = Arrays.asList("from", "aaa", "to", "zzz");
        assert max(strings).equals("zzz");
        assert min(strings).equals("aaa");
        assert max(strings, sizeOrder).equals("from");
        assert min(strings, sizeOrder).equals("to");

        // In the natural alphabetic ordering, "two" is greater than "three", whereas in the size ordering it is smaller:
        assert "two".compareTo("three") > 0;
        assert sizeOrder.compare("two", "three") < 0;
    }

    /**
     * The loop compares corresponding elements of the two lists,
     * and terminates when corresponding elements are found that are not equal
     * (in which case, the list with the smaller element is considered smaller)
     * or when the end of either list is reached (in which case, the shorter list is considered smaller).
     */
    public static <E> Comparator<List<E>> listComparator(final Comparator<? super E> comp) {
        return new Comparator<List<E>>() {

            public int compare(List<E> list1, List<E> list2) {
                int n1 = list1.size();
                int n2 = list2.size();
                for (int i = 0; i < Math.min(n1, n2); i++) {
                    int k = comp.compare(list1.get(i), list2.get(i));
                    if (k != 0) return k;
                }
                return (n1 < n2) ? -1 : (n1 == n2) ? 0 : 1;
            }
        };
    }
}
