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
 * Among {@link java.util.Deque} implementations {@link java.util.LinkedList} is an oddity; for example,
 * it is alone in permitting null elements, which are discouraged by the Queue interface because of the common use of null as a special value.
 * It has been in the Collections Framework from the start, originally as one of the standard implementations of {@link java.util.List}
 * (see chapter15.2), and was retrofitted with the methods of {@link java.util.Queue} for Java 5, and those of {@link java.util.Deque} for Java 6.
 * It is based on a linked list structure similar to those we saw in chapter13.2.3 as the basis for skip lists, but with an extra field in each cell,
 * pointing to the previous entry. These pointers allow the list to be traversed backwards—for example, for reverse iteration,
 * or to remove an element from the end of the list.
 * *
 * As an implementation of {@link java.util.Deque}, {@link java.util.LinkedList} is unlikely to be very popular.
 * Its main advantage, that of constant-time insertion and removal, is rivalled in Java 6—for queues and deques—by the otherwise superior ArrayDeque.
 * Previously you would have used it in situations where thread safety isn’t an issue and you don’t require blocking behavior.
 * Now, the only likely reason for using LinkedList as a queue or deque implementation would be that you also needed random access to the elements.
 * With {@link java.util.LinkedList}, even that comes at a high price;
 * because random access has to be implemented by linear search, it has time complexity of O(n).
 * The constructors for {@link java.util.LinkedList} are just the standard ones of chapter12.3.
 * Its iterators are fail-fast.
 */
package chapter14.section04.part_1;