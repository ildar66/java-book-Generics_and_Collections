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
 * ********************* list():
 * <T> ArrayList<T> list(Enumeration<T> e) // returns an ArrayList containing the elements returned by the specified Enumeration
 * This method is provided for interoperation with APIs whose methods return results of type Enumeration, a legacy version of Iterator.
 * The ArrayList that it returns contains the same elements, in the same order, as provided by e.
 * This method forms a pair with the method enumeration, which converts a Framework collection to an Enumeration.
 * ********************* newSetFromMap():
 * <E> Set<E> newSetFromMap(Map<E, Boolean> map) returns a set backed by the specified map.
 * As we saw earlier, many sets (such as {@link java.util.TreeSet} and NavigableSkipListSet) are implemented by maps,
 * and share their ordering, concurrency, and performance characteristics.
 * Some maps, however (such as WeakHashMap and IdentityHashMap) do not have standard Set equivalents.
 * The purpose of the method newSetFromMap is to provide equivalent Set implementations for such maps.
 * The method newSetFromMap wraps its argument, which must be empty when supplied and should never be subsequently accessed directly.
 * This code shows the standard idiom for using it to create a weak HashSet, one whose elements are held via weak references:
 * Set<Object> weakHashSet = Collections.newSetFromMap( new WeakHashMap<Object, Boolean>());
 * ********************** reverseOrder():
 * <T> Comparator<T> reverseOrder() returns a comparator that reverses natural ordering
 * This method provides a simple way of sorting or maintaining a collection of Comparable objects in reverse natural order.
 * Here is an example of its use:
 * *
 * SortedSet<Integer> s = new TreeSet<Integer>(Collections.reverseOrder());
 * Collections.addAll(s, 1, 2, 3);
 * assert s.toString().equals("[3, 2, 1]");
 * *
 * There is also a second form of this method.
 * <T> Comparator<T> reverseOrder(Comparator<T> cmp)
 * This method is like the preceding one, but instead of reversing the natural order of an object collection,
 * it reverses the order of the Comparator supplied as its argument.
 * Its behaviour when supplied with null is unusual for a method of the Collections class.
 * The contract for Collections states that its methods throw a {@link java.lang.NullPointerException}
 * if the collections or class objects provided to them are null,
 * but if this method is supplied with null it returns the same result as a call of reverseOrder() —
 * that is, it returns a {@link java.util.Comparator} that reverses the natural order of a collection of objects.
 * * ************************ Conclusion
 * This completes our tour of the convenience methods provided by the Collections class, and our discussion of the Collections Framework.
 * We have presented collections, sets, lists, queues, and maps, and given you the information you need to choose which interface and
 * implementation best fits your needs. Generics and the improved Collections Framework are possibly the most significant change to Java
 * since its inception.We are excited about these changes, and hope we have conveyed some of this excitement to you.
 * We hope you will see that generics and collections fit together well to make a powerful addition to your repertory of
 * Java programming skills.
 */
package chapter17.section03.part_4;