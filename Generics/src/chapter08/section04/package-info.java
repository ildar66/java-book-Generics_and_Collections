/**
 * Maintain Binary Compatibility.
 * *
 * As we have stressed, generics are implemented via erasure in order to ease evolution.
 * When evolving legacy code to generic code, we want to ensure that the newly-generified code will work with any existing code,
 * including class files for which we do not have the source.
 * When this is the case, we say that the legacy and generic versions are binary compatible.
 * *
 * Binary compatibility is guaranteed if the erasure of the signature of the generic code is identical to the signature of the legacy code
 * and if both versions compile to the same bytecode.
 * Usually, this is a natural consequence of generification, but in this section we look at some of the corner cases that can cause problems.
 * *********************
 * Adjusting the Erasure:
 * // legacy version
 * public static Object max(Collection coll)
 * // generic version -- breaks binary compatibility
 * public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
 * // generic version -- maintains binary compatibility
 * public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
 * *********************
 * Bridges:
 * // legacy version
 * public class Integer implements Comparable {
 * public int compareTo(Object o) { ... }
 * public int compareTo(Integer i) { ... }
 * ...
 * }
 * // generic version -- maintains binary compatibility
 * public final class Integer implements Comparable<Integer> {
 * public int compareTo(Integer i) { ... }
 * ...
 * }
 * Both versions have the same bytecode, because the compiler generates a bridge method for compareTo with an argument of type Object
 * *
 * However, some legacy code contains only the Object method.
 * // legacy version
 * public interface Name extends Comparable {
 * public int compareTo(Object o);
 * ...
 * }
 * // generic version -- breaks binary compatibility
 * public interface Name extends Comparable<Name> {
 * public int compareTo(Name n);
 * ...
 * }
 * @see chapter08.section04.legacy.Client
 * @see chapter08.section04.generified.Test
 * The only solution is to choose a less-ambitious generification:
 * // generic version -- maintains binary compatibility
 * public interface Name extends Comparable<Object> {
 * public int compareTo(Object o) { ... }
 * ...
 * }
 * **********************
 * Covariant Overriding:
 * class Object {
 * public Object clone() { ... }
 * ...
 * }
 * // legacy version
 * class HashSet {
 * public Object clone() { ... }
 * ...
 * }
 * // generic version -- breaks binary compatibility
 * class HashSet {
 * public HashSet clone() { ... }
 * ...
 * }
 * The only solution is to choose a less-ambitious generification:
 * // generic version -- maintains binary compatibility
 * class HashSet {
 * public Object clone() { ... }
 * ...
 * }
 * This is guaranteed to be compatible with any subclass that the user may have defined.
 * Again, you have more freedom if you can also generify any subclasses, or if the class is final.
 */
package chapter08.section04;