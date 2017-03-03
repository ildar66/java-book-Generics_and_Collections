package chapter05.section04.wrapper;

import chapter05.section01.Stack;

/**
 * Don't do this---use of wrappers is not recommended!
 */
class GenericStackWrapper<E> implements GenericStack<E> {

    private Stack stack;

    public GenericStackWrapper(Stack stack) {
        this.stack = stack;
    }

    public Stack unwrap() {
        return stack;
    }

    public boolean empty() {
        return stack.empty();
    }

    public void push(E elt) {
        stack.push(elt);
    }

    public E pop() {
        return (E) stack.pop();
    } // unchecked cast

    public String toString() {
        return stack.toString();
    }
}
