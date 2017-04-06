/**
 * Iterable and Iterators.
 * *
 * An iterator is an object that implements the interface {@link java.util.Iterator}
 * *
 * The purpose of iterators is to provide a uniform way of accessing collection elements sequentially,
 * so whatever kind of collection you are dealing with, and however it is implemented,
 * you always know how to process its elements in turn.
 * *
 * For example, in earlier versions of Java:
 * // coll refers to an object which implements Collection
 * // ----- not the preferred idiom from Java 5 on -------
 * for (Iterator itr = coll.iterator() ; itr.hasNext() ; ) { System.out.println(itr.next()); }
 * *
 * Java 5 introduced something better: the foreach statement:
 * for (Object o : coll) { System.out.println(o); }
 * This code will work with anything that implements the interface {@link java.lang.Iterable}
 * *
 * In Java 5 the {@link java.util.Collection} interface was made to extend Iterable,
 * so any set, list, or queue can be the target of foreach, as can arrays.
 * *
 * If you write your own implementation of Iterable, that too can be used with foreach.
 * Example {@link chapter11.section01.Counter} shows a tiny example of how Iterable can be directly implemented.
 * In practice, it is unusual to implement Iterable directly in this way,
 * as foreach is most commonly used with arrays and the standard collections classes.
 * *
 * The iterators of the general-purpose collections in the Framework — ArrayList, Hash Map, and so on
 * — can puzzle novice users by throwing ConcurrentModificationException from single-threaded code.
 * These iterators throw this exception whenever they detect that the collection from which they were derived has been structurally changed
 * (broadly speaking, that elements have been added or removed).
 * The motivation for this behavior is that the iterators are implemented as a view of their underlying collection so,
 * if that collection is structurally changed, the iterator may well not be able to continue operating correctly
 * when it reaches the changed part of the collection.
 * *
 * Instead of allowing the manifestation of failure to be delayed, making diagnosis difficult,
 * the general- purpose Collections Framework iterators are "fail-fast".
 * The methods of a fail-fast iterator check that the underlying collection has not been structurally changed
 * (by another iterator, or by the methods of the collection itself) since the last iterator method call.
 * If they detect a change, they throw ConcurrentModificationException.
 * Although this restriction rules out some sound programs, it rules out many more unsound ones.
 * *
 * The concurrent collections have other strategies for handling concurrent modification,
 * such as "weakly consistent" iterators: ({@link chapter11.section05}).
 */
package chapter11.section01;