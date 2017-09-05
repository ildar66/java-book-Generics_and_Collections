/**
 * TreeMap.
 * *
 * SortedMap is implemented in the Collections Framework by {@link java.util.TreeMap}.
 * We met trees as a data structure for storing elements in order when we discussed TreeSet (see chapter 13.2.2).
 * In fact, the internal representation of a {@link java.util.TreeSet} is just a TreeMap in which every key is associated with the same standard
 * value, so the explanation of the mechanism and performance of red-black trees given in chapter 13.2.2 applies equally here.
 * *
 * The constructors for {@link java.util.TreeMap} include, besides the standard ones, one that allows you to supply a Comparator
 * and one that allows you to create one from another SortedMap, using both the same comparator and the same mappings:
 * public TreeMap(Comparator<? super K> comparator)
 * public TreeMap(SortedMap<K, ? extends V> m)
 * Notice that the second of these constructors suffer from a similar problem to the corresponding constructor of TreeSet (see chapter 13.2.2),
 * because the standard conversion constructor always uses the natural ordering of the keys, even when its argument is actually a SortedMap.
 * *
 * {@link java.util.TreeMap} has similar performance characteristics to {@link java.util.TreeSet}:
 * the basic operations (get, put, and remove) perform in O(log n) time).
 * The collection view iterators are fail-fast.
 */
package chapter16.section03.part_2;