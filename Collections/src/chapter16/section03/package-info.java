/**
 * SortedMap and NavigableMap.
 * *
 * Like SortedSet, the subinterface {@link java.util.SortedMap} adds to its contract a guarantee that its iterators will traverse the map in
 * ascending key order. Its definition is similar to that of {@link java.util.SortedSet}, with methods such as firstKey and headMap corresponding to
 * the SortedSet methods first and headSet. Also like SortedSet, the SortedMap interface has been extended in Java 6 by the subinterface
 * {@link java.util.NavigableMap}.
 * This section is structured like chapter 13.2 for the same reasons: SortedMap has been made obsolete by NavigableMap,
 * but it may be helpful for developers prevented for the moment from using Java 6 to have the two interfaces treated separately.
 * *
 * A SortedMap imposes an ordering on its keys, either that of their natural ordering or of a Comparator; but in either case the compare method must
 * be consistent with equals(), as the SortedMap will use compare to determine when a key is already in the map.
 * *
 * The extra methods defined by the SortedMap interface fall into three groups:
 * ****************** Getting the First and Last Elements ***************
 * K firstKey()
 * K lastKey()
 * If the set is empty, these operations throw a NoSuchElementException.
 * *
 * ***************** Retrieving the Comparator ***************
 * Comparator<? super K> comparator()
 * This method returns the map’s key comparator if it has been given one, instead of relying on the natural ordering of the keys.
 * Otherwise, it returns null.
 * *
 * ****************** Finding Subsequences *****************
 * SortedMap<K,V> subMap(K fromKey, K toKey)
 * SortedMap<K,V> headMap(K toKey)
 * SortedMap<K,V> tailMap(K fromKey)
 * These operations work like the corresponding operations in SortedSet:
 * the key arguments do not themselves have to be present in the map, and the sets returned include the fromKey
 * — if, in fact, it is present in the map — and do not include the toKey.
 */
package chapter16.section03;