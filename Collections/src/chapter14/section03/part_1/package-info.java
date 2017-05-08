/**
 * Using the Methods of {@link java.util.concurrent.BlockingQueue}.
 * *
 * A to-do manager that works for just one person at a time is very limited;
 * we really need a cooperative solution—one that will allow us to share both the production and the processing of tasks.
 * Example  shows {@link chapter14.section03.part_1.StoppableTaskQueue},
 * a simple version of a concurrent task manager based on {@link java.util.concurrent.PriorityBlockingQueue},
 * that will allow its users— us—to independently add tasks to the task queue as we discover the need for them,
 * and to take them off for processing as we find the time.
 * *
 * In this example, as in most uses of the java.util.concurrent collections,
 * the collection itself takes care of the problems arising from the interaction of different threads in adding or removing items from the queue.
 * Most of the code {@link chapter14.section03.part_1.StoppableTaskQueue} is instead solving the problem of providing an orderly shutdown mechanism.
 * The reason for this emphasis is that when we go on to use the class StoppableTaskQueue as a component in a larger system,
 * we will need to be able to stop daily task queues without losing task information.
 * Achieving graceful shutdown can often be a problem in concurrent systems:
 * for more detail, see Chapter 7 of Java Concurrency in Practice by Brian Goetz et. al. (Addison-Wesley).
 * *
 * The larger system will model each day’s scheduled tasks over the next year, allowing consumers to process tasks from each day’s queue.
 * An implicit assumption of the example of this section is that if there are no remaining tasks scheduled for this day,
 * a consumer will not wait for one to become available, but will immediately go on to look for a task in the next day’s queue.
 * (In the real world, we would go home at this point, or more likely go out to celebrate.)
 * This assumption simplifies the example, as we don’t need to invoke any of the blocking methods of PriorityBlockingQueue,
 * though we will use one method, drainTo(), from the {@link java.util.concurrent.BlockingQueue} interface.
 * *
 * There are a number of ways of shutting down a producer-consumer queue such as this; in the one we’ve chosen for this example,
 * the manager exposes a shutdown method that can be called by a “supervisor” thread in order to stop producers writing to the queue,
 * to drain it, and to return the result.
 * The shutdown() method sets a boolean stopped, which task-producing threads will read before trying to put a task on to the queue.
 * Task-consuming threads simply poll() the queue, returning null if no tasks are available.
 * The problem with this simple idea is that a producer thread might read the stopped flag, find it false,
 * but then be suspended for some time before it places its value on the queue.
 * We have to prevent this by ensuring that the shutdown() method, having stopped the queue,
 * will wait until all the pending values have been inserted before draining it.
 * *
 * {@link chapter14.section03.part_1.StoppableTaskQueue} achieves this using a semaphore—a thread-safe object that maintains fixed number of permits.
 * Semaphores are usually used to regulate access to a finite set of resources—a pool of database connections, for example.
 * The permits the semaphore has available at any time represent the resources not currently in use.
 * A thread requiring a resource acquires a permit from the semaphore, and releases it when it releases the resource.
 * If all the resources are in use, the semaphore will have no permits available;
 * at that point, a thread attempting to acquire a permit will block until some other thread returns one.
 * *
 * The semaphore in this example is used differently.
 * We don’t want to restrict producer threads from writing to the queue — it’s an unbounded concurrent queue, after all,
 * quite capable of handling concurrent access without help from us. We just want to keep a count of the writes currently in progress.
 * So we create the semaphore with the largest possible number of permits, which in practice will never all be required.
 * The producer method addTask() checks to see if the queue has been stopped—in which case its contract says it should return false —
 * and, if not, it acquires a permit using the semaphore method tryAcquire(), which does not block
 * (unlike the more commonly used blocking method acquire, tryAcquire returns false immediately if no permits are available).
 * This test-then-act sequence is made atomic to ensure that at any point visible to another thread the program maintains its invariant:
 * the number of unwritten values is no greater than the number of permits available.
 * *
 * The shutdown() method sets the stopped flag in a synchronized block (the usual way of ensuring that variable writes made by one thread
 * are visible to reads by another is for both writes and reads to take place within blocks synchronized on the same lock). Now the
 * addTask() method cannot acquire any more permits, and shutdown() just has to wait until all the permits previously acquired have been returned.
 * To do that, it calls acquire(), specifying that it needs all the permits;
 * that call will block until they are all released by the producer threads.
 * At that point, the invariant guarantees that there are no tasks still to be written to the queue, and shutdown can be completed.
 */
package chapter14.section03.part_1;