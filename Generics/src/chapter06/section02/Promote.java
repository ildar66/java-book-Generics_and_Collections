package chapter06.section02;

import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public class Promote {

    /* It is illegal to cast a list of objects to a list of strings, so the cast must take place in two steps.
       First, cast the list of objects into a list of wildcard type; this cast is safe.
       Second, cast the list of wildcard type into a list of strings; this cast is permitted but generates an unchecked warning*/
    public static List<String> promote(List<Object> objs) {
        for (Object o : objs)
            if (!(o instanceof String))
                throw new ClassCastException();
        return (List<String>) (List<?>) objs; // unchecked cast
    }

    public static void main(String[] args) {
        List<Object> objs1 = Arrays.<Object>asList("one", "two");
        List<Object> objs2 = Arrays.<Object>asList(1, "two");
        List<String> strs1 = promote(objs1);
        assert (List<?>) strs1 == (List<?>) objs1;
        boolean caught = false;
        try {
            List<String> strs2 = promote(objs2);
        } catch (ClassCastException e) {
            caught = true;
        }
        assert caught;
    }
}
