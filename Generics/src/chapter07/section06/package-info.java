/**
 * Reflecting Generic Types.
 * *
 * The reflection library provides a Type interface to describe a generic type:
 * • The class Class, representing a primitive type or raw type
 * • The interface {@link java.lang.reflect.ParameterizedType},
 * representing an application of a generic class or interface to parameter types, from which you can extract an array of the parameter types.
 * • The interface {@link java.lang.reflect.TypeVariable},
 * representing a type variable, from which you can extract the bounds on the type variable.
 * • The interface {@link java.lang.reflect.GenericArrayType},
 * representing an array, from which you can extract the array component type.
 * • The interface {@link java.lang.reflect.WildcardType},
 * representing a wildcard, from which you can extract a lower or upper bound on the wildcard.
 */
package chapter07.section06;