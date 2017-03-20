/**
 * Reflection for Generics.
 * *
 * Generics change the reflection library in two ways.
 * We have discussed generics for reflection, where Java added a type parameter to the class Class<T>.
 * We now discuss reflection for generics, where Java adds methods and classes that support access to generic types.
 * *
 * {@link chapter07.section05.ReflectionForGenerics} shows a simple demonstration of the use of reflection for generics.
 * *
 * The sample run shows that although the reified type information for objects and class tokens contains no information about generic types,
 * the actual bytecode of the class does encode information about generic types as well as erased types.
 * The information about generic types is essentially a comment.
 * It is ignored when running the code, and it is preserved only for use in reflection.
 */
package chapter07.section05;