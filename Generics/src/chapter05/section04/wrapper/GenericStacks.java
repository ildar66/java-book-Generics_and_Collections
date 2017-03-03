package chapter05.section04.wrapper;

import chapter05.section01.Stack;
import chapter05.section01.Stacks;

/**
 * Don't do this---use of wrappers is not recommended!
 */
class GenericStacks {

    public static <T> GenericStack<T> reverse(GenericStack<T> in) {
        Stack rawIn = in.unwrap();
        Stack rawOut = Stacks.reverse(rawIn);
        return new GenericStackWrapper<T>(rawOut);
    }
}
