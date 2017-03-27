package chapter09.section01.combine;

/**
 * A tree with combine visitors and simple approach.
 */
abstract class Tree<E> {

    public interface Visitor<E, R> {

        public R leaf(E elt);

        public R branch(R left, R right);
    }

    public abstract <R> R visit(Visitor<E, R> v);

    abstract public String toString();

    public static <T> Tree<T> leaf(final T e) {
        return new Tree<T>() {

            public <R> R visit(Visitor<T, R> v) {
                return v.leaf(e);
            }

            public String toString() {
                return e.toString();
            }
        };
    }

    public static <T> Tree<T> branch(final Tree<T> l, final Tree<T> r) {
        return new Tree<T>() {

            public <R> R visit(Visitor<T, R> v) {
                return v.branch(l.visit(v), r.visit(v));
            }

            public String toString() {
                return "(" + l.toString() + "^" + r.toString() + ")";
            }
        };
    }
}
