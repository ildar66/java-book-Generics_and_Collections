/**
 * ConcurrentSkipListMap.
 * *
 * The relationship between {@link java.util.concurrent.ConcurrentSkipListMap} and {@link java.util.concurrent.ConcurrentSkipListSet} is like
 * that between TreeMap and TreeSet; a ConcurrentSkipListSet is implemented by a ConcurrentSkipListMap in which every key is associated with
 * the same standard value, so the mechanism and performance of the skip list implementation given in chapter 13.2.3 applies equally here:
 * the basic operations (get, put, and remove) perform inO(log n) time); iterators over the collection views execute next in constant time.
 * These iterators are fail-fast.
 */
package chapter16.section05.part_1;