package chapter09.section01.combine;

/**
 * A client with with combine visitors and simple approach.
 */
class TreeClient {

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
        System.out.println("combine visitors and simple: " + t + "; sum() = " + sum(t));
        assert t.equals("((1^2)^3)");
        assert sum(t) == 6;
    }
}
