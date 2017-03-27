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
 * Example 9-3 illustrates how to implement the toString and sum methods on trees within the client,
 * rather than within the class that defines the data structure.
 */
package chapter09.section01;