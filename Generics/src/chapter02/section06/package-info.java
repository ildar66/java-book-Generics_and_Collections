/**
 * Wildcards Versus Type Parameters.
 * *
 * The designers of the Java libraries chose the first, more liberal, alternative, because someone using the Collections Framework before generics.
 * @see chapter02.section06.WildcardsVersusTypeParameters
 * *
 * However, when designing a new generic library, such as {@link chapter02.section06.WildcardsVersusTypeParameters.MyCollection},
 * when backward compatibility is less important, the design that catches more errors at compile time might make more sense.
 */
package chapter02.section06;