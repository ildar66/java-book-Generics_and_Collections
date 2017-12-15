/**
 * Finding Extreme Values in a Collection.
 * *
 * The methods min and max are supplied for this purpose, each with two overloads —
 * one using natural ordering of the elements, and one accepting a Comparator to impose an ordering.
 * They execute in linear time.
 * *
 * <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) // return the maximum element using natural ordering
 * <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) // return the maximum element using the supplied comparator
 * <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) // return the minimum element using natural ordering
 * <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) // return the minimum element  using the supplied comparator
 * *
 * Sections chapter 3.6 and chapter 8.4 explain these methods and the types assigned to them.
 */
package chapter17.section01.part_3;