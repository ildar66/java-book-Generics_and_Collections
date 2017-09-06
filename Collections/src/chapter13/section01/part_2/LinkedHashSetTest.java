package chapter13.section01.part_2;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        Set<Character> s2 = new LinkedHashSet<Character>(8);
        Collections.addAll(s2, 'a', 'b', 'j');
        // iterators of a LinkedHashSet return their elements in proper order:
        assert s2.toString().equals("[a, b, j]");
    }
}