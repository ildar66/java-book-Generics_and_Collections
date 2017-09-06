/**
 * ConcurrentHashMap.
 * *
 * {@link java.util.concurrent.ConcurrentHashMap} provides an implementation of {@link java.util.concurrent.ConcurrentMap} and offers a highly
 * effective solution to the problem of reconciling throughput with thread safety. It is optimized for reading, so retrievals do not block
 * even while the table is being updated (to allow for this, the contract states that the results of retrievals will reflect the latest
 * update operations completed before the start of the retrieval). Updates also can often proceed without blocking, because a ConcurrentHashMap
 * consists of not one but a set of tables, called segments, each of which can be independently locked. If the number of segments is large enough
 * relative to the number of threads accessing the table, there will often be no more than one update in progress per segment at any time.
 * *
 * The constructors for {@link java.util.concurrent.ConcurrentHashMap} are similar to those of {@link java.util.HashMap},
 * but with an extra one that provides the programmer with control over the number of segments that the map will use (its concurrency level):
 * ConcurrentHashMap()
 * ConcurrentHashMap(int initialCapacity)
 * ConcurrentHashMap(int initialCapacity, float loadFactor)
 * ConcurrentHashMap( int initialCapacity, float loadFactor, int concurrencyLevel)
 * ConcurrentHashMap(Map<? extends K,? extends V> m)
 * *
 * The class ConcurrentHashMap is a useful implementation of Map in any application where it is not necessary to lock the entire table;
 * this is the one capability of SynchronizedMap which it does not support. That can sometimes present problems:
 * for example, the size method attempts to count the entries in the map without using locks. If the map is being concurrently updated, however,
 * the size method will not succeed in obtaining a consistent result. In this situation, it obtains exclusive access to the map by locking all the
 * segments, obtaining the entry count from each, then unlocking them again.
 * The performance cost involved in this is a justifiable tradeoff against the highly optimized performance for common operations, especially reads.
 * Overall, ConcurrentHashMap is indispensable in highly concurrent contexts, where it performs far better than any available alternative.
 * *
 * Disregarding locking overheads such as those just described, the cost of the operations of ConcurrentHashMap are similar to those of HashMap.
 * The collection views return weakly consistent iterators.
 */
package chapter16.section04.part_1;