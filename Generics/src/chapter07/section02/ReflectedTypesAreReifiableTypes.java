package chapter07.section02;

import java.util.ArrayList;
import java.util.List;

/**
 * Reflected Types are Reifiable Types.
 */
public class ReflectedTypesAreReifiableTypes {

    public static void main(String[] args) {
        // If you try to reflect a parameterized type, you get the reified information for the corresponding raw type:
        List<Integer> ints = new ArrayList<Integer>();
        List<String> strs = new ArrayList<String>();
        assert ints.getClass() == strs.getClass();
        assert ints.getClass() == ArrayList.class;

        // In general, if expression e has type T,
        // then the expression e.getClass() has type Class<? extends |T|>, where |T| is the erasure of the type T:
        List<Integer> ints1 = new ArrayList<Integer>();
        Class<? extends List> k = ints1.getClass();
        assert k == ArrayList.class;
        // System.out.println(k == ArrayList.class);
    }
}

// Class literals are also restricted
class ClassLiteral {

    // public Class<?> k = List<Integer>.class; // syntax error
    // public Class<?> k = List<?>.class; // syntax error
    public Class<?> k = List.class;
}
