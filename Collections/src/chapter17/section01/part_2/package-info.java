/**
 * Changing the Contents of a List.
 * *
 * These methods change some or all of the elements of a list.
 * The method copy() transfers elements from the source list into an initial sublist of the destination list
 * (which has to be long enough to accommodate them), leaving any remaining elements of the destination list unchanged.
 * The method fill() replaces every element of a list with a specified object, and replaceAll replaces every occurrence
 * of one value in a list with another — where either the old or new value can be null —returning true if any replacements were made.
 * *
 * <T> void copy(List<? super T> dest, List<? extends T> src) // copy all of the elements from one list into another
 * <T> void fill(List<? super T> list, T obj) // replace every element of list with obj
 * <T> boolean replaceAll(List<T> list, T oldVal, T newVal) // replace all occurrences of oldVal in list with newVal
 * *
 * The signatures of these methods can be explained using the Get and Put Principle (see chapter 2.4).
 * The signature of copy() was discussed in chapter 2.3.
 * It gets elements from the source list and puts them into the destination, so the types of these lists are, respectively, ? extends T and ? super T.
 * This fits with the intuition that the type of the source list elements should be a subtype of the destination list.
 * Although there are simpler alternatives for the signature of copy,
 * chapter 2.3 makes the case that using wildcards where possible widens the range of permissible calls.
 * For fill(), the Get and Put Principle dictates that you should use super if you are putting values into a parameterized collection and,
 * for replaceAll(), it states that if you are putting values into and getting values out of the same structure, you should not use wildcards at all.
 */
package chapter17.section01.part_2;