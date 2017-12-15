/**
 * Finding Specific Values in a List.
 * *
 * Methods in this group locate elements or groups of elements in a List,
 * again choosing between alternative algorithms on the basis of the list’s size and whether it implements RandomAccess.
 * <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) // search for key using binary search
 * <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) // search for key using binary search
 * int indexOfSubList(List<?> source, List<?> target) // find the first sublist of source which matches target
 * int lastIndexOfSubList(List<?> source, List<?> target) // find the last sublist of source which matches target
 * *
 * The signature of the first binarySearch overload says that you can use it to search for a key
 * of type T in a list of objects that can have any type that can be compared with objects of type T.
 * The second is like the Comparator overloads of min and max except that, in this case, the type parameter of the Collection
 * must be a subtype of the type of the key, which in turn must be a subtype of the type parameter of the Comparator.
 * *
 * Binary search requires a sorted list for its operation. At the start of a search, the range of indices in which the search value may
 * occur corresponds to the entire list. The binary search algorithm samples an element in the middle of this range, using the value of
 * the sampled element to determine whether the new range should be the part of the old range above or the part below the index of the element.
 * A third possibility is that the sampled value is equal to the search value, in which case the search is complete.
 * Since each step halves the size of the range, m steps are required to find a search value in a list of length 2**m,
 * and the time complexity for a list of length n is O(log n).
 * *
 * The methods indexOfSubList() and lastIndexOfSubList() do not require sorted lists for their operation. Their
 * signatures allow the source and target lists to contain elements of any type (remember that the two wildcards may stand for two different types).
 * The design decision behind these signatures is the same as that behind the Collection methods containsAll, retainAll, and removeAll
 * (see chapter2.6).
 */
package chapter17.section01.part_4;