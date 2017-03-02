package chapter05.section04.stubs;

import java.util.List;

interface Stack<E> extends List<E> {

    public boolean empty();

    public void push(E elt);

    public E pop();
}
