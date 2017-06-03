/**
 * {@link java.util.concurrent.BlockingDeque}.
 * *
 * Methods that {@link java.util.concurrent.BlockingDeque} adds to {@link java.util.concurrent.BlockingQueue}.
 * Each of the two blocking insertion methods and two removal methods of {@link java.util.concurrent.BlockingQueue} is given a synonym
 * to make explicit which end of the deque it modifies, together with a matching method to provide the same action at the other end.
 * So offer(), for example, acquires a synonym offerLast() and a matching method offerFirst().
 * As a result, the same four basic behaviors that were defined for {@link java.util.concurrent.BlockingQueue} —
 * returning a special value on failure,
 * returning a special value on failure after a timeout,
 * throwing an exception on failure,
 * and blocking until success — can be applied for element insertion or removal at either end of the deque.
 * *
 * Good load balancing algorithms will be increasingly important as multicore and multiprocessor architectures become standard.
 * Concurrent deques are the basis of one of the best load balancing methods, work stealing.
 * To understand work stealing, imagine a load-balancing algorithm that distributes tasks in some way — round-robin, say—to a series of queues,
 * each of which has a dedicated consumer thread that repeatedly takes a task from the head of its queue, processes it, and returns for another.
 * Although this scheme does provide speedup through parallelism, it has a major drawback:
 * we can imagine two adjacent queues, one with a backlog of long tasks and a consumer thread struggling to keep up with them,
 * and next to it an empty queue with an idle consumer waiting for work.
 * It would clearly improve throughput if we allowed the idle thread to take a task from the head of another queue.
 * Work stealing improves still further on this idea;
 * observing that for the idle thread to steal work from the head of another queue risks contention for the head element,
 * it changes the queues for deques and instructs idle threads to take a task from the tail of another thread’s deque.
 * This turns out to be a highly efficient mechanism, and is becoming widely used.
 * *
 * ************************* Implementing {@link java.util.concurrent.BlockingDeque} **************************
 * *
 * The interface {@link java.util.concurrent.BlockingDeque} has a single implementation, {@link java.util.concurrent.LinkedBlockingDeque}.
 * {@link java.util.concurrent.LinkedBlockingDeque} is based on a doubly linked list structure like that of {@link java.util.LinkedList}.
 * It can optionally be bounded so, besides the two standard constructors,
 * it provides a third which can be used to specify its capacity: LinkedBlockingDeque(int capacity)
 * It has similar performance characteristics to {@link java.util.concurrent.LinkedBlockingQueue} —
 * queue insertion and removal take constant time and operations such as contains, which require traversal of the queue, require linear time.
 * The iterators are weakly consistent.
 */
package chapter14.section04.part_2;