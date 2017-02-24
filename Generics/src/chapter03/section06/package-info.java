/**
 * Multiple Bounds.
 * *
 * To demonstrate, we use three interfaces from the Java library:{@link chapter03.section06.MultipleBounds}
 * *
 * When multiple bounds on a type variable appear, they are separated by ampersands.
 * You cannot use a comma, since that is already used to separate declarations of type variables.
 * *
 * When multiple bounds appear, the first bound is used for erasure.
 * *
 * @see java.util.Collections#max(java.util.Collection)
 * public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
 * Without the "Object &" text, the erased type signature for max would have Comparable as the return type,
 * whereas in legacy libraries the return type is Object.
 */
package chapter03.section06;