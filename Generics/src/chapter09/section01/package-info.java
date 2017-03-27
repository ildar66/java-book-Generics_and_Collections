/**
 * Visitor.
 * *
 * Often, a data structure is defined by case analysis and recursion.
 * For example, a binary tree of type Tree<E> is one of the following:
 * • A leaf, containing a single value of type E
 * • A branch, containing a left subtree and a right subtree, both of type Tree<E>
 * *
 * Example {@link chapter09.section01.simple.Tree} illustrates this technique applied to trees.
 * This approach is adequate if you know in advance all of the operations required on the data structure,
 * or can modify the classes that define the structure when the requirements change.
 * *
 * However, sometimes this is not the case, particularly when different developers are responsible for the classes
 * that define the structure and the classes that are clients of the structure.
 * *
 * The Visitor pattern makes it possible to provide new operations without modifying the classes that define the data structure.
 * Example {@link chapter09.section01.visitors.Tree} illustrates this pattern applied to trees.
 * *
 * Example {@link chapter09.section01.visitors.TreeClient} illustrates how to implement the toString and sum methods on trees within the client,
 * rather than within the class that defines the data structure.
 * *
 * It is interesting to note that the generic type of the sum method can be more precise with visitors:
 * • With simple trees, the sum method must have a type signature that indicates that it works on any element type;
 * a cast is required to convert each leaf to type Number;
 * and a class cast error is raised at run time if sum is invoked on a tree not containing numbers.
 * • With visitors, the sum method may have a type signature that indicates that it works only on elements that are numbers;
 * no cast is required; and a type error is reported at compile time if sum is invoked on a tree not containing numbers.
 * *
 * In practice, you will often use a combination of the simple approach and the Visitor pattern.
 * For instance,
 * you might choose to define standard methods, such as "toString": {@link chapter09.section01.combine.Tree#toString()} , using the simple approach,
 * while using Visitor for other methods, such as "sum": {@link chapter09.section01.combine.TreeClient#sum(chapter09.section01.combine.Tree)}.
 */
package chapter09.section01;