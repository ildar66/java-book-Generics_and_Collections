/**
 * Comparator.
 * *
 * The ordering provided by the Comparable interface is called the natural ordering,
 * so the Comparator interface provides, so to speak, an unnatural ordering.
 * @see generics.Comparators#main(java.lang.String[])
 * *
 * It is easy to define a comparator that provides the natural ordering: {@link generics.Comparators#naturalOrder()}
 * Using this, it is easy to define the version of max that uses the natural ordering: {@link generics.Comparators#max(java.util.Collection)}
 * *
 * It is also easy to define a method that takes a comparator and returns a new comparator with the reverse of the given ordering:
 * {@link generics.Comparators#reverseOrder(java.util.Comparator)}
 * *
 * And here is a method that returns the reverse of the natural ordering: {@link generics.Comparators#reverseOrder()}
 * *
 * We can define the two versions of min in terms of the two versions of max by using the two versions of reverseOrder:
 * {@link generics.Comparators#min(java.util.Collection)} and {@link generics.Comparators#min(java.util.Collection, java.util.Comparator)}
 * *
 * As a final example of comparators, here is a method that takes a comparator on elements and returns a comparator on lists of elements:
 * {@link generics.Comparators#listComparator(java.util.Comparator)}
 * *
 * Similar methods are provided in java.util.{@link java.util.Collections}
 */
package chapter03.section04;