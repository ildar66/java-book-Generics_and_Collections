/**
 * Restrictions on Wildcards.
 * *
 * Wildcards may not appear at the top level in class instance creation expressions (new),
 * in explicit type parameters in generic method calls,
 * or in supertypes (extends and implements).
 * @see chapter02.section08.RestrictionsOnWildcards
 * *
 * One way to remember the restriction is that the relationship between wildcards and ordinary types
 * is similar to the relationship between interfaces and classes—wildcards and interfaces are more general,
 * ordinary types and classes are more specific, and instance creation requires the more specific information.
 * List<?> list = new ArrayList<Object>(); // ok
 * List<?> list = new List<Object>() // compile-time error
 * List<?> list = new ArrayList<?>() // compile-time error
 */
package chapter02.section08;