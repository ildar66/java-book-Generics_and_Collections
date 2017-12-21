/**
 * Other Methods.
 * *
 * The Collections class provides a number of utility methods, some of which we have already seen in use.
 * Here we review them in alphabetical order.
 * ********************* addAll():
 * <T> boolean addAll(Collection<? super T> c, T... elements) // adds all of the specified elements to the specified collection.
 * We have used this method a number of times as a convenient and efficient way of initializing a collection with individual elements,
 * or with the contents of an array.
 * ********************** asLifoQueue():
 * <T> Queue<T> asLifoQueue(Deque<T> deque) returns a view of a Deque as a Last-in-first-out (Lifo) Queue.
 * Recall from Chapter 14 that while queues can impose various different orderings on their elements,
 * there is no standard Queue implementation that provides LIFO ordering.
 * Dequeue implementations, on the other hand, all support LIFO ordering if elements are removed from the same end of the dequeue as they were added.
 * The method asLifo Queue allows you to use this functionality through the conveniently concise Queue interface.
 * ********************* disjoint():
 * boolean disjoint(Collection<?> c1, Collection<?> c2) returns true if c1 and c2 have no elements in common
 * Care is needed in using this method; implementations may iterate over either collection, testing elements of one for containment in the other.
 * So if the two collections determine containment differently, the result of this method is undefined.
 * This could arise if, say, one collection is a SortedSet, for which containment is decided by natural ordering or a comparator,
 * and the other is a Set, for which containment is decided by the equals method of its elements.
 * ********************* enumeration():
 * <T> Enumeration<T> enumeration(Collection<T> c) // returns an enumeration over the specified collection
 * This method is provided for inter-operation with APIs whose methods take arguments of type Enumeration, a legacy version of Iterator.
 * The Enumeration it returns yields the same elements, in the same order, as the Iterator provided by c.
 * This method forms a pair with the method list, which converts an Enumeration value to an ArrayList.
 * ********************* frequency():
 * int frequency(Collection<?> c, Object o) // returns the number of elements in c that are equal to o
 * If the supplied value o is null, then frequency returns the number of null elements in the collection c.
 * *
 */
package chapter17.section03.part_4;