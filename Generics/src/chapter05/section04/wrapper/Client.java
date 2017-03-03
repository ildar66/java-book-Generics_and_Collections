package chapter05.section04.wrapper;

import chapter05.section01.ArrayStack;

/**
 * Don't do this---use of wrappers is not recommended!..
 */
class Client {

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStackWrapper<Integer>(new ArrayStack());
        for (int i = 0; i < 4; i++) stack.push(i);
        assert stack.toString().equals("stack[0, 1, 2, 3]");
        int top = stack.pop();
        assert top == 3 && stack.toString().equals("stack[0, 1, 2]");
        GenericStack<Integer> reverse = GenericStacks.reverse(stack);
        assert stack.empty();
        assert reverse.toString().equals("stack[2, 1, 0]");
    }
}
