/**
 * Subtyping and the Substitution Principle.
 * *
 * Substitution Principle: a variable of a given type may be assigned a value of any subtype of that type,
 * and a method with a parameter of a given type may be invoked with an argument of any subtype of that type.
 * *
 * Some examples:
 * Integer is a subtype of Number
 * Double is a subtype of Number
 * ArrayList<E> is a subtype of List<E>
 * List<E> is a subtype of Collection<E>
 * Collection<E> is a subtype of Iterable<E>
 * *
 * List<Integer> is not a subtype of List<Number>, nor is List<Number> a subtype of List<Integer>
 * Arrays behave quite differently; with them, Integer[] is a subtype of Number[].
 * @see chapter02.section01.SubtypingAndTheSubstitutionPrinciple
 * *
 * Sometimes we would like lists to behave more like arrays,
 * in that we want to accept not only a list with elements of a given type,
 * but also a list with elements of any subtype of a given type.
 * For this purpose, we use wildcards.
 */
package chapter02.section01;