/**
 * Covariant Overriding.
 * *
 * In Java 1.4 and earlier, one method can override another only if the argument and return types match exactly.
 * *
 * In Java 5, a method can override another if the argument types match exactly
 * and the return type of the overriding method is a subtype of the return type of the other method.
 * It is implemented using a bridging technique: {@link chapter03.section08.CovariantOverriding}
 * *
 * You can see the bridge if you apply reflection: {@link chapter03.section08.CovariantOverriding#main(java.lang.String[])}
 * public Point Point.clone()
 * public "bridge" java.lang.Object Point.clone() throws java.lang.CloneNotSupportedException
 * *
 * Bridging technique exploits the fact that in a class file two methods of the same class may have the same argument signature,
 * even though this is not permitted in Java source.
 * The bridge method simply calls the first method.
 */
package chapter03.section08;