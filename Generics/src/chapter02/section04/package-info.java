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
 * *
 * You may find it helpful to think of ? extends T as containing every type in an interval bounded by the type of null below
 * and by T above (where the type of null is a subtype of every reference type).
 * Similarly, you may think of ? super T as containing every type in an interval bounded by T below and by Object above.
 */
package chapter02.section04;