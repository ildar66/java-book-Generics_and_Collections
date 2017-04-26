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
 */
package chapter13.section02.part_1;