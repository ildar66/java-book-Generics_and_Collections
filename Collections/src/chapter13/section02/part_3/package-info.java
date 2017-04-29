/**
 * {@link java.util.concurrent.ConcurrentSkipListSet}.
 * *
 * {@link java.util.concurrent.ConcurrentSkipListSet} was introduced in Java 6 as the first concurrent set implementation.
 * It is backed by a skip list, a modern alternative to the binary trees of the previous section.
 * A skip list for a set is a series of linked lists, each of which is a chain of cells consisting of two fields:
 * one to hold a value, and one to hold a reference to the next cell.
 * Elements are inserted into and removed from a linked list in constant time by pointer rearrangement.
 * *
 * Figure shows a skip list consisting of three linked lists, labelled levels 0, 1 and 2.
 * The first linked list of the collection (level 0 in the figure) contains the elements of the set,
 * sorted according to their natural order or by the comparator of the set.
 * Each list above level 0 contains a subset of the list below, chosen randomly according to a fixed probability.
 * For this example, let’s suppose that the probability is 0.5; on average, each list will contain half the elements of the list below it.
 * Navigating between links takes a fixed time, so the quickest way to find an element is to start at the beginning
 * (the left-hand end) of the top list and to go as far as possible on each list before dropping to the one below it.
 * *
 * Inserting an element into a skip list always involves at least inserting it at level 0.
 * When that has been done, should it also be inserted at level 1?
 * If level 1 contains, on average, half of the elements at level 0, then we should toss a coin
 * (that is, randomly choose with probability 0.5) to decide whether it should be inserted at level 1 as well.
 * If the coin toss does result in it being inserted at level 1, then the process is repeated for level 2, and so on.
 * To remove an element from the skip list, it is removed from each level in which it occurs.
 * *
 * If the coin tossing goes badly, we could end up with every list above level 0 empty—or full, which would be just as bad.
 * These outcomes have very low probability, however, and analysis shows that, in fact,
 * the probability is very high that skip lists will give performance comparable to binary trees:
 * search, insertion and removal all take O(log n).
 * *
 * Their compelling advantage for concurrent use is that they have efficient lock-free insertion and deletion algorithms,
 * whereas there are none known for binary trees.
 * *
 * The iterators of ConcurrentSkipListSet are weakly consistent.
 * *
 */
package chapter13.section02.part_3;