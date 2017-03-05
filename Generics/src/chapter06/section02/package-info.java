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
 * *
 * Unchecked casts.
 * Only rarely will the compiler be able to determine that if a cast to a nonreifiable type succeeds then it must yield a value of that type.
 * @see chapter06.section02.Promote
 * In the remaining cases, a cast to a type that is not reifiable is flagged with an unchecked warning,
 * whereas an instance test against a type that is not reifiable is always caught as an error.
 * This is because there is never any point to an instance test that cannot be performed, but there may be a point to a cast that cannot be checked.
 * *
 * * This technique is important for fitting together legacy and generic code,
 * and is one of the chief reasons for using erasure to implement generics. {@link chapter06.section02.Promote#promote(java.util.List)}
 * *
 * Unchecked casts in C (and in its descendant C++) are much more dangerous than unchecked casts in Java.
 * Unlike C, the Java runtime guarantees important security properties even in the presence of unchecked casts;
 * for instance, it is never permitted to access an array with an index outside of the array bounds.
 * Nonetheless, unchecked casts in Java are a workaround that should be used with caution.
 */
package chapter06.section02;