/**
 * EnumMap.
 * *
 * Implementing a mapping from an enumerated type is straightforward and very efficient,
 * for reasons similar to those described for {@link java.util.EnumSet} (see chapter 13.1.4); in an array implementation,
 * the ordinal value of each enumerated type constant can serve as the index of the corresponding value.
 * The basic operations of get and put can be implemented as array accesses, in constant time.
 * An iterator over the key set takes time proportional to the number of constants in the enumerated type and returns the keys in their natural order
 * (the order in which the enum constants are declared).
 * Although, as with EnumSet, this class is not thread-safe, the iterators over its collection views are not fail-fast but weakly consistent.
 * *
 * {@link java.util.EnumMap} has three public constructors:
 * EnumMap(Class<K> keyType) // create an empty enum map
 * EnumMap(EnumMap<K, ? extends V> m) // create an enum map, with the same key type and elements as m
 * EnumMap(Map<K, ? extends V> m) // create an enum map using the elements of the supplied Map,
 * *                              // which (unless it is an EnumMap) must contain at least one association
 * *
 * An EnumMap contains a reified key type, which is used at run time for checking the validity of new entries being added to the map.
 * This type is supplied by the three constructors in different ways.
 * In the first, it is supplied as a class token;
 * in the second, it is copied from the specified EnumMap.
 * In the third, there are two possibilities:
 * either the specified Map is actually an EnumMap, in which case it behaves like the second constructor,
 * or the class of the first key of the specified Map is used (which is why the supplied Map may not be empty).
 */
package chapter16.section02.part_5;