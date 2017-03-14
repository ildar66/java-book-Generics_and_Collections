/**
 * Arrays as a Deprecated Type?
 * *
 * We have seen that collections are superior to arrays in a number of ways:
 * • Collections provide more precise typing than arrays (more errors to be detected at compile time).
 * • Collections are more flexible than arrays.
 * • Collections may have elements of any type, whereas arrays should only have components of reifiable type.
 * *
 * When creating an array, one must adhere to the
 * "Principle of Truth in Advertising" — the reified type must conform to the static type — and the
 * "Principle of Indecent Exposure" — never publicly expose an array where the components do not have reifiable type.
 * *
 * Where avoiding the use of arrays might have improved the design:
 * • Variable-length arguments (varargs) are represented by an array, and so are subject to the same restrictions.
 * • Some methods in the Java library have signatures that violate the Principle of Indecent Exposure:
 * TypeVariable<Class<T>>[] java.lang.Class.getTypeParameters()
 * TypeVariable<Method>[] java.lang.Reflect.Method.getTypeParameters()
 * *
 * In retrospect, it might have been better to choose a design that was simpler,
 * but made arrays not quite as convenient to use:
 * • Arrays must be created with components of reifiable type.
 * • Currently, array creation is restricted to arrays of reifiable type.
 * But it is permitted to declare an array of nonreifiable type or to cast to an array type that is not reifiable,
 * at the cost of an unchecked warning somewhere in the code.
 * • The preceding changes would mean that often one would use lists in preference to arrays.
 * *
 * Your own code designs may be improved if you use collections and lists in preference to arrays.
 */
package chapter06.section09;