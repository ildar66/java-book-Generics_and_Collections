/**
 * Reflected Types are Reifiable Types.
 * *
 * If you try to reflect a parameterized type,
 * you get the reified information for the corresponding raw type:
 * {@link chapter07.section02.ReflectedTypesAreReifiableTypes#main(java.lang.String[])}
 * *
 * Class literals are also restricted: {@link chapter07.section02.ClassLiteral}
 * *
 * This syntax problem leads to an irregularity.
 * Everywhere else that a reifiable type is required, you may supply either a raw type (such as List)
 * or a parameterized type with unbounded wildcards (such as List<?>).
 * However, for class tokens, you must supply a raw type; not even unbounded wildcards may appear.
 * *
 * The restrictions on class tokens lead to a useful property. Wherever a type of the form
 * Class<T> appears, the type T should be a reifiable type. The same is true for types of the
 * form T[].
 */
package chapter07.section02;