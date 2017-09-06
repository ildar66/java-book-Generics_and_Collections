/**
 * ConcurrentMap.
 * *
 * Maps are often used in high-performance server applications — for example, as cache implementations
 * — so a high-throughput thread-safe map implementation is an essential part of the Java platform.
 * This requirement cannot be met by synchronized maps such as those provided by Collections.synchronizedMap, because with full synchronization
 * each operation needs to obtain an exclusive lock on the entire map, effectively serializing access to it.
 * Locking only a part of the collection at a time—lock striping— can achieve very large gains in throughput,
 * as we shall see shortly with ConcurrentHashMap. But because there is no single lock for a client to hold to gain exclusive access,
 * client-side locking no longer works, and clients need assistance from the collection itself to carry out atomic actions.
 * *
 * That is the purpose of the interface {@link java.util.concurrent.ConcurrentMap}.
 * It provides declarations for methods that perform compound operations atomically.
 * There are four of these methods:
 * V putIfAbsent(K key, V value) // associate key with value only if key is not currently present.
 * *                             // Return the old value (may be null) if the key was present, otherwise return null
 * boolean remove(Object key, Object value) // remove key only if it is currently mapped to value.
 * *                                        // Returns true if the value was removed, false otherwise
 * V replace(K key, V value) // replace entry for key only if it is currently present.
 * *                         // Return the old value (may be null) if the key was present, otherwise return null
 * boolean replace(K key, V oldValue, V newValue) // replace entry for key only if it is currently mapped to oldValue.
 * *                                              // Return true if the value was replaced, false otherwise
 */
package chapter16.section04;