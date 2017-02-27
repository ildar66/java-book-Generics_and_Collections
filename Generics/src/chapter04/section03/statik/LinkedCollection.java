package chapter04.section03.statik;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Type parameters are not in scope for nested, static classes.
 */
class LinkedCollection<E> extends AbstractCollection<E> {

    private static class Node<T> {

        private T element;
        private Node<T> next = null;

        private Node(T elt) {
            element = elt;
        }
    }

    private Node<E> first = new Node<E>(null);
    private Node<E> last = first;
    private int size = 0;

    public LinkedCollection() {
    }

    public LinkedCollection(Collection<? extends E> c) {
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E elt) {
        last.next = new Node<E>(elt);
        last = last.next;
        size++;
        return true;
    }

    private static class LinkedIterator<T> implements Iterator<T> {

        private Node<T> current;

        public LinkedIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public T next() {
            if (current.next != null) {
                current = current.next;
                return current.element;
            } else throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator<E>(first);
    }
}
