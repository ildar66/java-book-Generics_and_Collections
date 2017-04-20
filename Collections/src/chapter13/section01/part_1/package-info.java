/**
 * {@link java.util.HashSet}.
 * *
 * This class is the most commonly used implementation of {@link java.util.Set}.
 * As the name implies, it is implemented by a hash table, an array in which elements are stored at a position derived from their contents.
 * Since hash tables store and retrieve elements by their content, they are well suited to implementing the operations of Set
 * (the Collections Framework also uses them for various implementations of Map).
 * For example, to implement contains(Object o) you would look for the element o and return true if it were found.
 * *
 * An element’s position in a hash table is calculated by a hash function of its contents.
 * Hash functions are designed to give, as far as possible, an even spread of results (hash codes) over the element values that might be stored.
 * For example, here is code like that used in the String class to calculate a hash code:
 * int hash = 0;
 * for (char ch : str.toCharArray()) { hash = hash * 31 + ch; }
 * *
 * Traditionally, hash tables obtain an index from the hash code by taking the remainder after division by the table length.
 * The Collections Framework classes actually use bit masking rather than division.
 * Since that means it is the pattern of bits at the low end of the hash code that is significant,
 * prime numbers (such as 31, here) are used in calculating the hash code because multiplying by primes will not tend
 * to shift information away from the low end — as would multiplying by a power of 2, for example.
 * *
 * A moment’s thought will show that, unless your table has more locations than there are values that might be stored in it,
 * sometimes two distinct values must hash to the same location in the hash table.
 * For instance, no int-indexed table can be large enough to store all string values without collisions.
 * We can minimize the problem with a good hash function — one which spreads the elements out equally in the table — but, when collisions do occur,
 * we have to have a way of keeping the colliding elements at the same table location or bucket.
 * This is often done by storing them in a linked list.
 * We will look at linked lists in more detail as part of the implementations of ConcurrentSkipListSet (see Section 13.2.3) but, for now,
 * it’s enough to see that elements stored at the same bucket can still be accessed, at the cost of following a chain of cell references.
 * *
 * The situation resulting from running this code on Sun’s implementation of Java 5:
 * Set<Character> s1 = new HashSet<Character>(8);
 * s1.add('a');
 * s1.add('b');
 * s1.add('j');
 * The index values of the table elements have been calculated
 * by using the bottom three bits (for a table of length 8) of the hash code of each element.
 * In this implementation, a Character’s hash code is just the Unicode value of the character it contains.
 * *
 * (In practice, of course, a hash table would be much bigger than this. Also, this diagram is simplified from the real situation;
 * because {@link java.util.HashSet} is actually implemented by a specialized {@link java.util.HashMap},
 * each of the cells in the chain contains not one but two references, to a key and a value (see Chapter 16).
 * When a hash table is being used to represent a set, all values are the same — only the presence of the key is significant.)
 * *
 * As long as there are no collisions, the cost of inserting or retrieving an element is constant.
 * As the hash table fills, collisions become more likely; assuming a good hash function,
 * the probability of a collision in a lightly loaded table is proportional to its load,
 * defined as the number of elements in the table divided by its capacity (the number of buckets).
 * If a collision does take place, a linked list has to be created and subsequently traversed,
 * adding an extra cost to insertion proportional to the number of elements in the list.
 * If the size of the hash table is fixed, performance will worsen as more elements are added and the load increases.
 * To prevent this from happening, the table size is increased by rehashing — copying to a new and larger table —
 * when the load reaches a specified threshold (its load factor).
 * *
 * Iterating over a hash table requires each bucket to be examined to see whether it is occupied
 * and therefore costs a time proportional to the capacity of the hash table plus the number of elements it contains.
 * Since the iterator examines each bucket in turn, the order in which elements are returned depends on their hash codes,
 * so there is no guarantee as to the order in which the elements will be returned.
 * The hash table yields its elements in order of descending table index and forward traversal of the linked lists.
 * Printing it produces the following output: [j, b, a]
 * *
 * Later in this section we will look at {@link java.util.LinkedHashSet},
 * a variant of this implementation with an iterator that does return elements in their insertion order.
 * *
 * The chief attraction of a hash table implementation for sets is the (ideally)
 * constant-time performance for the basic operations of add, remove, contains, and size.
 * *
 * Its main disadvantage is its iteration performance; since iterating through the table involves examining every bucket,
 * its cost is proportional to the table size regardless of the size of the set it contains.
 * *
 * {@link java.util.HashSet} has the standard constructors that we introduced in chapter12.3, together with two additional constructors:
 * HashSet(int initialCapacity)
 * HashSet(int initialCapacity, float loadFactor)
 * *
 * Both of these constructors create an empty set but allow some control over the size of the underlying table,
 * creating one with a length of the next-largest power of 2 after the supplied capacity.
 * Most of the hash table–based implementations in the Collections Framework have similar constructors, although Joshua Bloch,
 * the original designer of the Framework, has told us that new classes will no longer usually have configuration parameters like the load factor;
 * they are not generally useful, and they limit the possibilities of improving implementations at a later date.
 * *
 * {@link java.util.HashSet} is unsychronized and not thread-safe; its iterators are fail-fast.
 */
package chapter13.section01.part_1;