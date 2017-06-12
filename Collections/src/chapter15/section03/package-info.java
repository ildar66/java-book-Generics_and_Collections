/**
 * Comparing List Implementations.
 * *
 * Table gives the comparative performance for some sample operations on List classes.
 * Even though the choice here is much narrower than with queues or even sets, the same process of elimination can be used. As with queues,
 * the first question to ask is whether your application requires thread safety.
 * If so, you should use {@link java.util.concurrent.CopyOnWriteArrayList}, if you can—that is, if writes to the list will be relatively infrequent.
 * If not, you will have to use a synchronized wrapper (see chapter17.3.1) around {@link java.util.ArrayList} or {@link java.util.LinkedList}.
 * *
 * For most list applications the choice is between ArrayList and LinkedList, synchronized or not.
 * Once again, your decision will depend on how the list is used in practice.
 * If set() and get() predominate, or element insertion and removal is mainly at the end of the list, then ArrayList will be the best choice.
 * If, instead, your application needs to frequently insert and remove elements near the start of the list as part of a process that uses iteration,
 * {@link java.util.LinkedList} may be better. If you are in doubt, test the performance with each implementation.
 * A Java 6 alternative for single-threaded code that may be worth considering in the last case —
 * if the insertions and removals are actually at the start of the list — is to write to the {@link java.util.Deque} interface,
 * taking advantage of its very efficient {@link java.util.ArrayDeque} implementation. For relatively infrequent random access, use an iterator,
 * or copy the {@link java.util.ArrayDeque} elements into an array using toArray.
 * *
 * ****************** Table. Comparative performance of different list implementations ********************
 * *                        get     add     contains    next    remove(0)       iterator.remove
 * ArrayList                O(1)    O(1)    O(n)        O(1)    O(n)            O(n)
 * LinkedList               O(n)    O(1)    O(n)        O(1)    O(1)            O(1)
 * CopyOnWriteArrayList     O(1)    O(n)    O(n)        O(1)    O(n)            O(n)
 * ********************************************************************************************************
 * *
 * It is possible that, in a future release, {@link java.util.ArrayDeque} will be retrofitted to implement the {@link java.util.List} interface;
 * if that happens, it will become the implementation of choice for both {@link java.util.Queue} and List in single-threaded environments.
 */
package chapter15.section03;