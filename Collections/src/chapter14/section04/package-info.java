/**
 * {@link java.util.Deque}.
 * *
 * A deque (pronounced “deck”) is a double-ended queue.
 * Unlike a queue, in which elements can be inserted only at the tail and inspected or removed only at the head,
 * a deque can accept elements for insertion and present them for inspection or removal at either end.
 * Also unlike {@link java.util.Queue}, Deque’s contract specifies the ordering it will use in presenting its elements:
 * it is a linear structure in which elements added at the tail are yielded up in the same order at the head.
 * Used as a queue, then, a Deque is always a FIFO structure; the contract does not allow for, say, priority deques.
 * If elements are removed from the same end (either head or tail) at which they were added,
 * a Deque acts as a stack or LIFO (Last In First Out) structure.
 * *
 * {@link java.util.Deque} and its sub-interface {@link java.util.concurrent.BlockingDeque} were introduced in Java 6.
 * The fast Deque implementation {@link java.util.ArrayDeque} uses a circular array (see chapter14.3.2),
 * and is now the implementation of choice for stacks and queues.
 * Concurrent deques have a special role to play in parallelization, discussed in chapter14.4.2.
 * *
 * The {@link java.util.Deque} interface extends {@link java.util.Queue} with methods symmetric with respect to head and tail.
 * For clarity of naming, the Queue methods that implicitly refer to one end of the queue acquire a synonym that makes their behavior
 * explicit for Deque. For example, the methods peek() and offer(), inherited from Queue, are equivalent to peekFirst() and offerLast().
 * (First and last refer to the head and tail of the deque; the JavaDoc for {@link java.util.Deque} also uses “front” and “end”.)
 * *
 * ************* Collection-like Methods ***************
 * void addFirst(E e) // insert e at the head if there is enough space
 * void addLast(E e) // insert e at the tail if there is enough space
 * void push(E e) // insert e at the head if there is enough space
 * boolean removeFirstOccurrence(Object o); // remove the first occurrence of o
 * boolean removeLastOccurrence(Object o); // remove the last occurrence of o
 * Iterator<E> descendingIterator() // get an iterator, returning deque elements in reverse order
 * *
 * The contracts for the methods addFirst() and addLast() are similar to the contract for the add() method of {@link java.util.Collection},
 * but specify in addition where the element to be added should be placed, and that the exception to be thrown
 * if it cannot be added is {@link java.lang.IllegalStateException}.
 * As with bounded queues, users of bounded deques should avoid these methods in favor of offerFirst() and offerLast(),
 * which can report “normal” failure by means of a returned "boolean" value.
 * *
 * The method name push() is a synonym of addFirst(), provided for the use of {@link java.util.Deque} as a stack.
 * The methods removeFirstOccurrence() and removeLastOccurrence() are analogues of Collection.remove,
 * but specify in addition exactly which occurrence of the element should be removed.
 * The return value signifies whether an element was removed as a result of the call.
 * *
 * ************** Queue-like Methods *******************
 * boolean offerFirst(E e) // insert e at the head if the deque has space
 * boolean offerLast(E e) // insert e at the tail if the deque has space
 * The method offerLast() is a renaming of the equivalent method offer() on the {@link java.util.Queue} interface.
 * *
 * The methods that return null for an empty deque are:
 * E peekFirst() // retrieve but do not remove the first element
 * E peekLast() // retrieve but do not remove the last element
 * E pollFirst() // retrieve and remove the first element
 * E pollLast() // retrieve and remove the last element
 * The methods peekFirst() and pollFirst() are renamings of the equivalent methods peek() and poll() on the {@link java.util.Queue} interface.
 * *
 * The methods that throw an exception for an empty deque are:
 * E getFirst() // retrieve but do not remove the first element
 * E getLast() // retrieve but do not remove the last element
 * E removeFirst() // retrieve and remove the first element
 * E removeLast() // retrieve and remove the last element
 * E pop() // retrieve and remove the first element
 * The methods getFirst() and removeFirst() are renamings of the equivalent methods element() and remove() on the {@link java.util.Queue} interface.
 * The method name pop() is a synonym for removeFirst(), again provided for stack use.
 */
package chapter14.section04;