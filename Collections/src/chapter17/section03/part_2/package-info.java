/**
 * Unmodifiable Collections.
 * *
 * An unmodifiable collection will throw UnsupportedOperationException in response to
 * any attempt to change its structure or the elements that compose it. This can be useful
 * when you want to allow clients read access to an internal data structure. Passing the
 * structure in an unmodifiable wrapper will prevent a client from changing it. It will not
 * prevent the client from changing the objects it contains, if they are modifiable. In some
 * cases, you may have to protect your internal data structure by providing clients instead
 * with a defensive copy made for that purpose, or by also placing these objects in unmodifiable
 * wrappers.
 * *
 * There are six unmodifiable wrapper factory methods, corresponding to the six major interfaces of the Collections Framework:
 * *
 * <T> Collection<T> unmodifiableCollection(Collection<? extends T> c)
 * <T> Set<T> unmodifiableSet(Set<? extends T> s)
 * <T> List<T> unmodifiableList(List<? extends T> list)
 * <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
 * <T> SortedSet<T> unmodifiableSortedSet(SortedSet<? extends T> s)
 * <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m)
 */
package chapter17.section03.part_2;