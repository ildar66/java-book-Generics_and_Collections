/**
 * Function.
 * *
 * The "Function pattern" converts an arbitrary method into an object.
 * The relation between a function and the corresponding method is similar to the relation between Comparator and the compareTo method.
 * *
 * The generic version of the Function pattern demonstrates how to use a type variable in the throws clause of a method declaration.
 * This may be useful when different instances of a class contain methods that may raise different checked exceptions.
 * An example of the use of a type variable in a throws clause is shown in {@link chapter09.section03.Function}.
 * *
 * This last example: "getRunMethod" in {@link chapter09.section03.Function#main(java.lang.String...)}
 * shows the chief limitation of giving generic types to exceptions.
 * Often there is no suitable class or interface that contains all exceptions the function may raise,
 * and so you are forced to fall back on using Exception, which is too general to provide useful information.
 */
package chapter09.section03;