/**
 * Subject-Observer.
 * *
 * Like the Strategy pattern, the Subject-Observer pattern uses parallel class hierarchies,
 * but this time we require two type variables with mutually recursive bounds,
 * one to stand for the specific kind of subject and one to stand for the specific kind of observer.
 * This is our first example of type variables with mutually recursive bounds.
 * *
 * The Java library implements a nongeneric version of the Subject-Observer pattern in the package java.util
 * with the class {@link java.util.Observable} and the interface {@link java.util.Observer}(the former corresponding to the subject).
 * *
 * The appearance of Object in a method signature often indicates an opportunity to generify.
 * So we should expect to generify the classes by adding a type parameter, A, corresponding to the argument type.
 * Further, we can replace Observable and Observer themselves with the type parameters S and O (for Subject and Observer).
 * Then within the update method of the observer, you may call on any method supported by the subject S without first requiring a cast.
 * *
 * @see chapter09.section05.generics
 * Example shows how to specify corresponding generic signatures for the Observa ble class and the Observer interface.
 * *
 * Both declarations take the same three type parameters.
 * The declarations are interesting in that they illustrate that the scope of type parameters can be mutually recursive:
 * all three type parameters appear in the bounds of the first two.
 * Previously, we saw other examples of simple recursion—for instance, in the declarations of Comparable and Enum,
 * and in the previous section on the Strategy pattern.
 * But this is the first time we have seen mutual recursion.
 * *
 * The generic declarations use stubs, as explained in {@link chapter05.section04.stubs}.
 * We compile the client against the generic signatures of Observable and Observer,
 * but run the code against the class files in the standard Java distribution.
 * We use stubs because we don’t want to make any changes to the source of the library, since it is maintained by Sun.
 */
package chapter09.section05;