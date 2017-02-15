/**
 * The Get and Put Principle.
 * *
 * The Get and Put Principle:
 * use an extends wildcard when you only get values out of a structure,
 * use a super wildcard when you only put values into a structure,
 * and don’t use a wildcard when you both get and put.
 * *
 * public static <T> void copy(List<? super T> dest, List<? extends T> src){...}
 * *
 * @see chapter02.section04.TheGetAndPutPrinciple
 */
package chapter02.section04;