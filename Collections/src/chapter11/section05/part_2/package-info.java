/**
 * JDK 1.2: Synchronized Collections and Fail-Fast Iterators.
 * *
 * The performance cost of internal synchronization in the JDK 1.0 collections led the designers to avoid it
 * when the Collections Framework was first introduced in JDK 1.2.
 * *
 * Instead, the platform implementations of the interfaces List, Set, and Map widened the programmer’s choice of concurrency policies.
 * To provide maximum performance for single-threaded execution, the new collections provided no concurrency control at all.
 * (More recently, the same policy change has been made for the synchronized class {@link java.lang.StringBuffer}, which was complemented in Java 5
 * by its unsynchronized equivalent, {@link java.lang.StringBuilder}.)
 * *
 * Along with this change came a new concurrency policy for collection iterators.
 * The policy of the iterators for the Java 2 collections is to fail fast: every time they access the backing collection,
 * they check it for structural modification (which, in general, means that elements have been added or removed from the collection).
 * If they detect structural modification, they fail immediately, throwing {@link java.util.ConcurrentModificationException}
 * rather than continuing to attempt to iterate over the modified collection with unpredictable results.
 * Note that this fail-fast behavior is provided to help find and diagnose bugs; it is not guaranteed as part of the collection contract.
 * *
 * The appearance of Java collections without compulsory synchronization was a welcome development.
 * However, thread-safe collections were still required in many situations, so the Framework provided an option to use the new collections
 * with the old concurrency policy, by means of synchronized wrappers (see Chapter 17). These are created by calling one of the factory methods
 * in the {@link java.util.Collections} class, supplying an unsynchronized collection which it will encapsulate.
 * For example, to make a synchronized {@link java.util.List}, you could supply an instance of {@link java.util.ArrayList} to be wrapped.
 * The wrapper implements the interface by delegating method calls to the collection you supplied,
 * but the calls are synchronized on the wrapper object itself.
 * *
 * {@link chapter11.section05.SynchronizedArrayStack} shows a synchronized wrapper for the interface {@link chapter11.section05.Stack}.
 * To get a thread-safe Stack, you would write:
 * Stack threadSafe = new SynchronizedArrayStack(new ArrayStack());
 * This is the preferred idiom for using synchronized wrappers; the only reference to the wrapped object is held by the wrapper,
 * so all calls on the wrapped object will be synchronized on the same lock—that belonging to the wrapper object itself.
 * It’s important to have the synchronized wrappers available, but you won’t use them more than you have to,
 * because they suffer the same performance disadvantages as the legacy collections.
 * **************************************
 * Using Synchronized Collections Safely:
 * Even a class like {@link chapter11.section05.SynchronizedArrayStack}, which has fully synchronized methods and is itself thread-safe,
 * must still be used with care in a concurrent environment. For example, this client code is not thread-safe:
 * {@link chapter11.section05.SynchronizedArrayStack#notThreadSafe()}
 * The exception would be raised if the last element on the stack were removed by another thread
 * in the time between the evaluation of isEmpty and the execution of pop.
 * This is an example of a common concurrent program bug, sometimes called test-then-act,
 * in which program behavior is guided by information that in some circumstances will be out of date.
 * To avoid it, the test and action must be executed atomically.
 * *
 * For synchronized collections (as for the legacy collections), this must be enforced with client-side locking:
 * synchronized(stack) { if (!stack.isEmpty()) { stack.pop(); }
 * For this technique to work reliably,
 * the lock that the client uses to guard the atomic action should be the same one that is used by the methods of the synchronized wrapper.
 * In this example, as in the synchronized collections, the methods of the wrapper are synchronized on the wrapper object itself.
 * (An alternative is to confine references to the collection within a single client, which enforces its own synchronization discipline.
 * But this strategy has limited applicability.)
 * *
 * Client-side locking ensures thread-safety, but at a cost:
 * since other threads cannot use any of the collection’s methods while the action is being performed,
 * guarding a long-lasting action (say, iterating over an entire array) will have an impact on throughput.
 * This impact can be very large if the synchronized methods are heavily used;
 * unless your application needs a feature of the synchronized collections, such as exclusive locking,
 * the Java 5 concurrent collections are almost always a better option.
 * }
 */
package chapter11.section05.part_2;