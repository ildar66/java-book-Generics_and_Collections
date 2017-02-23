/**
 * Enumerated Types.
 * *
 * Java 5 includes support for enumerated types. Example: enum Season { WINTER, SPRING, SUMMER, FALL }.
 * *
 * Each class that corresponds to an enumerated type is a subclass of {@link java.lang.Enum}: class Enum<E extends Enum<E>>
 * @see chapter03.section05.EnumeratedTypes
 * *
 * Without the type variable, the declaration of the Enum class would begin like this: class Enum implements Comparable<Enum>
 * And the declaration for the Season class would begin like this: class Season extends Enum
 * *
 * In general, patterns like T extends Comparable<T> and E extends Enum<E> often arise when you want to pin down types precisely.
 */
package chapter03.section05;