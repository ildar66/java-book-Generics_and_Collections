package chapter09.section01.visitors;

/**
 * A client with visitors.
 */
class TreeClient {

    public static <T> String toString(Tree<T> t) {
        return t.visit(new Tree.Visitor<T, String>() {

            public String leaf(T e) {
                return e.toString();
            }

            public String branch(String l, String r) {
                return "(" + l + "^" + r + ")";
            }
        });
    }

    public static <N extends Number> double sum(Tree<N> t) {
        return t.visit(new Tree.Visitor<N, Double>() {

            public Double leaf(N e) {
                return e.doubleValue();
            }

            public Double branch(Double l, Double r) {
                return l + r;
            }
        });
    }

    public static void main(String[] args) {
        Tree<Integer> t = Tree.branch(Tree.branch(Tree.leaf(1), Tree.leaf(2)), Tree.leaf(3));
        System.out.println(toString(t) + "; sum with visitors = " + sum(t));
        assert toString(t).equals("((1^2)^3)");
        assert sum(t) == 6;
    }
}
