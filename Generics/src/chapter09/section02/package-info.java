/**
 * Interpreter.
 * *
 * One use of trees is to represent expressions in a programming language.
 * As in the previous section, the expression type is represented by an abstract class, with each kind of expression represented by a subclass.
 * There is an abstract method to evaluate an expression, and each subclass implements the method as appropriate for the corresponding kind of
 * expression.
 * *
 * Example {@link chapter09.section02.Interpreter} demonstrates the Interpreter pattern with generics.
 * It begins by defining a class Pair<A, B>, with a constructor and two methods to select the left and right components of a pair.
 * It then declares an abstract class, Exp<A>, for an expression that returns a value of type A,
 * with an abstract method eval that returns a value of type A.
 * *
 * In our example, there are five kinds of expression:
 * • An integer literal, of type Exp<Integer>
 * • A sum expression, of type Exp<Integer>, which has two subexpressions, each of type Exp<Integer>
 * • An expression to construct a pair, of type Exp<Pair<A, B>>, which has two subexpressions of type Exp<A> and Exp<B>
 * • An expression to select the left component of a pair, of type Exp<A>, which has a subexpression of type Exp<Pair<A, B>>
 * • An expression to select the right component of a pair, of type Exp<B>, which has a subexpression of type Exp<Pair<A, B>>
 * *
 * Generics in Java were inspired by similar features in functional languages such as ML and Haskell.
 * The generic Interpreter pattern is interesting because it shows a way
 * in which generics in Java are more powerful than generics in these other languages.
 * It is not possible to implement this pattern in the standard versions of ML and Haskell,
 * although a recent version of Haskell includes an experimental feature,
 * generalized abstract data types, designed specifically to support this pattern.
 */
package chapter09.section02;