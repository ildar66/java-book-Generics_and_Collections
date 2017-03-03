package chapter05.section04.wrapper;

import chapter05.section01.Stack;

/**
 * Don't do this---use of wrappers is not recommended!
 */
interface GenericStack<E> {

    public Stack unwrap();

    public boolean empty();

    public void push(E elt);

    public E pop();
}
