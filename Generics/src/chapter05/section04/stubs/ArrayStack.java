package chapter05.section04.stubs;

import java.util.ArrayList;

class ArrayStack<E> extends ArrayList<E> implements Stack<E> {

    public boolean empty() {
        throw new StubException();
    }

    public void push(E elt) {
        throw new StubException();
    }

    public E pop() {
        throw new StubException();
    }
}
