/**
 * Implementations.
 * *
 * Because there is no “best” implementation of any of the interfaces, you have to make a trade-off,
 * judging which operations are used most frequently in your application and choosing the implementation that optimizes those operations.
 * *
 * The three main kinds of operations that most collection interfaces require are insertion and removal of elements by position,
 * retrieval of elements by content, and iteration over the collection elements.
 * *
 * We’ll briefly survey the four main structures used as the basis of the implementations:
 * ******
 * Arrays:
 * These are the structures familiar from the Java language—and just about every other programming language since Fortran.
 * Because arrays are implemented directly in hardware, they have the properties of random-access memory:
 * very fast for accessing elements by position and for iterating over them,
 * but slower for inserting and removing elements at arbitrary positions (because that may require adjusting the position of other elements).
 * *
 * Arrays are used in the Collections Framework as the backing structure for {@link java.util.ArrayList},
 * {@link java.util.concurrent.CopyOnWriteArrayList}, {@link java.util.EnumSet} and {@link java.util.EnumMap},
 * and for many of the {@link java.util.Queue} and {@link java.util.Deque} implementations.
 * They also form an important part of the mechanism for implementing hash tables (discussed shortly).
 * ************
 * Linked lists:
 * As the name implies, these consist of chains of linked cells.
 * Each cell contains a reference to data and a reference to the next cell in the list (and, in some implementations, the previous cell).
 * Linked lists perform quite differently from arrays:
 * accessing elements by position is slow, because you have to follow the reference chain from the start of the list,
 * but insertion and removal operations can be performed in constant time by rearranging the cell references.
 * *
 * Linked lists are the primary backing structure used for the classes {@link java.util.concurrent.ConcurrentLinkedQueue},
 * {@link java.util.concurrent.LinkedBlockingQueue}, and {@link java.util.LinkedList},
 * and the new skip list collections {@link java.util.concurrent.ConcurrentSkipListSet} and {@link java.util.concurrent.ConcurrentSkipListMap}.
 * They are also used in implementing {@link java.util.HashSet} and {@link java.util.LinkedHashSet}.
 * ***********
 * Hash tables:
 * These provide a way of storing elements indexed on their content rather than on an integer-valued index, as with lists.
 * In contrast to arrays and linked lists, hash tables provide no support for accessing elements by position,
 * but access by content is usally very fast, as are insertion and removal.
 * *
 * Hash tables are the backing structure for many {@link java.util.Set} and {@link java.util.Map} implementations,
 * including {@link java.util.HashSet} and {@link java.util.LinkedHashSet}
 * Set together with the corresponding maps {@link java.util.HashMap} and {@link java.util.LinkedHashMap},
 * as well as {@link java.util.WeakHashMap}, {@link java.util.IdentityHashMap} and {@link java.util.concurrent.ConcurrentHashMap}.
 * *****
 * Trees:
 * These also organize their elements by content, but with the important difference that they can store and retrieve them in sorted order.
 * They are relatively fast for the operations of inserting and removing elements, accessing them by content and iterating over them.
 * *
 * Trees are the backing structures for {@link java.util.TreeSet} and {@link java.util.TreeMap}.
 * Priority heaps, used in the implementation of {@link java.util.PriorityQueue} and {@link java.util.concurrent.PriorityBlockingQueue},
 * are tree-related structures.
 */
package chapter11.section02;