/**
 * Generic Methods and Varargs.
 * *
 * A method which declares a type variable in this way (@see {@link chapter01.section04.Lists#toList(java.lang.Object[])})
 * is called a generic method.
 * *
 * The vararg feature permits a special, more convenient syntax for the case in which the last argument of a method is an array.
 * @see chapter01.section04.GenericMethodsAndVarargs#main(java.lang.String[])
 * *
 * Any number of arguments may precede a last vararg argument.
 * @see chapter01.section04.GenericMethodsAndVarargs#addAll(java.util.List, java.lang.Object[])
 * *
 * Since varargs always create an array, they should be used only when the argument does not have a generic type (see Section 6.8).
 * *
 * In general, the following rule of thumb suffices: in a call to a generic method,
 * if there are one or more arguments that correspond to a type parameter and they all have the same type then the type parameter may be inferred;
 * if there are no arguments that correspond to the type parameter or the arguments belong to different subtypes of the intended type
 * then the type parameter must be given explicitly.
 * *
 * Methods Arrays.asList and Collections.addAll in the Collections Framework are similar to toList and addAll shown earlier.
 * (Both classes are in package java.util.)
 */
package chapter01.section04;