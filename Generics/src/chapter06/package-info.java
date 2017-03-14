/**
 * Reification.
 * *
 * In computing, reification has come to mean an explicit representation of a type—that is,
 * run-time type information.
 * In Java, arrays reify information about their component types,
 * while generic types do not reify information about their type parameters.
 * *
 * Legacy code makes no distinction between List<Integer> and List<String> and List<List<String>>,
 * so not reifying parameter types is essential to easing evolution
 * and promoting compatibility between legacy code and new code.
 * *
 * Summing Up
 * We conclude by giving a checklist of places where reifiable types are required or recommended.
 * • An instance test must be against a reifiable type.
 * • A cast should usually be to a reifiable type. (A cast to a nonreifiable type usually issues an unchecked warning.)
 * • A class that extends Throwable must not be parameterized.
 * • An array instance creation must be at a reifiable type.
 * • The reified type of an array must be a subtype of the erasure of its static type (see the Principle of Truth in Advertising),
 * and a publicly exposed array should be of a reifiable type (see the Principle of Indecent Exposure).
 * • Varargs should be of a reifiable type. (A vararg of a nonreifiable type will issue an unchecked warning.)
 * These restrictions arise from the fact that generics are implemented via erasure,
 * and they should be regarded as the price one pays for the ease of evolution that we explored in the previous chapter.
 * *
 * For completeness, we also list restrictions connected with reflection:
 * • Class tokens correspond to reifiable types, and the type parameter in Class<T> should be a reifiable type.
 * These are discussed in the next chapter.
 */
package chapter06;