/**
 * Changing the Order of List Elements.
 * *
 * There are seven methods for reordering lists in various ways.
 * The simplest of these is swap, which exchanges two elements and, in the case of a List which implements RandomAccess, executes in constant time.
 * The most complex is sort, which transfers the elements into an array, applies a merge sort to them in time O(n log n),
 * and then returns them to the List.
 * All of the remaining methods execute in time O(n).
 * void reverse(List<?> list) // reverse the order of the elements
 * void rotate(List<?> list, int distance) // rotate the elements of the list; the element at index i is moved to index (distance + i) % list.size()
 * void shuffle(List<?> list) // randomly permute the list elements
 * void shuffle(List<?> list, Random rnd) // randomly permute the list using the randomness source rnd
 * <T extends Comparable<? super T>> void sort(List<T> list) // sort the supplied list using natural ordering
 * <T> void sort(List<T> list, Comparator<? super T> c) // sort the supplied list using the supplied ordering
 * void swap(List<?> list, int i, int j) // swap the elements at the specified positions
 * *
 * For each of these methods, except sort() and swap(), there are two algorithms, one using iteration and another using random access.
 * The method sort() transfers the List elements to an array, where they are sorted using — in the current implementation —
 * a mergesort algorithm with n log n performance. The method swap() always uses random access.
 * The standard implementations for the other methods in this section use either iteration or random access,
 * depending on whether the list implements the {@link java.util.RandomAccess} interface (see chapter 8.3).
 * If it does, the implementation chooses the randomaccess algorithm; even for a list that does not implement RandomAccess, however,
 * the random-access algorithms are used if the list size is below a given threshold, determined on a per-method basis by performance testing.
 */
package chapter17.section01.part_1;