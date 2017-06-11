/**
 * ArrayList.
 * *
 * Arrays are provided as part of the Java language and have a very convenient syntax, but their key disadvantage — that, once created,
 * they cannot be resized—makes them increasingly less popular than List implementations, which (if resizable at all) are indefinitely extensible.
 * The most commonly used implementation of List is, in fact, {@link java.util.ArrayList} — that is, a {@link java.util.List} backed by an array.
 * *
 * The standard implementation of ArrayList stores the List elements in contiguous array locations, with the first element always stored at index 0
 * in the array. It requires an array at least large enough (with sufficient capacity) to contain the elements, together with a way of keeping track
 * of the number of “occupied” locations (the size of the List). If an ArrayList has grown to the point where its size is equal to its capacity,
 * attempting to add another element will require it to replace the backing array with a larger one capable of holding the old contents and the new
 * element, and with a margin for further expansion (the standard implementation actually uses a new array that is double the length of the old one).
 * As we explained in chapter11.3, this leads to an amortized cost of O(1).
 * *
 * The performance of {@link java.util.ArrayList} reflects array performance for "random-access” operations: set() and get() take constant time.
 * The downside of an array implementation is in inserting or removing elements at arbitrary positions, because that may require adjusting the
 * position of other elements. (We have already met this problem with the remove method of the iterators of array-based queues —
 * for example, {@link java.util.concurrent.ArrayBlockingQueue} (see chapter14.3.2).
 * But the performance of positional add() and remove() methods are much more important for lists than iterator.remove() is for queues.)
 * *
 * For example, shows a new ArrayList after three elements have been added by means of the following statements:
 * List<Character>; charList = new ArrayList<Character>();
 * Collections.addAll(charList, 'a', 'b', 'c');
 * *
 * If we now want to remove the element at index 1 of an array, the implementation must preserve the order of the remaining elements and ensure that
 * the occupied region of the array is still to start at index 0. So the element at index 2 must be moved to index 1, that at index 3 to index 2,
 * and so on. Since every element must be moved in turn, the time complexity of this operation is proportional to the size of the list
 * (even though, because this operation can usually be implemented in hardware, the constant factor is low).
 * *
 * Even so, the alert reader, recalling the discussion of the circular arrays used to implement ArrayBlockingQueue and ArrayDeque (see chapter14.4.1)
 * may wonder why a circular array was not chosen for the implementation of {@link java.util.ArrayList}, too. It is true that the add() and remove()
 * methods of a circular array show much better performance only when they are called with an index argument of 0, but this is such a common case
 * and the overhead of using a circular array is so small, that the question remains. Indeed, an outline implementation of a circular array list
 * was presented by Heinz Kabutz in The Java Specialists’ Newsletter (http://www.javaspecialists.co.za/archive/Is sue027.html). In principle it is
 * still possible that ArrayList may be reimplemented in this way, possibly leading to real performance gains in many existing Java applications.
 * A possible alternative is that the circular {@link java.util.ArrayDeque} may be retrofitted to implement the methods of List.
 * In the meantime, if your application is using a List in which the performance of element insertion and removal from the beginning of a list
 * is more important than that of random-access operations, consider writing to the {@link java.util.Deque} interface and taking advantage
 * of its very efficient {@link java.util.ArrayDeque} implementation.
 * *
 * As we mentioned in the discussion of {@link java.util.concurrent.ArrayBlockingQueue} (chaptr14.2), variable-size array-backed collection classes
 * can have one configuration parameter: the initial length of the array. So besides the standard Collections Framework constructors, ArrayList
 * has one that allows you to choose the value of the initial capacity to be large enough to accommodate the elements of the collection without
 * frequent create-copy operations. The initial capacity of an {@link java.util.ArrayList} created by the default constructor is 10,
 * and that of one initialized with the elements of another collection is 110% of the size of that collection.
 * *
 * The iterators of {@link java.util.ArrayList} are fail-fast.
 */
package chapter15.section02.part_1;