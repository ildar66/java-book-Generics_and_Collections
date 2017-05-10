/**
 * Implementing {@link java.util.concurrent.BlockingQueue}.
 * *
 * The Collections Framework provides five implementations of {@link java.util.concurrent.BlockingQueue}.
 * ************ {@link java.util.concurrent.LinkedBlockingQueue} *************
 * This class is a thread-safe, FIFO-ordered queue, based on a linked node structure.
 * It is the implementation of choice whenever you need an unbounded blocking queue.
 * Even for bounded use, it may still be better than {@link java.util.concurrent.ArrayBlockingQueue}
 * (linked queues typically have higher throughput than array-based queues but less predictable performance in most concurrent applications).
 * *
 * The two standard collection constructors create a thread-safe blocking queue with a capacity of Integer.MAX_VALUE.
 * You can specify a lower capacity using a third constructor:
 * LinkedBlockingQueue(int capacity)
 * *
 * The ordering imposed by LinkedBlockingQueue is FIFO.
 * Queue insertion and removal are executed in constant time; operations such as contains which require traversal of the array require linear time.
 * The iterators are weakly consistent.
 * *
 * ************ {@link java.util.concurrent.ArrayBlockingQueue} ************
 * This implementation is based on a circular array—a linear structure in which the first and last elements are logically adjacent.
 * The position labeled “head” indicates the head of the queue; each time the head element is removed from the queue, the head index is advanced.
 * Similarly, each new element is added at the tail position, resulting in that index being advanced.
 * When either index needs to be advanced past the last element of the array, it gets the value 0.
 * If the two indices have the same value, the queue is either full or empty,
 * so an implementation must separately keep track of the count of elements in the queue.
 * *
 * A circular array in which the head and tail can be continuously advanced in this way this is better as a queue implementation
 * than a noncircular one (e.g., the standard implementation of ArrayList, which we cover in Section 15.2) in which removing the head element
 * requires changing the position of all the remaining elements so that the new head is at position 0.
 * Notice, though, that only the elements at the ends of the queue can be inserted and removed in constant time.
 * If an element is to be removed from near the middle, which can be done for queues via the method Iterator.remove,
 * then all the elements from one end must be moved along to maintain a compact representation.
 * As a result, insertion and removal of elements in the middle of the queue has time complexity O(n).
 * *
 * Constructors for array-backed collection classes generally have a single configuration parameter, the initial length of the array.
 * For fixed-size classes like ArrayBlockingQueue, this parameter is necessary in order to define the capacity of the collection.
 * (For variable-size classes like ArrayList, a default initial capacity can be used, so constructors are provided that don’t require the capacity.)
 * For {@link java.util.concurrent.ArrayBlockingQueue}, the three constructors are:
 * ArrayBlockingQueue(int capacity)
 * ArrayBlockingQueue(int capacity, boolean fair)
 * ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)
 * *
 * The Collection parameter to the last of these allows an ArrayBlockingQueue to be initialized with the contents of the specified collection,
 * added in the traversal order of the collection’s iterator. For this constructor,
 * the specified capacity must be at least as great as that of the supplied collection, or be at least 1 if the supplied collection is empty.
 * Besides configuring the backing array, the last two constructors also require a boolean argument to control how the queue will handle
 * multiple blocked requests. These will occur when multiple threads attempt to remove items from an empty queue or enqueue items on to a full one.
 * When the queue becomes able to service one of these requests, which one should it choose?
 * The alternatives are to require a guarantee that the queue will choose the one that has been waiting longest
 * — that is, to implement a fair scheduling policy — or to allow the implementation to choose one.
 * Fair scheduling sounds like the better alternative, since it avoids the possibility that an unlucky thread might be delayed indefinitely but,
 * in practice, the benefits it provides are rarely important enough to justify incurring the large overhead that it imposes on a queue’s operation.
 * If "fair" scheduling is not specified, ArrayBlockingQueue will normally approximate fair operation, but with no guarantees.
 * *
 * The ordering imposed by {@link java.util.concurrent.ArrayBlockingQueue} is FIFO.
 * Queue insertion and removal are executed in constant time;
 * operations such as contains which require traversal of the array require linear time.
 * The iterators are weakly consistent.
 * *
 * **************** {@link java.util.concurrent.PriorityBlockingQueue} *************
 * This implementation is a thread-safe, blocking version of {@link java.util.PriorityQueue} (see chapter14.2),
 * with similar ordering and performance characteristics.
 * Its iterators are failfast, so in normal use they will throw ConcurrentModificationException; only if the queue is quiescent will they succeed.
 * To iterate safely over a {@link java.util.concurrent.PriorityBlockingQueue}, transfer the elements to an array and iterate over that instead.
 */
package chapter14.section03.part_2;