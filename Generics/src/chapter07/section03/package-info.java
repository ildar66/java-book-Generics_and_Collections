/**
 * Reflection for Primitive Types.
 * *
 * Every type in Java, including primitive types and array types, has a class literal and a corresponding class token.
 * The type of int.class token cannot be Class<int>, since int is not a reference type, so it is taken to be Class<Integer>.
 * @see chapter07.section03.ReflectionForPrimitiveTypes
 * These examples suggest that it might have made more sense to give the class token int.class the type Class<?>.
 * On the other hand, int[].class denotes the class token for arrays with components of the primitive type integer,
 * and the type of this class token is Class<int[]>, which is permitted since int[] is a reference type.
 */
package chapter07.section03;