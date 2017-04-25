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
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 1:)
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
 * *
 * The following code shows {@link java.util.SortedSet} working with a set of PriorityTasks.
 * (in fact, we have declared a {@link java.util.NavigableSet} so that we can use the same set in later examples.
 * But for the moment, we will just use the methods of {@link java.util.SortedSet}):
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 2:)
 * *
 * Could you not simply compare the priorities of the tasks, without using the string representation as a secondary key?
 * A partial ordering like that would be useful if you want to preserve some aspects of the original ordering;
 * for example, you might wish to sort tasks by priority but, within each priority, preserve the order in which they were added to the set.
 * But the contract for SortedSet (and, as we shall see later, SortedMap) states that it will use the compare method of its Comparator — or,
 * if it does not have one, the compareTo method of its elements — instead of the elements’ equals method to determine when elements are distinct.
 * This means that if a number of elements compare as the same, the set will treat them as duplicates, and all but one will be discarded.
 * *
 * The methods defined by the {@link java.util.SortedSet} interface fall into three groups:
 * ********** Getting the First and Last Elements *********
 * E first() // return the first element in the set
 * E last() // return the last element in the set
 * If the set is empty, these operations throw NoSuchElementException.
 * ********** Retrieving the Comparator ***********
 * Comparator<? super E> comparator()
 * This method returns the set’s comparator if it has been given one at construction time.
 * The type Comparator<? super E> is used because a SortedSet parameterized on E can rely for ordering on a Comparator defined on any supertype of E.
 * For example, recalling chapter3.3, a Comparator<Fruit> could be used with a SortedSet<Apple>.
 * ********** Getting Range Views ****************
 * SortedSet<E> subSet(E fromElement, E toElement)
 * SortedSet<E> headSet(E toElement)
 * SortedSet<E> tailSet(E fromElement)
 * The method subSet returns a set containing every element of the original set that is greater than or equal to fromElement and less than toElement.
 * Similarly, the method "headSet" returns every element that is less than toElement,
 * and "tailSet" returns every element that is greater than or equal to fromElement.
 * Note that the arguments to these operations do not themselves have to be members of the set.
 * The sets returned are halfopen intervals:
 * they are inclusive of the fromElement — provided it actually is a set member, of course — and exclusive of the toElement.
 * *
 * In our example, these methods could be useful in providing different views of the elements in priorityTasks.
 * For instance, we can use headSet to obtain a view of the highand medium-priority tasks.
 * To do this, we need a special task that comes before all others in the task ordering;
 * fortunately, we defined a class {@link chapter12.section01.EmptyTask} for just this purpose in chapter12.1.
 * Using this, it is easy to extract all tasks that come before any lowpriority task:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 3:)
 * *
 * In fact,
 * because we know that tasks with empty details will never normally occur, we can also use one as the first endpoint in a half-open interval:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 4:)
 * *
 * Not all orderings can be treated so conveniently;
 * suppose, for example, that we want to work with the set of all the medium-priority tasks up to and including the mike Phone task.
 * To define that set as a half-open interval,
 * users of SortedSet would need to construct the task that immediately follows the mikePhone task in the PriorityTask ordering, and for that
 * you would need to know that the string that succeeds "Mike" in the natural ordering is "Mike\0" (that is, "Mike" with a null character appended).
 * Fortunately, users of {@link java.util.NavigableSet} have a much more intuitive way of defining this set, as we shall see in a moment.
 * Notice that the sets returned by these operations are not independent sets but new views of the original {@link java.util.SortedSet}.
 * So we can add elements to the original set and see the changes reflected in the view:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 5:)
 * *
 * The reverse applies also; changes in the view are reflected in the original set:
 * @see chapter13.section02.SortedSetTest#main(java.lang.String[])(// 6:)
 * *
 * To understand how this works, think of all the possible values in an ordering as lying on a line, like the number line used in arithmetic.
 * A range is defined as a fixed segment of that line, regardless of which values are actually in the original set.
 * So a subset, defined on a SortedSet and a range, will allow you to work with whichever elements of the SortedSet currently lie within the range.
 */
package chapter13.section02;