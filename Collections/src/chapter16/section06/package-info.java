/**
 * Comparing Map Implementations.
 * *
 * Table shows the relative performance of the different platform implementations of Map
 * (the column headed “next” shows the cost of the next operation of iterators over the key set).
 * As with the implementations of queue, your choice of map class is likely to be influenced more by
 * the functional requirements of your application and the concurrency properties that you need.
 * *
 * Some specialized situations dictate the implementation:
 * EnumMap should always (and only) be used for mapping from enums.
 * Problems such as the graph traversals described in chapter 16.2.4 call for IdentityHashMap.
 * For a sorted map, use TreeMap where thread safety is not required,
 * and ConcurrentSkipListMap otherwise.
 * *
 * ****************** Table. Comparative performance of different Map implementations **************
 * *                        get             containsKey             next            Notes
 * *************************************************************************************************
 * HashMap                  O(1)            O(1)                    O(h/n)      h is the table capacity
 * LinkedHashMap            O(1)            O(1)                    O(1)
 * IdentityHashMap          O(1)            O(1)                    O(h/n)      h is the table capacity
 * EnumMap                  O(1)            O(1)                    O(1)
 * TreeMap                  O(log n)        O(log n)                O(log n)
 * ConcurrentHashMap        O(1)            O(1)                    O(h/n)      h is the table capacity
 * ConcurrentSkipListMap    O(log n)        O(log n)                O(1)
 * *************************************************************************************************
 * *
 * That leaves the choice of implementation for general-purpose maps.
 * For concurrent applications, ConcurrentHashMap is the only choice.
 * Otherwise, favor LinkedHashMap over HashMap (and accept its slightlyworse performance)
 * if you need to make use of the insertion or access order of the map — for example, to use it as a cache.
 */
package chapter16.section06;