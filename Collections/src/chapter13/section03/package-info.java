/**
 * Comparing Set Implementations.
 * *
 * ****************** Comparative performance of different Set implementations *********************
 * *                        add          contains            next               notes
 * HashSet                  O(1)            O(1)             O(h/n)             h is the table capacity
 * LinkedHashSet            O(1)            O(1)             O(1)
 * CopyOnWriteArraySet      O(n)            O(n)             O(1)
 * EnumSet                  O(1)            O(1)             O(1)
 * TreeSet                  O(log n)        O(log n)         O(log n)
 * ConcurrentSkipListSet    O(log n)        O(log n)         O(1)
 * *************************************************************************************************
 * In the EnumSet implementation for enum types with more than 64 values, next has worst case complexity of O(log m),
 * where m is the number of elements in the enumeration.
 * *
 * Table shows the comparative performance of the different Set implementations.
 * When you are choosing an implementation, of course, efficiency is only one of the factors you should take into account.
 * Some of these implementations are specialized for specific situations;
 * for example, {@link java.util.EnumSet} should always (and only) be used to represent sets of enum.
 * Similarly, {@link java.util.concurrent.CopyOnWriteArraySet} should only be used where set size will remain relatively small,
 * read operations greatly outnumber writes, thread safety is required, and read-only iterators are acceptable.
 * *
 * That leaves the general-purpose implementations: {@link java.util.HashSet}, {@link java.util.LinkedHashSet}, {@link java.util.TreeSet},
 * and {@link java.util.concurrent.ConcurrentSkipListSet}.
 * The first three are not thread-safe, so can only be used in multi-threaded code either in conjunction with client-side locking,
 * or wrapped in {@link java.util.Collections#synchronizedSet(java.util.Set)}  (see chapter17.3.1).
 * For single-threaded applications where there is no requirement for the set to be sorted,
 * your choice is between {@link java.util.HashSet} and {@link java.util.LinkedHashSet}.
 * If your application will be frequently iterating over the set, or if you require access ordering, LinkedHashSet is the implementation of choice.
 * *
 * Finally, if you require the set to sort its elements, the choice is between {@link java.util.TreeSet} and ConcurrentSkipListSet.
 * In a multi-threaded environment, {@link java.util.concurrent.ConcurrentSkipListSet} is the only sensible choice.
 * Even in single-threaded code ConcurrentSkipListSet may not show a significantly worse performance for small set sizes.
 * For larger sets, however, or for applications in which there are frequent element deletions,
 * {@link java.util.TreeSet} will perform better if your application doesn’t require thread safety.
 */
package chapter13.section03;