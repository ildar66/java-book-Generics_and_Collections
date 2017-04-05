/**
 * The Main Interfaces of the Java Collections Framework,
 * together with one other — Iterable — which is outside the Framework but is an essential adjunct to it.
 * *
 * Its purpose is as follows:
 * • {@link java.lang.Iterable} defines the contract that a class has to fulfill for its instances to be usable with the foreach statement.
 * *
 * And the Framework interfaces have the following purposes:
 * • {@link java.util.Collection} contains the core functionality required of any collection other than a map.
 * It has no direct concrete implementations; the concrete collection classes all implement one of its sub-interfaces as well.
 * • {@link java.util.Set} is a collection, without duplicates, in which order is not significant.
 * {@link java.util.SortedSet} automatically sorts its elements and returns them in order.
 * {@link java.util.NavigableSet} extends this, adding methods to find the closest matches to a target element.
 * • {@link java.util.Queue} is a collection designed to accept elements at its "tail" for processing,
 * yielding them up at its "head" in the order in which they are to be processed.
 * Its sub-interface {@link java.util.Deque} extends this by allowing elements to be added or removed at both head and tail.
 * Queue and Deque have subinterfaces,
 * {@link java.util.concurrent.BlockingQueue} and {@link java.util.concurrent.BlockingDeque} respectively,
 * that support concurrent access and allow threads to be blocked, indefinitely or for a maximum time,
 * until the requested operation can be carried out.
 * • {@link java.util.List} is a collection in which order is significant, accommodating duplicate elements.
 * • {@link java.util.Map} is a collection which uses key-value associations to store and retrieve elements.
 * It is extended:
 * by {@link java.util.concurrent.ConcurrentMap}, which provides support for concurrent access,
 * by {@link java.util.SortedMap}, which guarantees to return its values in ascending key order,
 * by {@link java.util.NavigableMap} which extends SortedMap to find the closest matches to a target element, and
 * by {@link java.util.concurrent.ConcurrentNavigableMap} which extends ConcurrentMap and NavigableMap.
 * *
 * Chapters 12 through 16 will concentrate on each of the Collections Framework interfaces in turn.
 * First, though, in Chapter 11, we need to cover some preliminary ideas which run through the entire Framework design.
 */
package chapter10;