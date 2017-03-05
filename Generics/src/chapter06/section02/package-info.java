/**
 * Instance Tests and Casts.
 * *
 * Instance tests and casts depend on examining types at run time, and hence depend on reification.
 * For this reason, an instance test against a type that is not reifiable reports an error,
 * and a cast to a type that is not reifiable usually issues a warning.
 * *
 * @see chapter06.section02.InstanceTestsAndCasts
 * *
 * We recommend using unbounded wildcard types in preference to raw types because they provide stronger static typing guarantees;
 * many mistakes that are caught as an error when you use unbounded wildcards will only be flagged as a warning if you use raw types.
 * *
 * We recommend always using type declarations that are as specific as possible;
 * this helps the compiler to catch more errors and to compile more-efficient code.
 * *
 * Nonreifiable Casts. An instance test against a type that is not reifiable is always an error.
 * However, in some circumstances a cast to a type that is not reifiable is permitted.
 * @see chapter06.section02.InstanceTestsAndCasts#asList(java.util.Collection)
 */
package chapter06.section02;