/**
 * {@link java.util.LinkedHashSet}.
 * *
 * This class inherits from {@link java.util.HashSet}, still implementing Set and refining the contract of its superclass in only one respect:
 * it guarantees that its iterators will return their elements in the order in which they were first added.
 * It does this by maintaining a linked list of the set elements.
 * *
 * The situation in the figure would result from this code:
 * Set<Character> s2 = new LinkedHashSet<Character>(8);
 * Collections.addAll(s2, 'a', 'b', 'j');
 * // iterators of a LinkedHashSet return their elements in proper order:
 * assert s2.toString().equals("[a, b, j]");
 * *
 * The linked structure also has a useful consequence in terms of improved performance for iteration:
 * next() performs in constant time, as the linked list can be used to visit each element in turn.
 * This is in contrast to {@link java.util.HashSet}, for which every bucket in the hash table must be visited whether it is occupied or not,
 * but the overhead involved in maintaining the linked list means that you would choose {@link java.util.LinkedHashSet} in preference
 * to {@link java.util.HashSet} only if the order or the efficiency of iteration were important for your application.
 * *
 * The constructors for {@link java.util.LinkedHashSet} provide the same facilities as those of {@link java.util.HashSet}
 * for configuring the underlying hash table.
 * *
 * Like {@link java.util.HashSet}, it is unsychronized and not threadsafe;
 * its iterators are fail-fast.
 */
package chapter13.section01.part_2;