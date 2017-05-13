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
 * *
 * **************** {@link java.util.concurrent.DelayQueue} ****************
 * This is a specialized priority queue, in which the ordering is based on the delay time for each element —
 * the time remaining before the element will be ready to be taken from the queue.
 * If all elements have a positive delay time—that is, none of their associated delay times has expired —
 * an attempt to poll the queue will return null (although peek will still allow you to see the first unexpired element).
 * If one or more elements has an expired delay time, the one with the longest-expired delay time will be at the head of the queue.
 * The elements of a {@link java.util.concurrent.DelayQueue} belong to a class that implements {@link java.util.concurrent.Delayed}:
 * *
 * interface Delayed extends Comparable<Delayed> {
 * long getDelay(TimeUnit unit);
 * }
 * *
 * The getDelay() method of a {@link java.util.concurrent.Delayed} object returns the remaining delay associated with that object.
 * The compareTo() method (see chapter3.1) of {@link java.lang.Comparable} must be defined to give results that are consistent
 * with the delays of the objects being compared. This means that it will rarely be compatible with equals(),
 * so Delayed objects are not suitable for use with implementations of {@link java.util.SortedSet} and {@link java.util.SortedMap}.
 * For example,
 * in our to-do manager we are likely to need reminder tasks, to ensure that we follow up e-mail and phone messages that have gone unanswered.
 * We could define a new class {@link chapter14.section03.part_2.DelayedTask}, and use it to implement a reminder queue.
 * *
 * Most queue operations respect delay values and will treat a queue with no unexpired elements as if it were empty.
 * The exceptions are peek() and remove(), which, perhaps surprisingly, will allow you to examine the head element
 * of a {@link java.util.concurrent.DelayQueue} whether or not it is expired.
 * Like them and unlike the other methods of {@link java.util.Queue}, collection operations on a DelayQueue do not respect delay values.
 * @see chapter14.section03.part_2.DelayedTask#main(java.lang.String[])
 * *
 * DelayQueue shares the performance characteristics of the {@link java.util.PriorityQueue} on which it is based and,
 * like it, has fail-fast iterators.
 * The comments on {@link java.util.concurrent.PriorityBlockingQueue} iterators apply to these too.
 * *
 * *************** {@link java.util.concurrent.SynchronousQueue} **********************
 * At first sight, you might think there is little point to a queue with no internal capacity, which is a short description of SynchronousQueue.
 * But, in fact, it can be very useful; a thread that wants to add an element to a SynchronousQueue must wait until another thread is ready
 * to simultaneously take it off, and the same is true—in reverse—for a thread that wants to take an element off the queue.
 * So SynchronousQueue has the function that its name suggests, that of a rendezvous — a mechanism for synchronizing two threads.
 * (Don’t confuse the concept of synchronizing threads in this way—allowing them to cooperate by exchanging data
 * — with Java’s keyword synchronized, which prevents simultaneous execution of code by different threads.)
 * *
 * There are two constructors for SynchronousQueue:
 * SynchronousQueue()
 * SynchronousQueue(boolean fair)
 * *
 * A common application for SynchronousQueue is in work-sharing systems where the design ensures that there are enough consumer threads to ensure
 * that producer threads can hand tasks over without having to wait. In this situation, it allows safe transfer of task data between threads
 * without incurring the {@link java.util.concurrent.BlockingQueue} overhead of enqueuing, then dequeuing, each task being transferred.
 * *
 * As far as the Collection methods are concerned, a {@link java.util.concurrent.SynchronousQueue} behaves like an empty Collection;
 * Queue and BlockingQueue methods behave as you would expect for a queue with zero capacity, which is therefore always empty.
 * The iterator method returns an empty iterator, in which hasNext() always returns false.
 */
package chapter14.section03.part_2;