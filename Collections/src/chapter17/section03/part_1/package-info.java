/**
 * Synchronized Collections.
 * *
 * As we explained in chapter 11.5, most of the Framework classes are not thread-safe — by design —
 * in order to avoid the overhead of unnecessary synchronization (as incurred by the legacy classes Vector and Hashtable).
 * But there are occasions when you do need to program multiple threads to have access to the same collection,
 * and these synchronized wrappers are provided by the {@link java.util.Collections} class for such situations.
 * *
 * There are six synchronized wrapper factory methods, corresponding to the six pre-Java 6 interfaces of the Collections Framework.
 * (No synchronized wrappers were provided in Java 6 for NavigableSet or NavigableMap. If they had been provided, there would be
 * very few situations in which you would choose them over the thread-safe collections ConcurrentSkipListSet and ConcurrentSkipListMap.)
 * *
 * <T> Collection<T> synchronizedCollection(Collection<T> c);
 * <T> Set<T> synchronizedSet(Set<T> s);
 * <T> List<T> synchronizedList(List<T> list);
 * <K, V> Map<K, V> synchronizedMap(Map<K, V> m);
 * <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s);
 * <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m);
 * *
 * The classes that provide these synchronized views are conditionally thread-safe (see chapter 11.5);
 * although each of their operations is guaranteed to be atomic,
 * you may need to synchronize multiple method calls in order to obtain consistent behavior.
 * In particular, iterators must be created and used entirely within a code block synchronized on the collection;
 * otherwise, the result will at best be failure with {@link java.util.ConcurrentModificationException}.
 * This is very coarse-grained synchronization;
 * if your application makes heavy use of synchronized collections, its effective concurrency will be greatly reduced.
 */
package chapter17.section03.part_1;