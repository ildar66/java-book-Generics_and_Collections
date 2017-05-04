/**
 * {@link java.util.PriorityQueue}.
 * *
 * PriorityQueue is one of the two nonlegacy Queue implementations not designed primarily for concurrent use (the other one is ArrayDeque).
 * It is not thread-safe, nor does it provide blocking behavior.
 * It gives up its elements for processing according to an ordering like that used by NavigableSet — either the natural order of its elements
 * if they implement {@link java.lang.Comparable}, or the ordering imposed by a Comparator supplied when the PriorityQueue is constructed.
 * So PriorityQueue would be an alternative design choice (obviously, given its name) for the priority-based to-do manager
 * that we outlined in chapter13.2 using {@link java.util.NavigableSet}.
 * Your application will dictate which alternative to choose:
 * if it needs to examine and manipulate the set of waiting tasks, use {@link java.util.NavigableSet}.
 * If its main requirement is efficient access to the next task to be performed, use {@link java.util.PriorityQueue}.
 * *
 * Choosing {@link java.util.PriorityQueue} allows us to reconsider the ordering:
 * since it accommodates duplicates, it does not share the requirement of NavigableSet for an ordering consistent with equals.
 * To emphasize the point, we will define a new ordering for our to-do manager that depends only on priorities.
 * Contrary to what you might expect, {@link java.util.PriorityQueue} gives no guarantee of how it presents multiple elements with the same value.
 * So if, in our example, several tasks are tied for the highest priority in the queue, it will choose one of them arbitrarily as the head element.
 * *
 * The constructors for PriorityQueue are:
 * PriorityQueue() // natural ordering, default initial capacity (11)
 * PriorityQueue(Collection<? extends E> c) // natural ordering of elements taken from c, unless c is a PriorityQueue or SortedSet,
 * // in which case copy c's ordering
 * PriorityQueue(int initialCapacity) // natural ordering, specified initial capacity
 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator) // Comparator ordering, specified initial capacity
 * PriorityQueue(PriorityQueue<? extends E> c) // ordering and elements copied from c
 * PriorityQueue(SortedSet<? extends E> c) // ordering and elements copied from c
 * *
 * Notice how the second of these constructors avoids the problem of the overloaded TreeSet constructor that we discussed in chapter13.2.2.
 * We can use PriorityQueue for a simple implementation of our to-do manager with the {@link chapter13.section02.PriorityTask} class,
 * and a new {@link java.util.Comparator} depending only on the task’s priority:
 * @see chapter14.section02.part_1.PriorityQueueTest#main(java.lang.String[])
 * *
 * Priority queues are usually efficiently implemented by priority heaps.
 * A priority heap is a binary tree somewhat like those we saw implementing TreeSet in chaptger13.2.2, but with two differences:
 * first, the only ordering constraint is that each node in the tree should be larger than either of its children,
 * and second, that the tree should be complete at every level except possibly the lowest;
 * if the lowest level is incomplete, the nodes it contains must be grouped together at the left.
 * To add a new element to a priority heap, it is first attached at the leftmost vacant position.
 * Then it is repeatedly exchanged with its parent until it reaches a parent that has higher priority.
 * In the figure, this required only a single exchange of the new element with its parent.
 * *
 * Getting the highest-priority element from a priority heap is trivial: it is the root of the tree.
 * But, when that has been removed, the two separate trees that result must be reorganized into a priority heap again.
 * This is done by first placing the rightmost element from the bottom row into the root position.
 * Then — in the reverse of the procedure for adding an element —
 * it is repeatedly exchanged with the larger of its children until it has a higher priority than either.
 * *
 * Apart from constant overheads, both addition and removal of elements require a number of operations proportional to the height of the tree.
 * So PriorityQueue provides O(log n) time for offer(), poll(), remove(), and add().
 * The methods remove(Object) and contains() may require the entire tree to be traversed, so they require O(n) time.
 * The methods peek() and element(), which just retrieve the root of the tree without removing it, take constant time,
 * as does size(), which uses an object field that is continually updated.
 * *
 * {@link java.util.PriorityQueue} is not suitable for concurrent use.
 * Its iterators are fail-fast, and it doesn’t offer support for client-side locking.
 * A thread-safe version, {@link java.util.concurrent.PriorityBlockingQueue} (see chapter14.3.2), is provided instead.
 */
package chapter14.section02.part_1;