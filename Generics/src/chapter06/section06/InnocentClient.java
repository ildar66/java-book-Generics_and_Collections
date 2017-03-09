package chapter06.section06;

import java.util.Arrays;
import java.util.List;

/**
 * Example demonstrate how a poorly designed library can create problems for an innocent client.
 */

public class InnocentClient {

    public static void main(String[] args) {
        // arrays of numbers are replaced by arrays of lists of numbers:
        List<Integer>[] intLists = DeceptiveLibrary.intLists(1);
        List<? extends Number>[] numLists = intLists;
        numLists[0] = Arrays.asList(1.01);
        int i = intLists[0].get(0); // class cast error!

        // example of why reification is necessary:
        Integer[] ints = new Integer[] {1};
        Number[] nums = ints;
        nums[0] = 1.01; // array store exception
        int n = ints[0];
    }
}