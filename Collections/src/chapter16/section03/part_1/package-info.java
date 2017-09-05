/**
 * NavigableMap.
 * *
 * {@link java.util.NavigableMap} extends and replaces {@link java.util.SortedMap}, in the same way as NavigableSet replaces SortedSet.
 * Its methods correspond almost exactly to those of NavigableSet, regarding the map as a set of key-value associations represented by Map.Entry
 * objects. So where a NavigableSet method returns an element of the set, the corresponding NavigableMap method return a result of type Map.Entry.
 * Until now, objects of this type were only obtainable by iterating over the set returned by Map.entrySet, and were specified to become invalid in
 * the face of concurrent modification of the map. This specification is not appropriate to Map.Entry objects returned by the new methods,
 * and the contract for NavigableMap acknowledges this by specifying that the Map.Entry objects returned by its methods are snapshot objects
 * reflecting the state of the map at the time they were produced, and do not support setValue.
 * *
 * The methods added by NavigableMap can be divided into four groups.
 * ******************** Getting the First and Last Elements
 * Map.Entry<K,V> pollFirstEntry()
 * Map.Entry<K,V> pollLastEntry()
 * Map.Entry<K,V> firstEntry()
 * Map.Entry<K,V> lastEntry()
 * *
 * The first two methods are analogous to pollFirst() and pollLast() in NavigableSet.
 * The last two were introduced because the emphasis in NavigableMap on making map entries available requires entry-returning methods
 * corresponding to the key-returning methods first and last inherited from SortedMap.
 * *
 * ******************* Getting Range Views
 * NavigableMap<K,V> subMap( K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
 * NavigableMap<K,V> headMap(K toKey, boolean inclusive)
 * NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
 * *
 * Like the NavigableSet methods, these provide more flexibility than the range-view methods of SortedMap. Instead of always returning a half-open
 * interval, these methods accept boolean parameters that are used to determine whether to include the key or keys defining the interval.
 * *
 * ********************* Getting Closest Matches
 * Map.Entry<K,V> ceilingEntry(K Key)
 * K ceilingKey(K Key)
 * Map.Entry<K,V> floorEntry(K Key)
 * K floorKey(K Key)
 * Map.Entry<K,V> higherEntry(K Key)
 * K higherKey(K Key)
 * Map.Entry<K,V> lowerEntry(K Key)
 * K lowerKey(K Key)
 * *
 * These are similar to the corresponding closest-match methods of NavigableSet, but they return Map.Entry objects.
 * If you want the key belonging to one of these entries, use the corresponding convenience key-returning method, with the performance benefit of
 * allowing the map to avoid the unnecessary creation of a Map.Entry object.
 * *
 * **************** Navigating the Map
 * NavigableMap<K,V> descendingMap() // return a reverse-order view of the map
 * NavigableSet<K> descendingKeySet() // return a reverse-order key set
 * There is also a new method defined to obtain a NavigableSet of keys:
 * NavigableSet<K> navigableKeySet() // return a forward-order key set
 * *
 * You might wonder why the method keySet, inherited from Map, could not simply be overridden using a covariant return type to return a NavigableSet.
 * Indeed, the platform implementations of NavigableMap.keySet do return a NavigableSet. But there is a compatibility concern:
 * if TreeMap.keySet were to have its return type changed from Set to NavigableSet, any existing TreeMap subclasses which override that method
 * would now fail to compile unless they too changed their return type. (This concern is similar to those discussed in chapter 8.4.)
 */
package chapter16.section03.part_1;