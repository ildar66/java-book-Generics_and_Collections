/**
 * {@link java.util.TreeSet}.
 * *
 * Trees are the data structure you would choose for an application that needs fast insertion and retrieval of individual elements
 * but which also requires that they be held in sorted order.
 * *
 * For example, suppose you want to match all the words from a set against a given prefix, a common requirement in visual applications
 * where a drop-down should ideally show all the possible elements that match against the prefix that the user has typed.
 * A hash table can’t return its elements in sorted order and a list can’t retrieve its elements quickly by their content, but a tree can do both.
 * *
 * In computing, a tree is a branching structure that represents hierarchy.
 * Computing trees borrow a lot of their terminology from genealogical trees, though there are some differences;
 * the most important is that, in computing trees, each node has only one parent (except the root, which has none).
 * An important class of tree often used in computing is a binary tree — one in which each node can have at most two children.
 * *
 * The most important property of this tree can be seen if you look at any non-leaf node — say, the one containing the word the:
 * all the nodes below that on the left contain words that precede the alphabetically, and all those on the right, words that follow it.
 * To locate a word, you would start at the root and descend level by level, doing an alphabetic comparison at each level,
 * so the cost of retrieving or inserting an element is proportional to the depth of the tree.
 * *
 * How deep, then, is a tree that contains n elements?
 * The complete binary tree with two levels has three elements (that’s 2*2–1), and the one with three levels has seven elements (2*2*2–1).
 * In general, a binary tree with n complete levels will have 2**n–1 elements.
 * Hence the depth of a tree with n elements will be bounded by log n (since 2**log n = n).
 * Just as n grows much more slowly than 2**n, log n grows much more slowly than n.
 * So "contains" on a large tree is much faster than on a list containing the same elements.
 * It’s still not as good as on a hash table — whose operations can ideally work in constant time —
 * but a tree has the big advantage over a hash table that its iterator can return its elements in sorted order.
 * *
 * Not all binary trees will have this nice performance, though.
 * Figure shows a balanced binary tree — one in which each node has an equal number of descendants (or as near as possible) on each side.
 * An unbalanced tree can give much worse performance — in the worst case, as bad as a linked list.
 * *
 * {@link java.util.TreeSet} uses a data type called a red-black tree,
 * which has the advantage that if it becomes unbalanced through insertion or removal of an element, it can always be rebalanced in O(log n) time.
 * *
 * The constructors for {@link java.util.TreeSet} include, besides the standard ones,
 * one which allows you to supply a Comparator (see Section 3.4) and one which allows you to create one from another {@link java.util.SortedSet}:
 * *
 * TreeSet(Comparator<? super E> c) // construct an empty set which will be sorted using the specified comparator
 * TreeSet(SortedSet<E> s) // construct a new set containing the elements of the supplied set, sorted according to the same ordering
 * *
 * The second of these is rather too close in its declaration to the standard "conversion constructor” (see Section 12.3):
 * TreeSet(Collection<? extends E> c)
 * *
 * As Joshua Bloch explains in Effective Java (item “Use overloading judiciously” in the chapter on Methods),
 * calling one of two constructor or method overloads which take parameters of related type can give confusing results.
 * This is because,in Java,calls to overloaded constructors and methods are resolved at compile time on the basis of the static type of the argument,
 * so applying a cast to an argument can make a big difference to the result of the call, as the following code shows:
 * @see chapter13.section02.part_2.ConstructorOverloadProblem#main(java.lang.String[])
 * *
 * This problem afflicts the constructors for all the sorted collections in the Framework ({@link java.util.TreeSet}, {@link java.util.TreeMap},
 * {@link java.util.concurrent.ConcurrentSkipListSet}, and {@link java.util.concurrent.ConcurrentSkipListMap}).
 * To avoid it in your own class designs, choose parameter types for different overloads
 * so that an argument of a type appropriate to one overload cannot be cast to the type appropriate to a different one.
 * If that is not possible, the two overloads should be designed to behave identically with the same argument, regardless of its static type.
 * For example, a {@link java.util.PriorityQueue} (chapter14.2.1) constructed from a collection uses the ordering of the original,
 * whether the static type with which the constructor is supplied is one of the Comparator-containing types {@link java.util.PriorityQueue}
 * or {@link java.util.SortedSet}, or just a plain {@link java.util.Collection}.
 * To achieve this, the conversion constructor uses the {@link java.util.Comparator} of the supplied collection,
 * only falling back on natural ordering if it does not have one.
 * *
 * {@link java.util.TreeSet} is unsychronized and not thread-safe;
 * its iterators are fail-fast.
 */
package chapter13.section02.part_2;