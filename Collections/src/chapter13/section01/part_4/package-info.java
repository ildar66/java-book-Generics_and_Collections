/**
 * {@link java.util.EnumSet}.
 * *
 * This class exists to take advantage of the efficient implementations that are possible when the number of possible elements is fixed
 * and a unique index can be assigned to each. These two conditions hold for a set of elements of the same {@link java.lang.Enum};
 * the number of keys is fixed by the constants of the enumerated type,
 * and the "ordinal" method returns values that are guaranteed to be unique to each constant.
 * In addition, the values that "ordinal" returns form a compact range, starting from zero — ideal,
 * in fact, for use as array indices or, in the standard implementation, indices of a bit vector.
 * So "add", "remove", and "contains" are implemented as bit manipulations, with constant-time performance.
 * Bit manipulation on a single word is extremely fast, and a long value can be used to represent EnumSets over enum types with up to 64 values.
 * Larger enums can be treated in a similar way, with some overhead, using more than one word for the representation.
 * *
 * {@link java.util.EnumSet} is an abstract class that implements these different representations by means of different package-private subclasses.
 * It hides the concrete implementation from the programmer, instead exposing factory methods that call the constructor for the appropriate subclass.
 * The following group of factory methods provide ways of creating EnumSets with different initial contents:
 * empty, specified elements only, or all elements of the enum.
 * *
 * <E extends Enum<E>> EnumSet<E> of(E first, E... rest) // create a set initially containing the specified elements
 * <E extends Enum<E>> EnumSet<E> range(E from, E to)
 * // create a set initially containing all of the elements in the range defined by the two specified endpoints
 * <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) // create a set initially containing all elements in elementType
 * <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) // create a set of elementType, initially empty
 * *
 * An {@link java.util.EnumSet} contains the reified type of its elements, which is used at run time for checking the validity of new entries.
 * This type is supplied by the above factory methods in two different ways.
 * The methods of and range receive at least one enum argument, which can be queried for its declaring class (that is, the Enum that it belongs to).
 * For "allOf" and "noneOf", which have no enum arguments, a class token is supplied instead.
 * *
 * Common cases for {@link java.util.EnumSet} creation are optimized by the second group of methods,
 * which allow you to efficiently create sets with one, two, three, four, or five elements of an enumerated type.
 * *
 * <E extends Enum<E>> EnumSet<E> of(E e)
 * <E extends Enum<E>> EnumSet<E> of(E e1, E e2)
 * <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3)
 * <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4)
 * <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4, E e5)
 * *
 * The third set of methods allows the creation of an {@link java.util.EnumSet} from an existing collection:
 * <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s) // create an EnumSet with the same element type as s, and with the same elements
 * <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c) // create an EnumSet from the elements of c, which must contain at least one element
 * <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s) // create an EnumSet with the same element type as s, containing the elements not in s
 * (The collection supplied as the argument to the second version of copyOf must be nonempty so that the element type can be determined.)
 * *
 * In use, {@link java.util.EnumSet} obeys the contract for {@link java.util.Set},
 * with the added specification that its iterators will return their elements in their natural order
 * (the order in which their enum constants are declared).
 * *
 * It is not thread-safe, but unlike the unsynchronized general-purpose collections, its iterators are not fail-fast.
 * They may be either snapshot or weakly consistent;
 * to be conservative, the contract guarantees only that they will be weakly consistent (see chapter11.5).
 */
package chapter13.section01.part_4;