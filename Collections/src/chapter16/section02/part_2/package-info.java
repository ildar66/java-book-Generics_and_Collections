/**
 * LinkedHashMap.
 * *
 * Like LinkedHashSet (chapter 13.1.2), the class {@link java.util.LinkedHashMap} refines the contract of its parent class, HashMap,
 * by guaranteeing the order in which iterators return its elements.
 * Unlike {@link java.util.LinkedHashSet}, however, LinkedHashMap offers a choice of iteration orders;
 * elements can be returned either in the order in which they were inserted in the map, or in the order in which they were accessed
 * (from least-recently to most-recently accessed).
 * An accessordered {@link java.util.LinkedHashMap} is created by supplying an argument of true for the last parameter of the constructor:
 * public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
 * *
 * Supplying false will give an insertion-ordered map.
 * The other constructors, which are just like those of HashMap, also produce insertion-ordered maps.
 * As with LinkedHashSet, iteration over a LinkedHashMap takes time proportional only to the number of elements in the map, not its capacity.
 * *
 * Access-ordered maps are especially useful for constructing Least Recently Used (LRU) caches.
 * A cache is an area of memory that stores frequently accessed data for fast access.
 * In designing a cache, the key issue is the choice of algorithm that will be used to decide what data to remove in order to conserve memory.
 * When an item from a cached data set needs to be found, the cache will be searched first.
 * Typically, if the item is not found in the cache, it will be retrieved from the main store and added to the cache. But the cache cannot be allowed
 * to continue growing indefinitely, so a strategy must be chosen for removing the least useful item from the cache when a new one is added.
 * If the strategy chosen is LRU, the entry removed will be the one least recently used. This simple strategy is suitable for situations in which
 * an access of an element increases the probability of further access in the near future of the same element.
 * Its simplicity and speed have made it the most popular caching strategy.
 * *
 * Cache construction with LinkedHashMap is further aided by removeEldestEntry, the single method that it adds to those inherited from HashMap:
 * protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
 * *
 * The contract for removeEldestEntry states that the methods put and putAll will call removeEldestEntry whenever a new entry is added to the map,
 * passing to it the “eldest” entry. In an insertion-ordered map, the eldest entry will be the one that was least recently added to the map,
 * but in an access-ordered map it is the one least recently accessed (and if some entries have never been accessed, it is the one amongst these
 * which was least recently added).
 * In LinkedHashMap itself, removeEldestEntry does nothing and returns false, but subclasses can override it to return true under some circumstances.
 * The contract for this method specifies that although it may itself remove the eldest entry, it must return false if it has done so,
 * since it is expected that a return value of true will cause its calling method to do the removal.
 * *
 * A simple example of removeEldes tEntry would allow a map to grow to a given maximum size
 * and then maintain that size by deleting the eldest entry each time a new one is added:
 * {@link chapter16.section02.part_2.BoundedSizeMap}
 * *
 * Notice that an insertion-ordered LinkedHashMap that overrides removeEldestEntry as shown above will implement a FIFO strategy.
 * FIFO caching has often been used in preference to LRU because it is much simpler to implement in maps that do not offer access ordering.
 * However LRU is usually more effective than FIFO, because the reduced cost of cache refreshes outweighs the overhead of maintaining access
 * ordering.
 * *
 * Iteration over a collection of keys or values returned by a {@link java.util.LinkedHashMap} is linear in the number of elements.
 * The iterators over such collections are fail-fast.
 */
package chapter16.section02.part_2;