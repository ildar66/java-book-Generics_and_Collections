/**
 * {@link java.util.NavigableSet}.
 * *
 * {@link java.util.NavigableSet} was introduced in Java 6 to supplement deficiencies in {@link java.util.SortedSet}.
 * As we mentioned at the beginning of this section, new client code should use it in preference to {@link java.util.SortedSet}.
 * It adds methods in four groups.
 * *********** Getting the First and Last Elements **********
 * E pollFirst() // retrieve and remove the first (lowest) element, or return null if this set is empty
 * E pollLast() // retrieve and remove the last (highest) element, or return null if this set is empty
 * *
 * These are analogous to the methods of the same name in Deque (see chapter14.4),
 * and help to support the use of {@link java.util.NavigableSet} in applications which require queue functionality.
 * For example, in the version of the to-do manager in this section, we could get the highest-priority task off the list,
 * ready to be carried out, by means of this:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 7:)
 * *
 * Notice that although {@link java.util.Deque} also contains methods peekFirst and peekLast —
 * which allow clients to retrieve an element without removing it — {@link java.util.NavigableSet} has no need of them,
 * because their functions are already supplied by the methods first and last inherited from {@link java.util.SortedSet}.
 * *
 * ************* Getting Range Views *************
 * NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
 * NavigableSet<E> headSet(E toElement, boolean inclusive)
 * NavigableSet<E> tailSet(E fromElement, boolean inclusive)
 * *
 * This group is an improvement on the methods of the same name in {@link java.util.SortedSet},
 * which return subsets that are always inclusive of the lower bound and exclusive of the higher one.
 * The {@link java.util.NavigableSet} methods, by contrast, allow you to specify for each bound whether it should be inclusive or exclusive.
 * This makes it much easier to define range views over some sets.
 * We considered earlier the set containing all the medium-priority tasks up to and including the (medium-prioritized) mikePhone task.
 * To obtain that set using SortedSet, we would have to define it as a half-open interval, using a little-known technicality of string ordering.
 * But {@link java.util.NavigableSet} allows us to define it as a closed interval simply by specifying that the higher bound should be inclusive:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 8:)
 * *
 * ************* Getting Closest Matches *************
 * E ceiling(E e) // return the least element in this set greater than or equal to e, or null if there is no such element
 * E floor(E e) // return the greatest element in this set less than or equal to e, or null if there is no such element
 * E higher(E e) // return the least element in this set strictly greater than e, or null if there is no such element
 * E lower(E e) // return the greatest element in this set strictly less than e, or null if there is no such element
 * *
 * These methods are useful for short-distance navigation.
 * For example, suppose that we want to find, in a sorted set of strings, the last three strings in the subset that is bounded above by “x-ray”,
 * including that string itself if it is present in the set.
 * {@link java.util.NavigableSet} methods make this easy:
 * @see chapter13.section02.part_1.NavigableSetMethodsTest#main(java.lang.String[])(// 1:)
 * *
 * Notice that in line with a general trend in the design of the Collections Framework,
 * {@link java.util.NavigableSet} returns null values to signify the absence of elements where,
 * for example, the "first" and "last" methods of {@link java.util.SortedSet} would throw NoSuchElementException.
 * For this reason, you should avoid null elements in NavigableSets, and in fact the newer implementation,
 * {@link java.util.concurrent.ConcurrentSkipListSet}, does not permit them (though TreeSet must continue to do so, for backward compatibility).
 * *
 * ************ Navigating the Set in Reverse Order
 * NavigableSet<E> descendingSet() // return a reverse-order view of the elements in this set
 * Iterator<E> descendingIterator() // return a reverse-order iterator
 * *
 * Methods of this group make traversing a {@link java.util.NavigableSet} equally easy in the descending (that is, reverse) ordering.
 * As a simple illustration, let’s generalise the example above using the nearest-match methods.
 * Suppose that, instead of finding just the last three strings in the sorted set bounded above by “x-ray”,
 * we want to iterate over all the strings in that set, in descending order:
 * @see chapter13.section02.part_1.NavigableSetMethodsTest#main(java.lang.String[])(// 2:)
 * *
 * If the iterative processing involves structural changes to the set,
 * and the implementation being used is {@link java.util.TreeSet} (which has fail-fast iterators),
 * we will have to use an explicit iterator to avoid {@link java.util.ConcurrentModificationException}:
 * @see chapter13.section02.part_1.NavigableSetMethodsTest#main(java.lang.String[])(// 3:)
 */
package chapter13.section02.part_1;