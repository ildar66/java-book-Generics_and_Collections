/**
 * A Fruity Example.
 * *
 * Prohibiting comparison of apples with oranges: {@link chapter03.section03.prohibit.Test}
 * class Fruit {...}
 * class Apple extends Fruit implements Comparable<Apple> {...}
 * class Orange extends Fruit implements Comparable<Orange> {...}
 * *
 * Permitting comparison of apples with oranges: {@link chapter03.section03.permit.Test}
 * class Fruit implements Comparable<Fruit> {...}
 * class Apple extends Fruit {...}
 * class Orange extends Fruit {...}
 * *
 * Recall that at the end of the previous section we extended the type signature of compareTo to use super:
 * <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
 * @see generics.Comparators#max(java.util.Collection)
 * *
 * If we want to compare two oranges, we take T in the preceding code to be Orange:
 * Orange extends Comparable<? super Orange>
 * And this is true because both of the following hold:
 * Orange extends Comparable<Fruit> and Fruit super Orange
 * *
 * Also note that the natural ordering used here is not consistent with equals {@link chapter03.section01}.
 * Two fruits with different names but the same size compare as the same, but they are not equal.
 */
package chapter03.section03;