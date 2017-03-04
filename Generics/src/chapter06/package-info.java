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
 */
package chapter06;