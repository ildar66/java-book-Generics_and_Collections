/**
 * Nested Classes.
 * *
 * If the outer class has type parameters and the inner class is not static, then type parameters of the outer class
 * are visible within the inner class: {@link chapter04.section03.nonstatic.LinkedCollection}.
 * *
 * Type parameters are not in scope for nested, static classes: {@link chapter04.section03.statik.LinkedCollection}.
 * *
 * Of the two alternatives described here, the second(static) is preferable.
 * *
 * Nested classes that are not static are implemented by including a reference to the enclosing instance,
 * since they may, in general, access components of that instance.
 * Static nested classes are usually both simpler and more efficient.
 */
package chapter04.section03;