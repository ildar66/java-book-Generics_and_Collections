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
 * *
 * The Get and Put Principle also works the other way around.
 * If an extends wildcard is present, pretty much all you will be able to do is get but not put values of that type;
 * and if a super wildcard is present, pretty much all you will be able to do is put but not get values of that type.
 */
package chapter02.section04;