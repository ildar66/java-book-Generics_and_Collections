/**
 * How Erasure Works.
 * *
 * The erasure of a type is defined as follows: drop all type parameters from parameterized types,
 * and replace any type variable with the erasure of its bound, or with Object if it has no bound,
 * or with the erasure of the leftmost bound if it has multiple bounds.
 * *
 * Here are some examples:
 * • The erasure of List<Integer>, List<String>, and List<List<String>> is List.
 * • The erasure of List<Integer>[] is List[].
 * • The erasure of List is itself, similarly for any raw type (see Section 5.3 for an explanation of raw types).
 * • The erasure of int is itself, similarly for any primitive type.
 * • The erasure of Integer is itself, similarly for any type without type parameters.
 * • The erasure of T in the definition of asList (see Section 1.4) is Object, because T has no bound.
 * • The erasure of T in the definition of max (see Section 3.2) is Comparable, because T has bound Comparable<? super T>.
 * • The erasure of T in the final definition of max (see Section 3.6) is Object, because T has bound Object & Comparable<T>
 * and we take the erasure of the leftmost bound.
 * • The erasures of S and T in the definition of copy (see Section 3.6) are Readable and Appendable,
 * because S has bound Readable & Closeable and T has bound Appendable & Closeable.
 * • The erasure of LinkedCollection<E>.Node or LinkedCollection.Node<E> (see Section 4.3) is LinkedCollection.Node.
 * *
 * In Java, two distinct methods cannot have the same signature.
 * Since generics are implemented by erasure, it also follows that two distinct methods cannot have signatures with the same erasure.
 * @see chapter04.section04.HowErasureWorks
 * A class cannot overload two methods whose signatures have the same erasure,
 * and a class cannot implement two interfaces that have the same erasure.
 * *
 * It is not possible to give both methods the same name and try to distinguish between them by overloading,
 * because after erasure it is impossible to distinguish one method call from the other.
 */
package chapter04.section04;