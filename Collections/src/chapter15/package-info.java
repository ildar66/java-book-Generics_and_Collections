/**
 * Lists.
 * *
 * Lists are probably the most widely used Java collections in practice. A list is a collection which—unlike a set—can contain duplicates,
 * and which—unlike a queue—gives the user full visibility and control over the ordering of its elements.
 * The corresponding Collections Framework interface is {@link java.util.List}.
 * In addition to the operations inherited from {@link java.util.Collection}, the List interface includes operations for the following:
 * *************************** Positional Access ************
 * Methods that access elements based on their numerical position in the list:
 * void add(int index, E e) // add element e at given index
 * boolean addAll(int index, Collection<? extends E> c) // add contents of c at given index
 * E get(int index) // return element with given index
 * E remove(int index) // remove element with given index
 * E set(int index, E e) // replace element with given index by e
 * *************************** Search ************************
 * Methods that search for a specified object in the list and return its numerical position. These methods return -1 if the object is not present:
 * int indexOf(Object o) // return index of first occurrence of o
 * int lastIndexOf(Object o) // return index of last occurrence of o
 * ***************************  Range-View ********************
 * A method that gets a view of a range of the list:
 * List<E> subList(int fromIndex, int toIndex) // return a view of a portion of the list
 * *
 * The method subList works in a similar way to the subSet operations on {@link java.util.SortedSet} (see chapter13.2),
 * but uses the position of elements in the list rather than their values: the returned list contains the list elements starting at fromIndex,
 * up to but not including toIndex. The returned list has no separate existence — it is just a view of part of the list from which it was obtained,
 * so changes in it are reflected in the original list. There is an important difference from subSet, though; changes you make to the sublist write
 * through to the backing list, but the reverse is not always true. If elements have been inserted into or removed from the backing list
 * by directly calling one of its “structure changing” methods (Section 12.1), any subsequent attempts to use the sublist will result in a
 * {@link java.util.ConcurrentModificationException}.
 * ************************** List Iteration ********************
 * Methods that return a ListIterator, which is an Iterator with extended semantics to take advantage of the list’s sequential nature:
 * ListIterator<E> listIterator() // return a ListIterator for this list, initially positioned at index 0
 * ListIterator<E> listIterator(int indx) // return a ListIterator for this list, initially positioned at index indx
 * *
 * The methods added by {@link java.util.ListIterator} support traversing a list in reverse order, changing list elements or adding new ones,
 * and getting the current position of the iterator. The current position of a ListIterator always lies between two elements, so in a list of
 * length n, there are n+1 valid list iterator positions, from 0 (before the first element) to n (after the last one).
 * The second overload of listIterator uses the supplied value to set the initial position of the listIterator to one of these positions
 * (calling listIterator() with no arguments is the same as supplying an argument of 0.)
 * *
 * To the {@link java.util.Iterator} methods hasNext, next, and remove, {@link java.util.ListIterator} adds the following methods:
 * public interface ListIterator<E> extends Iterator<E> {
 * void add(E e); // insert the specified element into the list
 * boolean hasPrevious(); // return true if this list iterator has further elements in the reverse direction
 * int nextIndex(); // return the index of the element that would be returned by a subsequent call to next
 * E previous(); // return the previous element in the list
 * int previousIndex(); // return the index of the element that would be returned by a subsequent call to previous
 * void set(E e); // replace the last element returned by next or previous with the specified element
 * }
 * *
 * Consider an iterator at position 2, either moved there from elsewhere or created there by a call to listIterator (2). The effect of most of
 * the operations of this iterator is intuitive; add() inserts an element at the current iterator position (between the elements at index 1 and 2),
 * hasPrevious() and hasNext() return true, previous() and next() return the elements at indices 1 and 2 respectively, and previousIndex() and
 * nextIndex() return those indices themselves. At the extreme positions of the list, 0 and 3 in the figure, previousIndex() and nextIndex()
 * would return -1 and 3 (the size of the list) respectively, and previous() or next(), respectively, would throw NoSuchElementException.
 * *
 * The operations set() and remove() work differently. Their effect depends not on the current position of the iterator,
 * but on its “current element”, the one last traversed over using next() or previous(): set() replaces the current element, and remove() removes it.
 * If there is no current element, either because the iterator has just been created, or because the current element has been removed,
 * these methods will throw {@link java.lang.IllegalStateException}.
 */
package chapter15;