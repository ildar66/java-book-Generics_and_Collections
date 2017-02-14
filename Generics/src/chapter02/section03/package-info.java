/**
 * Wildcards with super.
 * *
 * The quizzical phrase ? super T means that the destination list may have elements of any type that is a supertype of T,
 * just as the source list may have elements of any type that is a subtype of T.
 * @see chapter02.section03.WildcardsWithSuper
 * *
 * We could also declare the method with several possible signatures:
 * public static <T> void copy(List<T> dst, List<T> src)
 * public static <T> void copy(List<T> dst, List<? extends T> src)
 * public static <T> void copy(List<? super T> dst, List<T> src)
 * public static <T> void copy(List<? super T> dst, List<? extends T> src)
 * *
 * The first of these is too restrictive, as it only permits calls when the destination and source have exactly the same type.
 * The remaining three are equivalent for calls that use implicit type parameters, but differ for explicit type parameters.
 * For the example calls above, the second signature works only when the type parameter is Object,
 * the third signature works only when the type parameter is Integer,
 * and the last signature works (as we have seen) for all three type parameters—i.e., Object, Number, and Integer.
 * *
 * Always use wildcards where you can in a signature, since this permits the widest range of calls.
 */
package chapter02.section03;