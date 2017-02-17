package chapter02.section07;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcard Capture.
 */
public class WildcardCapture {

    /* method reverse in the convenience class java.util.Collections can be given:
    public static void reverse(List<?> list);
    public static void <T> reverse(List<T> list); */

    // If you use the second signature, it is easy to implement the method:
    public static <T> void reverse1(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    // If you try to use the first signature with a similar method body, it won’t work:
    public static void reverse2(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
            // list.set(i, tmp.get(list.size() - i - 1)); // compile-time error
        }
    }

    // Instead, you can implement the method with the first signature by implementing a private method with the second signature,
    // and calling the second from the first:
    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }
}
