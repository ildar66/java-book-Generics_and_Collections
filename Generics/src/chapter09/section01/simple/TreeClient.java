package chapter09.section01.simple;

/**
 * A simple tree and client.
 */
abstract class Tree<E> {

    abstract public String toString();

    abstract public Double sum();

    public static <E> Tree<E> leaf(final E e) {
        return new Tree<E>() {

            public String toString() {
                return e.toString();
            }

            public Double sum() {
                return ((Number) e).doubleValue();
            }
        };
    }

    public static <E> Tree<E> branch(final Tree<E> l, final Tree<E> r) {
        return new Tree<E>() {

            public String toString() {
                return "(" + l.toString() + "^" + r.toString() + ")";
            }

            public Double sum() {
                return l.sum() + r.sum();
            }
        };
    }
}

class TreeClient {

    public static void main(String[] args) {
        Tree<Integer> t = Tree.branch(Tree.branch(Tree.leaf(1), Tree.leaf(2)), Tree.leaf(3));
        System.out.println(t + "; sum = " + t.sum());
        assert t.toString().equals("((1^2)^3)");
        assert t.sum() == 6;
    }
}
