/**
 * Comparing Queue Implementations.
 * *
 * Table shows the sequential performance, disregarding locking and CAS overheads, for some sample operations of the {@link java.util.Deque} and
 * {@link java.util.Queue} implementations we have discussed. These results should be interesting to you in terms of understanding the behavior
 * of your chosen implementation but, as we mentioned at the start of the chapter, they are unlikely to be the deciding factor.
 * Your choice is more likely to be dictated by the functional and concurrency requirements of your application.
 * *
 * ******************** Table. Comparative performance of different Queue and Deque implementations **************
 * *                            offer           peek            poll            size
 * PriorityQueue                O(log n)        O(1)            O(log n)        O(1)
 * ConcurrentLinkedQueue        O(1)            O(1)            O(1)            O(n)
 * ArrayBlockingQueue           O(1)            O(1)            O(1)            O(1)
 * LinkedBlockingQueue          O(1)            O(1)            O(1)            O(1)
 * PriorityBlockingQueue        O(log n)        O(1)            O(log n)        O(1)
 * DelayQueue                   O(log n)        O(1)            O(log n)        O(1)
 * LinkedList                   O(1)            O(1)            O(1)            O(1)
 * ArrayDeque                   O(1)            O(1)            O(1)            O(1)
 * LinkedBlockingDeque          O(1)            O(1)            O(1)            O(1)
 * ***************************************************************************************************************
 * In choosing a {@link java.util.Queue}, the first question to ask is whether the implementation you choose needs to support concurrent access;
 * if not, your choice is straightforward.
 * For FIFO ordering, choose {@link java.util.ArrayDeque};
 * for priority ordering, {@link java.util.PriorityQueue}.
 * *
 * If your application does demand thread safety, you next need to consider ordering.
 * If you need priority or delay ordering, the choice obviously must be {@link java.util.concurrent.PriorityBlockingQueue}
 * or {@link java.util.concurrent.DelayQueue}, respectively.
 * If, on the other hand, FIFO ordering is acceptable, the third question is whether you need blocking methods,
 * as you usually will for producer-consumer problems (either because the consumers must handle an empty queue by waiting,
 * or because you want to constrain demand on them by bounding the queue, and then producers must sometimes wait).
 * If you don’t need blocking methods or a bound on the queue size,
 * choose the efficient and wait-free {@link java.util.concurrent.ConcurrentLinkedQueue}.
 * *
 * If you do need a blocking queue, because your application requires support for producer-consumer cooperation,
 * pause to think whether you really need to buffer data, or whether all you need is to safely hand off data between the threads.
 * If you can do without buffering (usually because you are confident that there will be enough consumers to prevent data from piling up),
 * then {@link java.util.concurrent.SynchronousQueue} is an efficient alternative to the remaining FIFO blocking implementations,
 * {@link java.util.concurrent.LinkedBlockingQueue} and {@link java.util.concurrent.ArrayBlockingQueue}.
 * *
 * Otherwise, we are finally left with the choice between these two.
 * If you cannot fix a realistic upper bound for the queue size, then you must choose {@link java.util.concurrent.LinkedBlockingQueue},
 * as {@link java.util.concurrent.ArrayBlockingQueue} is always bounded.
 * For bounded use, you will choose between the two on the basis of performance. Their performance characteristics are the same,
 * but these are only the formulae for sequential access; how they perform in concurrent use is a different question.
 * As we mentioned above, {@link java.util.concurrent.LinkedBlockingQueue} performs better on the whole
 * than {@link java.util.concurrent.ArrayBlockingQueue} if more than three or four threads are being serviced.
 * This fits with the fact that the head and tail of a {@link java.util.concurrent.LinkedBlockingQueue} are locked independently,
 * allowing simultaneous updates of both ends.
 * On the other hand, an {@link java.util.concurrent.ArrayBlockingQueue} does not have to allocate new objects with each insertion.
 * If queue performance is critical to the success of your application,
 * you should measure both implementations with the benchmark that means the most to you: your application itself.
 */
package chapter14.section05;