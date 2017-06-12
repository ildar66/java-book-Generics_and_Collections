/**
 * CopyOnWriteArrayList.
 * *
 * In chapter13.1 we met {@link java.util.concurrent.CopyOnWriteArraySet}, a set implementation designed to provide thread safety together with
 * very fast read access. {@link java.util.concurrent.CopyOnWriteArrayList} is a {@link java.util.List} implementation with the same design aims.
 * This combination of thread safety with fast read access is useful in some concurrent programs, especially when a collection of observer objects
 * needs to receive frequent event notifications. The cost is that the array which backs the collection has to be treated as immutable,
 * so a new copy is created whenever any changes are made to the collection.
 * This cost may not be too high to pay if changes in the set of observers occur only rarely.
 * *
 * The class CopyOnWriteArraySet in fact delegates all of its operations to an instance of {@link java.util.concurrent.CopyOnWriteArrayList},
 * taking advantage of the atomic operations addIfAbsent() and addAllAbsent() provided by the latter to enable the {@link java.util.Set} methods
 * add() and addAll() to avoid introducing duplicates to the set. In addition to the two standard constructors (see chapter12.3),
 * CopyOnWriteArrayList has an extra one that allows it to be created using the elements of a supplied array as its initial contents.
 * *
 * Its iterators are snapshot iterators, reflecting the state of the list at the time of their creation.
 */
package chapter15.section02.part_3;