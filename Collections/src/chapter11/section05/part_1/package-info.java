/**
 * Synchronization and the Legacy Collections.
 * *
 * Code like that in ArrayStack is not thread-safe — it works when executed by a single thread, but may break in a multi-threaded environment.
 * Since the incorrect behavior we observed involved two threads simultaneously executing the push method, we could change the program to make
 * that impossible.
 * *
 * Using synchronized to modify the declaration of the push method will guarantee that once a thread has started to execute it,
 * all other threads are excluded from that method until the execution is done:
 * public synchronized void push(int elt) { ... }
 * *
 * To safeguard the invariant and make ArrayStack as a whole thread-safe, the methods pop() and isEmpty must also be synchronized on the same object.
 * The method isEmpty() doesn’t write to shared data, so synchronizing it isn’t required to prevent a race condition, but for a different reason.
 * Each thread may use a separate memory cache, which means that writes by one thread may not be seen by another unless either they both take place
 * within blocks synchronized on the same lock, or unless the variable is marked with the "volatile" keyword.
 * *
 * Full method synchronization was, in fact, the policy of the collection classes provided in JDK1.0:
 * {@link java.util.Vector}, {@link java.util.Hashtable}, and their subclasses; all methods that access their instance data are synchronized.
 * These are now regarded as legacy classes to be avoided because of the high price this policy imposes on all clients of these classes,
 * whether they require thread safety or not.
 * *
 * Synchronization can be very expensive:
 * forcing threads to queue up to enter the critical section one at a time slows down the overall execution of the program,
 * and the overhead of administering locks can be very high if they are often contended.
 */
package chapter11.section05.part_1;