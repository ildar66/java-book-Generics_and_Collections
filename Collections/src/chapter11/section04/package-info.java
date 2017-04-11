/**
 * Contracts.
 * *
 * For example, "binary search" is a fast algorithm to find a key within an ordered list, and it fails if you apply it to an unordered list.
 * So the contract for Collections.binarySearch can say, “if the list is unsorted, the results are undefined”,
 * and the implementer of binary search is free to write code which, given an unordered list, returns random results,
 * throws an exception, or even enters an infinite loop.
 * *
 * In practice, this situation is relatively rare in the contracts of the core API because, instead of restricting input validity,
 * they mostly allow for error states in the preconditions and specify the exceptions that the method must throw if it gets bad input.
 * This design may be appropriate for general libraries such as the Collections Framework,
 * which will be very heavily used in widely varying situations and by programmers of widely varying ability.
 * *
 * You should probably avoid it for less-general libraries, because it restricts the flexibility of the supplier unnecessarily.
 * In principle, all that a client should need to know is how to keep to its side of the contract;
 * if it fails to do that, all bets are off and there should be no need to say exactly what the supplier will do.
 * It’s good practice in Java to code to an interface rather than to a particular implementation,
 * so as to provide maximum flexibility in choosing implementations.
 * For that to work, what does it imply about the behavior of implementations?
 * If your client code uses methods of the List interface, for example, and at run time the object doing the work is actually an ArrayList,
 * you need to know that the assumptions you have made about how Lists behave are true for ArrayLists also.
 * So a class implementing an interface has to fulfill all the obligations laid down by the terms of the interface contract.
 * Of course, a weaker form of these obligations is already imposed by the compiler;
 * a class claiming to implement an interface must provide concrete method definitions matching the declarations in the interface.
 * Contracts take this further by specifying the behavior of these methods as well.
 * *
 * The Collections Framework separates interface and implementation obligations in an unusual way.
 * Some API methods return collections with restricted functionality — for example,
 * the set of keys that you can obtain from a Map can have elements removed but not added (see Chapter 16).
 * Others can have elements neither added nor removed (e.g., the list view returned by Arrays.asList),
 * or may be completely read-only, for example collections that have been wrapped in an unmodifiable wrapper (see Chapter 17.3.2).
 * To accommodate this variety of behaviors in the Framework without an explosion in the number of interfaces,
 * the designers labeled the modification methods in the Collection interface(and in the Iterator and ListIterator interfaces) as optional
 * operations.
 * If a client tries to modify a collection using an optional operation that the collection does not implement,
 * the method must throw UnsupportedOperationException.
 * *
 * The advantage to this approach is that the structure of the Framework interfaces is very simple,
 * a great virtue in a library that every Java programmer must learn.
 * *
 * The drawback is that a client programmer can no longer rely on the contract for the interface,
 * but has to know which implementation is being used and to consult the contract for that as well.
 * That’s so serious that you will probably never be justified in subverting interfaces in this way in your own designs.
 * *
 * The contract for a class spells out what a client can rely on in using it, often including performance guarantees.
 * To fully understand the performance characteristics of a class, however, you may need to know some detail about the algorithms it uses.
 * In this part of the book, while we concentrate mainly on contracts and how, as a client programmer, you can make use of them,
 * we also give some further implementation detail from the platform classes where it might be of interest.
 * *
 * This can be useful in deciding between implementations, but remember that it is not stable;
 * while contracts are binding, one of the main advantages of using them is that they allow implementations to change as better algorithms
 * are discovered or as hardware improvements change their relative merits.
 * And of course, if you are using another implementation, such as GNU Classpath,
 * algorithm details not governed by the contract may be entirely different.
 */
package chapter11.section04;