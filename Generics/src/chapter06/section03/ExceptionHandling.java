package chapter06.section03;

/**
 * Exception Handling.
 */
public class ExceptionHandling {

    public static void main(String[] args) {
        // IntegerExceptionTest:
        try {
            throw new IntegerException(42);
        } catch (IntegerException e) {
            assert e.getValue() == 42;
        }

        /*try {
            throw new ParametricException<Integer>(42);
        } catch (ParametricException<Integer> e) { // compile-time error
            assert e.getValue() == 42;
        }*/
    }
}

class IntegerException extends Exception {

    private final int value;

    public IntegerException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/*
// In contrast, the following definition of a new exception is prohibited, because it creates a parameterized type:
class ParametricException<T> extends Exception { // compile-time error

    private final T value;

    public ParametricException(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}*/
