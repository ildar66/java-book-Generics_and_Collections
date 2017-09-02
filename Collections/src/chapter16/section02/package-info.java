/**
 * Implementing Map.
 * *
 * For constructors, the general rule for {@link java.util.Map} implementations is like that for Collection implementations (see chapter 12.3).
 * Every implementation excluding EnumMap has at least two constructors; taking {@link java.util.HashMap} as an example, they are:
 * public HashMap()
 * public HashMap(Map<? extends K,? extends V> m)
 * *
 * The first of these creates an empty map, and the second a map that will contain the key-value mappings contained in the supplied map m.
 * The keys and values of map m must have types that are the same as (or are subtypes of) the keys and values,
 * respectively, of the map being created.
 * Using this second constructor has the same effect as creating an empty map with the default constructor,
 * and then adding the contents of constructors for configuration purposes. map m using putAll.
 * In addition to these two, the standard implementations have other constructors for configuration purposes.
 */
package chapter16.section02;