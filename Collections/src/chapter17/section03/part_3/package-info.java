/**
 * Checked Collections.
 * *
 * Unchecked warnings from the compiler are a signal to us to take special care to avoid runtime type violations.
 * For example, after we have passed a typed collection reference to an ungenerified library method,
 * we can’t be sure that it has added only correctly typed elements to the collection.
 * Instead of losing confidence in the collection’s type safety, we can pass in a checked wrapper,
 * which will test every element added to the collection for membership of the type supplied when it was created.
 * chapter 8.2 shows an example of this technique.
 * *
 * Checked wrappers are supplied for the main interfaces:
 * *
 * static <E> Collection checkedCollection(Collection<E> c, Class<E> elementType)
 * static <E> List checkedList(List<E> c, Class<E> elementType)
 * static <E> Set checkedSet(Set<E> c, Class<E> elementType)
 * static <E> SortedSet checkedSortedSet(SortedSet<E> c, Class<E> elementType)
 * static <K, V> Map checkedMap((Map<K, V> c, Class<K> keyType, Class<V> valueType)
 * static <K, V> SortedMap checkedSortedMap(SortedMap<K, V> c, Class<K> keyType,Class<V> valueType)
 */
package chapter17.section03.part_3;