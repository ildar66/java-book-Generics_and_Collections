package chapter05.section04.minimal;

@SuppressWarnings("unchecked")
class Stacks {

    public static <E> Stack<E> reverse(Stack<E> in) {
        Stack out = new ArrayStack();
        while (!in.empty()) {
            Object elt = in.pop();
            out.push(elt);  // unchecked call
        }
        return out;  // unchecked conversion
    }
}
