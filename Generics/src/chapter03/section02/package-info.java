/**
 * Maximum of a Collection.
 * *
 * Unlike wildcards, type variables must always be bounded using extends, never super.
 * @see chapter03.section02.MaximumOfCollection
 * In this case, the bound is recursive, in that the bound on T itself depends upon T.
 * It is even possible to have mutually recursive bounds, such as: <T extends C<T,U>, U extends D<T,U>>
 * *
 * If efficiency is a pressing concern: {@link chapter03.section02.MaximumOfCollection#max2(java.util.Collection)}
 * *
 * Signature of max by replacing:
 * <T extends Comparable<T>> T max(Collection<T> coll)
 * with:
 * <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
 * *
 * @see generics.Comparators#max(java.util.Collection)
 * *
 * Following the Get and Put Principle,
 * we use extends with Collection because we get values of type T from the collection,
 * and we use super with Comparable because we put value of type T into the compareTo method.
 * {@link chapter03.section02.MaximumOfCollection#max3(java.util.Collection)}
 */
package chapter03.section02;