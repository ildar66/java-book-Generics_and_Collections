/**
 * Maps.
 * *
 * The {@link java.util.Map} interface is the last of the major Collections Framework interfaces,
 * and the only one that does not inherit from {@link java.util.Collection}.
 * It defines the operations that are supported by a set of key-to-value associations in which the keys are unique.
 * These operations fall into the following four groups, broadly parallel to the four operation groups of Collection —
 * adding elements, removing elements, querying collection contents, and providing different views of the contents of a collection:
 * **************** Adding Associations ***********
 * V put(K key, V value) // add or replace a key-value association return the old value (may be null) if the key was present; otherwise returns null
 * void putAll(Map<? extends K,? extends V> m) // add each of the key-value associations in the supplied map into the receiver
 * The operations in this group are optional; calling them on an unmodifiable map will result in an UnsupportedOperationException.
 * **************** Removing Associations **********
 * void clear() // remove all associations from this map
 * V remove(Object key) // remove the association, if any, with the given key; returns the value with which it was associated, or null
 * The signature of Map.remove is like that of the Collection.remove (see chapter 12.1) in that it takes a parameter of type Object
 * rather than the generic type. We discussed alternatives to this design in chapter 2.6.
 * Like the addition operations of the previous group, these removal operations are optional.
 * **************** Querying the Contents of a Map **************
 * V get(Object k) // return the value corresponding to k, or null if k is not present as a key
 * boolean containsKey(Object k) // return true if k is present as a key
 * boolean containsValue(Object v) // return true if v is present as a value
 * int size() // return the number of associations
 * boolean isEmpty() // return true if there are no associations
 * The arguments to containsKey and containsValue may be null for Map implementations that allow null keys or values (respectively).
 * An implementation that does not allow nulls will throw NullPointerException if supplied with a null argument to these methods.
 * As with the size method of Collection, the largest element count that can be reported is Integer.MAX_VALUE.
 * ******************** Providing Collection Views of the Keys, Values, or Associations: ***********
 * Set<Map.Entry<K, V>> entrySet() // return a Set view of the associations
 * Set<K> keySet() // return a Set view of the keys
 * Collection<V> values() // return a Collection view of the values
 * The collections returned by these methods are backed by the map, so any changes to them are reflected in the map itself, and vice versa.
 * In fact, only limited changes can be made via the view: elements can be removed, either directly or via an iterator over the view,
 * but cannot be added; you will get an {@link java.lang.UnsupportedOperationException} if you try.
 * Removing a key removes the single corresponding key-value association; removing a value, on the other hand,
 * removes only one of the associations mapping to it; the value may still be present as part of an association with a different key.
 * An iterator over the view will become undefined if the backing map is concurrently modified.
 * The members of the set returned by entrySet() implement the interface {@link java.util.Map.Entry},
 * which represents a key-value association and provides a setValue() method which can be used to change values in the backing map.
 * The documentation for Map.Entry is unusually specific in specifying that objects implementing the interface can only be created during iteration
 * of the view resulting from a call of entrySet, and that such objects become invalid if the backing map is modified during this iteration.
 * In Java 6 this restricted scenario for the creation of Map.Entry objects is insufficient,
 * as it is the return type for a number of methods of {@link java.util.NavigableMap} (see Section 16.3).
 */
package chapter16;