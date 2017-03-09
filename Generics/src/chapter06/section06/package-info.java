/**
 * The Principle of Indecent Exposure.
 * *
 * Although it is an error to create an array with a component type that is not reifiable,
 * it is possible to declare an array with such a type and to perform an unchecked cast to such a type.
 * @see chapter06.section06.InnocentClient#main(java.lang.String[])
 * *
 * Principle of Indecent Exposure:
 * never publicly expose an array where the components do not have a reifiable type.
 * (this is a case where an unchecked cast in one part of the program may lead to a class cast error in a completely different part)
 * *
 * It has taken some time for the importance of the Principle of Indecent Exposure to be understood,
 * even among the designers of generics for Java.
 * For example, the following two methods in the reflection library violate the principle:
 * TypeVariable<Class<T>>[] java.lang.Class.getTypeParameters()
 * TypeVariable<Method>[] java.lang.Reflect.Method.getTypeParameters()
 * ( Possible fixes are to delete the type parameter from TypeVariable so that the methods return an array of reified type,
 * or to replace the arrays with lists).
 * *
 * Don’t get caught out in the same way —
 * be sure to follow the Principle of Indecent Exposure rigorously in your own code!
 */
package chapter06.section06;