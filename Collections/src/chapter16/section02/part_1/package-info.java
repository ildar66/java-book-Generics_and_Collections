/**
 * HashMap.
 * *
 * In discussing HashSet in chapgter 13.1.1, we mentioned that it delegates all its operations to a private instance of {@link java.util.HashMap}.
 * Removed the value elements from the map (all elements in a HashSet are stored as keys with the same constant value).
 * The discussion in chapter 13.1 of hash tables and their performance applies equally to HashMap.
 * In particular, HashMap provides constant-time performance for put and get. Although in principle constant-time performance is only attainable
 * with no collisions, it can be closely approached by the use of rehashing to control the load and thereby to minimize the number of collisions.
 * *
 * Iteration over a collection of keys or values requires time proportional to the capacity of the map plus the number of key-value mappings
 * that it contains.
 * The iterators are fail-fast.
 * *
 * Two constructors allow the programmer to configure a new instance of {@link java.util.HashMap}:
 * public HashMap(int initialCapacity)
 * public HashMap(int initialCapacity, float loadFactor)
 * These constructors are like those of HashSet, allowing specification of the initial capacity and, optionally,
 * the load factor at which the table will be rehashed.
 */
package chapter16.section02.part_1;