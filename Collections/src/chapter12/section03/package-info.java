/**
 * Collection Constructors.
 * *
 * We will go on to look at the three main kinds of collection in the next three chapters,
 * but we should first explain two common forms of constructor which are shared by most collection implementations.
 * Taking {@link java.util.HashSet} as an example, these are:
 * public HashSet()
 * public HashSet(Collection<? extends E> c)
 * *
 * The first of these creates an empty set,
 * and the second a set that will contain the elements of any collection of the parametric type — or one of its subtypes, of course.
 * Using this constructor has the same effect as creating an empty set with the default constructor,
 * and then adding the contents of a collection using addAll.
 * This is sometimes called a “copy constructor”,
 * but that term should really be reserved for constructors which make a copy of an object of the same class,
 * whereas constructors of the second form can take any object which implements the interface Collection<? extends E>.
 * Joshua Bloch has suggested the term “conversion constructor”.
 * *
 * Not all collection classes have constructors of both forms —
 * {@link java.util.concurrent.ArrayBlockingQueue}, for example, cannot be created without fixing its capacity, and
 * {@link java.util.concurrent.SynchronousQueue} cannot hold any elements at all, so no constructor of the second form is appropriate.
 * *
 * In addition, many collection classes have other constructors besides these two,
 * but which ones they have depends not on the interface they implement but on the underlying implementation;
 * these additional constructors are used to configure the implementation.
 */
package chapter12.section03;