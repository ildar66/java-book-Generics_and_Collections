/**
 * Reifiable Types.
 * *
 * In Java, the type of an array is reified with its component type,
 * while the type of a parameterized type is reified without its type parameters.
 * *
 * For instance, an array of numbers will carry the reified type Number[],
 * while a list of numbers will carry the reified type ArrayList, not ArrayList<Number>;
 * the raw type, not the parameterized type, is reified.
 * *
 * In Java, we say that a type is reifiable if the type is completely represented at run time — that is,
 * if erasure does not remove any useful information.
 * *
 * A type is reifiable if it is one of the following:
 * • A primitive type (such as int)
 * • A nonparameterized class or interface type (such as Number, String, or Runnable)
 * • A parameterized type in which all type arguments are unbounded wildcards (such as List<?>, ArrayList<?>, or Map<?, ?>)
 * • A raw type (such as List, ArrayList, or Map)
 * • An array whose component type is reifiable (such as int[], Number[], List<?>[], List[], or int[][])
 * *
 * A type is not reifiable if it is one of the following:
 * • A type variable (such as T)
 * • A parameterized type with actual parameters (such as List<Number>, ArrayList<String>, or Map<String, Integer>)
 * • A parameterized type with a bound (such as List<? extends Number> or Comparable<? super String>)
 * *
 * So the type List<? extends Object> is not reifiable, even though it is equivalent to List<?>.
 * Defining reifiable types in this way makes them easy to identify syntactically.
 */
package chapter06.section01;