/**
 * SortedSet and NavigableSet.
 * *
 * {@link java.util.Set} has one subinterface, {@link java.util.SortedSet},
 * which adds to the Set contract a guarantee that its iterator will traverse the set in ascending element order.
 * {@link java.util.SortedSet} was itself extended in Java 6 by the interface {@link java.util.NavigableSet},
 * which adds methods to find the closest matches to a target element.
 * *
 * The only implementation of {@link java.util.SortedSet} before Java 6 was {@link java.util.TreeSet},
 * which has been retrofitted with the methods required to implement the new interface.
 * Since there is no platform implementation of {@link java.util.SortedSet} in Java 6 that does not also implement {@link java.util.NavigableSet},
 * it makes sense to discuss them in the same section.
 * *
 * For new client code developed for the Java 6 platform, there is no need to use the {@link java.util.SortedSet} interface at all,
 * but for the benefit of readers still constrained to use Java 5 we shall present the methods of the two interfaces separately in this section.
 * *
 * In Chapter 3 we saw that element ordering can either be defined by the element class itself, if that implements {@link java.lang.Comparable},
 * or it can be imposed by an external {@link java.util.Comparator}, supplied by a constructor such as this one, for {@link java.util.TreeSet}:
 * TreeSet(Comparator<? super E> comparator)
 * *
 * {@link chapter12.section01.Task} does implement Comparable (its natural ordering is the natural ordering of its string representation),
 * so we don’t need to supply a separate comparator.
 * *
 * Now merging two ordered lists, which was quite tricky using parallel iterators, is trivial if we get a {@link java.util.SortedSet} to do the work.
 * Using the task collections of Example {@link chapter12.section01.StaticTestData}, it requires two lines of code:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])
 * This simplicity comes at a price, though;
 * merging two sorted lists of size n is O(n), but adding n elements to a {@link java.util.TreeSet} of size n is O(n log n).
 * *
 * We could use {@link java.util.SortedSet} to add some function to the to-do manager.
 * Until now, the methods of {@link java.util.Collection} and {@link java.util.Set} have given us no help in ordering our tasks —
 * surely one of the central requirements of a to-do manager.
 * *
 * Example defines a class {@link chapter13.section02.PriorityTask} which attaches a priority to a task.
 * To test whether two PriorityTasks are equal, we check whether they have the same priority and the same task.
 * These definitions ensure that the natural ordering is consistent with equals (see chapter03.1).
 * As when we defined tasks in chapter12.1, we have followed good practice by making {@link chapter13.section02.PriorityTask} immutable.
 */
package chapter13.section02;