/**
 * Implementing {@link java.util.Deque}.
 * *
 * ************** {@link java.util.ArrayDeque} *********************
 * Along with the interface {@link java.util.Deque}, Java 6 also introduced a very efficient implementation, {@link java.util.ArrayDeque},
 * based on a circular array like that of {@link java.util.concurrent.ArrayBlockingQueue} (see chapter14.3.2).
 * It fills a gap among {@link java.util.Queue} classes;
 * previously, if you wanted a FIFO queue to use in a single-threaded environment, you would have had to use the class {@link java.util.LinkedList}
 * (which we cover next, but which should be avoided as a general-purpose Queue implementation), or else pay an unnecessary overhead for thread
 * safety with one of the concurrent classes {@link java.util.concurrent.ArrayBlockingQueue} or {@link java.util.concurrent.LinkedBlockingQueue}.
 * *
 * {@link java.util.ArrayDeque} is now the general-purpose implementation of choice, for both deques and FIFO queues.
 * It has the performance characteristics of a circular array:
 * adding or removing elements at the head or tail takes constant time.
 * The iterators are fail-fast.
 * *
 * ******************** {@link java.util.LinkedList} ***************
 */
package chapter14.section04.part_1;