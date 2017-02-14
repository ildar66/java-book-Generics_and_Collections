package chapter02.section01;

import java.util.ArrayList;
import java.util.List;

/**
 * Subtyping and the Substitution Principle exampless.
 */
public class SubtypingAndTheSubstitutionPrinciple {

    /* interface Collection<E> {
        public boolean add(E elt);
        ...
    }*/
    public static void main(String[] args) {
        // Substitution Principle. Integer and Double are subtypes of Number:
        List<Number> nums = new ArrayList<Number>();
        nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");

        // It is not always safe to assign a value of type List<Integer> to a variable of type List<Number>:
        // List<Integer> is not a subtype of List<Number>
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        // nums = ints; // compile-time error
        nums.add(3.14);
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

    }
}
