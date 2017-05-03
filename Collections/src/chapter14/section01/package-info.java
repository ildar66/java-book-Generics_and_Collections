/**
 * Using the Methods of {@link java.util.Queue}.
 * *
 * Let’s look at examples of the use of these methods.
 * Queues should provide a good way of implementing a task manager, since their main purpose is to yield up elements, such as tasks, for processing.
 * For the moment we shall use {@link java.util.ArrayDeque} as the fastest and most straightforward implementation of Queue (and also of Deque).
 * But, as before, we shall confine ourselves to the methods of the interface — though you should note that,
 * in choosing a queue implementation, you are also choosing an ordering.
 * With ArrayDeque, you get FIFO ordering — well, our attempts to get organized using fancy scheduling methods never seem to work very well;
 * perhaps it’s time to try something simpler.
 * *
 * {@link java.util.ArrayDeque} is unbounded, so we could use either add() or offer() to set up the queue with new tasks.
 * Queue<Task> taskQueue = new ArrayDeque<Task>();
 * taskQueue.offer(mikePhone);
 * taskQueue.offer(paulPhone);
 * *
 * Any time we feel ready to do a task, we can take the one that has reached the head of the queue:
 * Task nextTask = taskQueue.poll();
 * if (nextTask != null) { // process nextTask }
 * *
 * The choice between using poll() and remove() depends on whether we want to regard queue emptiness as an exceptional condition.
 * Realistically — given the nature of the application — that might be a sensible assumption, so this is an alternative:
 * try {
 * Task nextTask = taskQueue.remove();
 * // process nextTask
 * } catch (NoSuchElementException e) {
 * // but we *never* run out of tasks!
 * }
 * *
 * This scheme needs some refinement to allow for the nature of different kinds of tasks.
 * Phone tasks fit into relatively short time slots, whereas we don’t like to start coding
 * unless there is reasonably substantial time to get into the task.
 * So if time is limited— say, until the next meeting—we might like to check that the next task is of the right kind before we take it off the queue:
 * Task nextTask = taskQueue.peek();
 * if (nextTask instanceof PhoneTask) {
 * taskQueue.remove();
 * // process nextTask
 * }
 * *
 * These inspection and removal methods are a major benefit of the {@link java.util.Queue} interface;
 * {@link java.util.Collection} has nothing like them (though {@link java.util.NavigableSet} now does).
 * The price we pay for this benefit is that the methods of Queue are useful to us only if the head element is actually one that we want.
 * True, the class {@link java.util.PriorityQueue} allows us to provide a comparator that will order the queue elements so that the one we want
 * is at the head, but that may not be a particularly good way of expressing the algorithm for choosing the next task
 * (for example, if you need to know something about all the outstanding tasks before you can choose the next one).
 * So in this situation, if our to-do manager is entirely queue-based, we may end up going for coffee until the meeting starts.
 * As an alternative, we could consider using the {@link java.util.List} interface, which provides more flexible means of accessing its elements
 * but has the drawback that its implementations provide much less support for multi-thread use.
 * *
 * This may sound too pessimistic; after all, Queue is a subinterface of Collection, so it inherits methods that support traversal, like iterator.
 * In fact, although these methods are implemented, their use is not recommended in normal situations.
 * In the design of the queue classes, efficiency in traversal has been traded against fast implementation of the methods of Queue;
 * in addition, queue iterators do not guarantee to return their elements in proper sequence and, for some concurrent queues,
 * will actually fail in normal conditions (see chapter14.3.2).
 * *
 * In the next section we shall look at the direct implementations of Queue—PriorityQueue and {@link java.util.concurrent.ConcurrentLinkedQueue} —
 * and, in chapter14.3, at {@link java.util.concurrent.BlockingQueue} and its implementations.
 * The classes in these two sections differ widely in their behavior.
 * Most of them are thread-safe; most provide blocking facilities (that is, operations that wait for conditions to be right for them to execute);
 * some support priority ordering;
 * one — {@link java.util.concurrent.DelayQueue} — holds elements until their delay has expired, and
 * another —{@link java.util.concurrent.SynchronousQueue} — is purely a synchronization facility.
 * In choosing between Queue implementations, you would be influenced more by these functional differences than by their performances.
 */
package chapter14.section01;