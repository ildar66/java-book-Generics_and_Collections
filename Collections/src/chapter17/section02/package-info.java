/**
 * Collection Factories.
 * *
 * The {@link java.util.Collections} class provides convenient ways of creating some kinds of collections
 * containing zero or more references to the same object. The simplest possible such collections are empty:
 * *
 * <T> List<T> emptyList() // return the empty list (immutable)
 * <K,V> Map<K,V> emptyMap() // return the empty map (immutable)
 * <T> Set<T> emptySet() // return the empty set (immutable)
 * *
 * Empty collections can be useful in implementing methods to return collections of values, where they can be used to signify
 * that there were no values to return. Each method returns a reference to an instance of a singleton inner class of Collections.
 * Because these instances are immutable, they can safely be shared, so calling one of these factory methods does not result in object creation.
 * The Collections fields EMPTY_SET, EMPTY_LIST, and EMPTY_MAP were commonly used for the same purpose in Java before generics,
 * but are less useful now because their raw types generate unchecked warnings whenever they are used.
 * *
 * ****************************************************************************************************
 * The {@link java.util.Collections} class also provides you with ways of creating collection objects containing only a single member:
 * *
 * <T> Set<T> singleton(T o) // return an immutable set containing only the specified object
 * <T> List<T> singletonList(T o) // return an immutable list containing only the specified object
 * <K,V> Map<K,V> singletonMap(K key, V value) // return an immutable map, mapping only the key K to the value V
 * *
 * Again, these can be useful in providing a single input value to a method that is written to accept a Collection of values.
 * *
 * ***************************************************************************************************
 * Finally, it is possible to create a list containing a number of copies of a given object.
 * <T> List<T> nCopies(int n, T o) // return an immutable list containing n references to the object o
 * *
 * Because the list produced by nCopies is immutable, it need contain only a single physical element to provide a list view of the required length.
 * Such lists are often used as the basis for building further collections—for example, as the argument to a constructor or an addAll method.
 */
package chapter17.section02;