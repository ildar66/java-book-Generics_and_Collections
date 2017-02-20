/**
 * Comparable.
 * *
 * @see chapter03.section01.ComparableSample
 * *
 * Consistent with Equals:
 * Usually, we require that two objects are equal if and only if they compare as the same:
 * x.equals(y) if and only if x.compareTo(y) == 0
 * *
 * Almost every class in the Java core libraries that has a natural ordering is consistent with equals.
 * (exception is java.math.BigDecimal - compares as the same two decimals that have the same value but different precisions, such as 4.0 and 4.00)
 * *
 * If x is not null, x. equals(null) must return false, while x.compareTo(null) must throw a Null PointerException.
 */
package chapter03.section01;