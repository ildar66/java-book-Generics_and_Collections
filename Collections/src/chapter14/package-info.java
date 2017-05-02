/**
 * Queues.
 * *
 * A queue is a collection designed to hold elements for processing, yielding them up in the order in which they are to be processed.
 * The corresponding Collections Framework interface {@link java.util.Queue} has a number of different implementations embodying different rules
 * about what this order should be.
 * Many of the implementations use the rule that tasks are to be processed in the order in which they were submitted (First In First Out, or FIFO),
 * but other rules are possible — for example, the Collections Framework includes queue classes whose processing order is based on task priority.
 * The Queue interface was introduced in Java 5, motivated in part by the need for queues in the concurrency utilities included in that release.
 * In fact, nearly all of the Queue implementations in the Collections Framework are in the package java.util.concurrent.
 * *
 * One classic requirement for queues in concurrent systems comes when a number of tasks have to be executed by a number of threads working in
 * parallel. An everyday example of this situation is that of a single queue of airline passengers being handled by a line of check-in operators.
 * Each operator works on processing a single passenger (or a group of passengers) while the remaining passengers wait in the queue. As they arrive,
 * passengers join the tail of the queue, wait until they reach its head, and are then assigned to the next operator who becomes free.
 * A good deal of fine detail is involved in implementing a queue such as this;
 * operators have to be prevented from simultaneously attempting to process the same passenger, empty queues have to be handled correctly,
 * and in computer systems there has to be a way of defining queues with a maximum size, or bound. (This last requirement may not often be imposed
 * in airline terminals, but it can be very useful in systems in which there is a maximum waiting time for a task to be executed.)
 * The Queue implementations in java.util.concurrent look after these implementation details for you.
 * *
 * In addition to the operations inherited from {@link java.util.Collection}, the {@link java.util.Queue} interface includes operations
 * to add an element to the tail of the queue, to inspect the element at its head, or to remove the element at its head.
 * Each of these three operations comes in two varieties, one which returns a value to indicate failure and one which throws an exception.
 * *
 * ***************** Adding an Element to a Queue **********
 * The exception-throwing variant of this operation is the add method inherited from {@link java.util.Collection}.
 * Although "add" does return a boolean signifying its success in inserting an element,
 * that value can’t be used to report that a bounded queue is full;
 * the contract for add specifies that it may return false only if the collection refused the element because it was already present —
 * otherwise, it must throw an exception. The value-returning variant is "offer":
 * *
 * boolean offer (E e) // insert the given element if possible
 * *
 * The value returned by offer indicates whether the element was successfully inserted or not.
 * Note that offer does throw an exception if the element is illegal in some way (for example, the value null for a queue that doesn’t permit nulls).
 * Normally, if offer returns false, it has been called on a bounded queue that has reached capacity.
 * *
 * ***************** Retrieving an Element from a Queue *********
 * The methods in this group are "peek" and element for inspecting the head element,
 * and "poll" and "remove" for removing it from the queue and returning its value.
 * *
 * The methods that throw an exception for an empty queue are:
 * E element() // retrieve but do not remove the head element
 * E remove() // retrieve and remove the head element
 * Notice that this is a different method from the Collection method remove(Object).
 * *
 * The methods that return null for an empty queue are:
 * E peek() // retrieve but do not remove the head element
 * E poll() // retrieve and remove the head element
 * Because these methods return null to signify that the queue is empty, you should avoid using null as a queue element.
 * *
 * In general, the use of null as a queue element is discouraged by the {@link java.util.Queue} interface,
 * and the only standard implementation that allows it is the legacy implementation {@link java.util.LinkedList}.
 */
package chapter14;