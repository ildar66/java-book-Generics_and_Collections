/**
 * IdentityHashMap.
 * *
 * An IdentityHashMap differs from an ordinary HashMap in that two keys are considered equal only if they are physically the same object:
 * identity, rather than equals, is used for key comparison.
 * That sets the contract for {@link java.util.IdentityHashMap} at odds with the contract for Map, the interface it implements, which specifies
 * that equality should be used for key comparison. An alternative design could have avoided this problem by providing a weaker contract for Map,
 * with two different sub-interfaces strengthening the contract to specify the type of key comparison to use. This is another example of the problem
 * we discussed in section 11.4, of balancing the tradeoff between a framework’s complexity and its precision in implementing its contracts.
 * *
 * {@link java.util.IdentityHashMap} is a specialized class, commonly used in operations such as serialization, in which a graph has to be traversed
 * and information stored about each node. The algorithm used for traversing the graph must be able to check, for each node it encounters,
 * whether that node has already been seen; otherwise, graph cycles could be followed indefinitely. For cyclic graphs, we must use identity
 * rather than equality to check whether nodes are the same. Calculating equality between two graph node objects requires calculating the equality
 * of their fields, which in turn means computing all their successors—and we are back to the original problem.
 * An IdentityHashMap, by contrast, will report a node as being present only if that same node has previously been put into the map.
 * *
 * The standard implementation of IdentityHashMap handles collisions differently than the chaining method and used by all the other variants
 * of HashSet and HashMap. This implementation uses a technique called linear probing, in which the key and value references are stored directly
 * in adjacent locations in the table itself rather than in cells referenced from it. With linear probing, collisions are handled by simply
 * stepping along the table until the first free pair of locations is found.
 * *
 * Out of all the Collections Framework hash implementations, why does IdentityHash Map alone use linear probing when all the others use chaining?
 * The motivation for using probing is that it is somewhat faster than following a linked list, but that is only true when a reference to the value
 * can be placed directly in the array. That isn’t practical for all other hash-based collections, because they store the hash code as well as the
 * value. This is for reasons of efficiency: a get operation must check whether it has found the right key, and since equality is an expensive
 * operation, it makes sense to check first whether it even has the right hash code. Of course, this reasoning doesn’t apply to IdentityHashMap,
 * which checks object identity rather than object equality.
 * *
 * There are three constructors for IdentityHashMap:
 * public IdentityHashMap()
 * public IdentityHashMap(Map<? extends K,? extends V> m)
 * public IdentityHashMap(int expectedMaxSize)
 * *
 * The first two are the standard constructors found in every general-purpose Map implementation. The third takes the place of the two constructors
 * that in other HashMaps allow the user to control the initial capacity of the table and the load factor at which it will be rehashed.
 * IdentityHashMap doesn’t allow this, fixing it instead (at .67 in the standard implementation) in order to protect the user from the consequences
 * of setting the load factor inappropriately: whereas the cost of finding a key in a table using chaining is proportional to the load factor l,
 * in a table using linear probing it is proportional to 1/(1–l). So avoiding high load factors is too important to be left to the programmer!
 * This decision is in line with the policy, mentioned earlier, of no longer providing configuration parameters when new classes are introduced into
 * the Framework.
 */
package chapter16.section02.part_4;