package chapter04.section01;

/**
 * Constructors.
 */
public class Constructors {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("one", 2);
        assert pair.getFirst().equals("one") && pair.getSecond() == 2;

        // A common mistake is to forget the type parameters when invoking the constructor:
        pair = new Pair("one", 2);
    }
}

class Pair<T, U> {

    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
