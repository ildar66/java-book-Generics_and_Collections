/**
 * {@link java.util.concurrent.BlockingQueue}.
 * *
 * Java 5 added a number of classes to the Collections Framework for use in concurrent applications.
 * Most of these are implementations of the {@link java.util.Queue} subinterface {@link java.util.concurrent.BlockingQueue},
 * designed primarily to be used in producer-consumer queues.
 * *
 * One common example of the use of producer-consumer queues is in systems that perform print spooling;
 * client processes add print jobs to the spool queue, to be processed by one or more print service processes,
 * each of which repeatedly “consumes” the task at the head of the queue.
 * *
 * The key facilities that BlockingQueue provides to such systems are, as its name implies,
 * enqueuing and dequeueing methods that do not return until they have executed successfully.
 * So, for example, a print server does not need to constantly poll the queue to discover whether any print jobs are waiting;
 * it need only call the poll method, supplying a timeout, and the system will suspend it until either a queue element becomes available
 * or the timeout expires.
 * *
 * BlockingQueue defines seven new methods, in three groups:
 * ************* Adding an Element **************
 * boolean offer(E e, long timeout, TimeUnit unit) // insert e, waiting up to the timeout
 * void put(E e) // add e, waiting as long as necessary
 * *
 * The nonblocking overload of offer() defined in {@link java.util.Queue} will return false if it cannot immediately insert the element.
 * This new overload waits for a time specified using {@link java.util.concurrent.TimeUnit},
 * an {@link java.lang.Enum} which allows timeouts to be defined in units such as milliseconds or seconds.
 * *
 * Taking these methods together with those inherited from {@link java.util.Queue},
 * there are four ways in which the methods for adding elements to a {@link java.util.concurrent.BlockingQueue} can behave:
 * offer() returns false if it does not succeed immediately,
 * blocking offer() returns false if it does not succeed within its timeout,
 * add() throws an exception if it does not succeed immediately, and
 * put() blocks until it succeeds.
 * *
 * ************* Removing an Element ***************
 * E poll(long timeout, TimeUnit unit) // retrieve and remove the head, waiting up to the timeout
 * E take() // retrieve and remove the head of this queue, waiting as long as necessary
 * *
 * Again taking these methods together with those inherited from {@link java.util.Queue},
 * there are four ways in which the methods for removing elements from a {@link java.util.concurrent.BlockingQueue} can behave:
 * poll() returns null if it does not succeed immediately,
 * blocking poll() returns null if it does not succeed within its timeout,
 * remove() throws an exception if it does not succeed immediately, and
 * take() blocks until it succeeds.
 * *
 * ************* Retrieving or Querying the Contents of the Queue ***********
 * int drainTo(Collection<? super E> c) // clear the queue into c
 * int drainTo(Collection<? super E> c, int maxElements) // clear at most the specified number of elements into c
 * int remainingCapacity() // return the number of elements that would be accepted without blocking, or Integer.MAX_VALUE if unbounded
 * *
 * The drainTo() methods perform atomically and efficiently, so the second overload is useful in situations
 * in which you know that you have processing capability available immediately for a certain number of elements,
 * and the first is useful—for example— when all producer threads have stopped working.
 * Their return value is the number of elements transferred.
 * *
 * RemainingCapacity() reports the spare capacity of the queue, although as with any such value in multi-threaded contexts,
 * the result of a call should not be used as part of a test-then-act sequence;
 * between the test (the call of remaining Capacity) and the action (adding an element to the queue) of one thread,
 * another thread might have intervened to add or remove elements.
 * *
 * {@link java.util.concurrent.BlockingQueue} guarantees that the queue operations of its implementations will be threadsafe and atomic.
 * But this guarantee doesn’t extend to the bulk operations inherited from Collection — addAll(), containsAll(), retainAll() and removeAll()
 * — unless the individual implementation provides it.
 * So it is possible, for example, for addAll() to fail, throwing an exception, after adding only some of the elements in a collection.
 */
package chapter14.section03;