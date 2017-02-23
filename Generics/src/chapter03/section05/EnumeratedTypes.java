package chapter03.section05;

/**
 * Enumerated Types.
 */
class EnumeratedTypes {

}

/**
 * Base class for enumerated types.
 */
abstract class Enum<E extends Enum<E>> implements Comparable<E> {

    private final String name;
    private final int ordinal;

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return ordinal;
    }

    public String toString() {
        return name;
    }

    public final int compareTo(E o) {
        return ordinal - o.ordinal();
    }
}

// corresponds to enum Season { WINTER, SPRING, SUMMER, FALL }
final class Season extends Enum<Season> {

    private Season(String name, int ordinal) {
        super(name, ordinal);
    }

    public static final Season WINTER = new Season("WINTER", 0);
    public static final Season SPRING = new Season("SPRING", 1);
    public static final Season SUMMER = new Season("SUMMER", 2);
    public static final Season FALL = new Season("FALL", 3);
    private static final Season[] VALUES = {WINTER, SPRING, SUMMER, FALL};

    public static Season[] values() {
        return VALUES.clone();
    }

    public static Season valueOf(String name) {
        for (Season e : VALUES) if (e.name().equals(name)) return e;
        throw new IllegalArgumentException();
    }
}
