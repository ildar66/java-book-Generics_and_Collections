/**
 * Concurrent Collections: Java 5 and Beyond.
 * *
 * Java 5 introduced thread-safe concurrent collections as part of a much larger set of concurrency utilities, including primitives —
 * atomic variables and locks—which give the Java programmer access to relatively recent hardware innovations for managing concurrent threads,
 * notably compare-and-swap operations, explained below.
 * The concurrent collections remove the necessity for client-side locking as described in the previous section — in fact,
 * external synchronization is not even possible with these collections, as there is no one object which when locked will block all methods.
 * Where operations need to be atomic — for example, inserting an element into a Map only if it is currently absent —
 * the concurrent collections provide a method specified to perform atomically—in this case, ConcurrentMap.putIfAbsent.
 * *
 * If you need thread safety, the concurrent collections generally provide much better performance than synchronized collections.
 * This is primarily because their throughput is not reduced by the need to serialize access, as is the case with the synchronized collections.
 * Synchronized collections also suffer the overhead of managing locks, which can be high if there is much contention.
 * These differences can lead to efficiency differences of two orders of magnitude for concurrent access by more than a few threads.
 * *
 * ******* Mechanisms ******
 * The concurrent collections achieve thread-safety by several different mechanisms:
 * The first of these — the only one that does not use the new primitives — is copy-on-write.
 * Classes that use copy-on-write store their values in an internal array, which is effectively immutable;
 * any change to the value of the collection results in a new array being created to represent the new values.
 * Synchronization is used by these classes, though only briefly, during the creation of a new array;
 * because read operations do not need to be synchronized, copy-on-write collections perform well in the situations for which they are designed —
 * those in which reads greatly predominate over writes. Copy-on-write is used by the collection classes:
 * {@link java.util.concurrent.CopyOnWriteArrayList} and {@link java.util.concurrent.CopyOnWriteArraySet}.
 * *
 * A second group of thread-safe collections relies on compare-and-swap (CAS), a fundamental improvement on traditional synchronization.
 * To see how-it-works, consider a computation in which the value of a single variable is used as input to a long-running calculation
 * whose eventual result is used to update the variable.
 * Traditional synchronization makes the whole computation atomic, excluding any other thread from concurrently accessing the variable.
 * This reduces opportunities for parallel execution and hurts throughput. An algorithm based on CAS behaves differently:
 * it makes a local copy of the variable and performs the calculation without getting exclusive access.
 * Only when it is ready to update the variable does it call CAS,
 * which in one atomic operation compares the variable’s value with its value at the start and, if they are the same, updates it with the new value.
 * If they are not the same, the variable must have been modified by another thread;
 * in this situation, the CAS thread can try the whole computation again using the new value, or give up, or—in some algorithms— continue,
 * because the interference will have actually done its work for it!
 * Collections using CAS include {@link java.util.concurrent.ConcurrentLinkedQueue} and {@link java.util.concurrent.ConcurrentSkipListMap}.
 * *
 * The third group uses implementations of {@link java.util.concurrent.locks.Lock},
 * an interface introduced in Java 5 as a more flexible alternative to classical synchronization.
 * A Lock has the same basic behavior as classical synchronization, but a thread can also acquire it under special conditions:
 * only if the lock is not currently held, or with a timeout, or if the thread is not interrupted.
 * Unlike synchronized code, in which an object lock is held while a code block or a method is executed,
 * a Lock is held until its unlock method is called.
 * Some of the collection classes in this group make use of these facilities to divide the collection into parts that can be separately locked,
 * giving improved concurrency.
 * For example, {@link java.util.concurrent.LinkedBlockingQueue} has separate locks for the head and tail ends of the queue,
 * so that elements can be added and removed in parallel.
 * Other collections using these locks include {@link java.util.concurrent.ConcurrentHashMap} and most of the implementations of {@link
 * java.util.concurrent.BlockingQueue}.
 * *
 * **********Iterators*********
 */
package chapter11.section05.part_3;