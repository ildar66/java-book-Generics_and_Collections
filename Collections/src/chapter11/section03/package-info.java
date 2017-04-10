/**
 * Efficiency and the O-Notation.
 * *
 * A good algorithm is economical in its use of two resources: time and space.
 * *
 * The one most commonly used is the O-notation (pronounced "big-oh notation”).
 * The O-notation is a way of describing the performance of an algorithm in an abstract way,
 * without the detail required to predict the precise performance of a particular program running on a particular machine.
 * *
 * ************************************** Table "Some common running times" ******************************************************************
 * Time         Common name            Effect on the running time if N is doubled           Example algorithms
 * *******************************************************************************************************************************************
 * O(1)         Constant               Unchanged                                            Insertion into a hash table (Chapter 13. Section01)
 * O(log N)     Logarithmic            Increased by a constant amount                       Insertion into a tree (Chapter 13. Section02)
 * O(N)         Linear                 Doubled                                              Linear search
 * O(N log N)                          Doubled plus an amount proportional to N             Merge sort(Chapter 17. Section01)
 * O(N2)        Quadratic              Increased fourfold                                   Bubble sort
 * *******************************************************************************************************************************************
 * *
 * Many important problems can be solved only by algorithms that take O(2N)—for these, when N doubles, the running time is squared!
 * For all but the smallest data sets, such algorithms are very slow.
 * *
 * Sometimes we have to think about situations in which the cost of an operation varies with the state of the data structure.
 * For example, adding an element to the end of an ArrayList can normally be done in constant time, unless the ArrayList has reached its capacity.
 * In that case, a new and larger array must be allocated, and the contents of the old array transferred into it.
 * The cost of this operation is linear in the number of elements in the array, but it happens relatively rarely.
 * In situations like this, we calculate the amortized cost of the operation — that is,
 * the total cost of performing it n times divided by n, taken to the limit as n becomes arbitrarily large.
 * In the case of adding an element to an ArrayList, the total cost for N elements is O(N), so the amortized cost is O(1).
 */
package chapter11.section03;