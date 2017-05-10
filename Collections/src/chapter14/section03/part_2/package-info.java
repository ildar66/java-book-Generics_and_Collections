/**
 * Implementing {@link java.util.concurrent.BlockingQueue}.
 * *
 * The Collections Framework provides five implementations of {@link java.util.concurrent.BlockingQueue}.
 * ************ LinkedBlockingQueue *************
 * This class is a thread-safe, FIFO-ordered queue, based on a linked node structure.
 * It is the implementation of choice whenever you need an unbounded blocking queue.
 * Even for bounded use, it may still be better than ArrayBlockingQueue
 * (linked queues typically have higher throughput than array-based queues but less predictable performance in most concurrent applications).
 * *
 * The two standard collection constructors create a thread-safe blocking queue with a capacity of Integer.MAX_VALUE.
 * You can specify a lower capacity using a third constructor:
 * LinkedBlockingQueue(int capacity)
 * *
 * The ordering imposed by LinkedBlockingQueue is FIFO.
 * Queue insertion and removal are executed in constant time; operations such as contains which require traversal of the array require linear time.
 * The iterators are weakly consistent.
 */
package chapter14.section03.part_2;