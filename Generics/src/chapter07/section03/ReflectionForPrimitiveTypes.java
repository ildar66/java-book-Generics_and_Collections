package chapter07.section03;

/**
 * Reflection for Primitive Types.
 */
public class ReflectionForPrimitiveTypes {

    public static void main(String[] args) {
        // public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
        System.out.println(int.class == Integer.TYPE);

        // you might expect the call to return a value of type Integer[], but:
        int size = 10;
        // Integer[] arr = (Integer[]) java.lang.reflect.Array.newInstance(int.class, size); // ClassCastException
        int[] arr = (int[]) java.lang.reflect.Array.newInstance(int.class, size);
        System.out.println(arr.getClass() == int[].class);
    }

}
