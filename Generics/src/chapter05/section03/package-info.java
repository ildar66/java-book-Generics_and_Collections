/**
 * Generic Library with Legacy Client.
 * *
 * Backward compatibility: where the generic Collections Framework of Java 5 must
 * still work with legacy clients written against the Collections Framework in Java 1.4.
 * *
 * Java also recognizes the corresponding unparameterized version of the type, called a raw type.
 * For instance, the parameterized type Stack<E> corresponds to the raw type Stack,
 * and the parameterized type ArrayStack<E> corresponds to the raw type ArrayStack.
 * *
 * Every parameterized type is a subtype of the corresponding raw type.
 * Usually, it is an error to pass a value of a supertype where a value of its subtype is expected,
 * but Java does permit a value of a raw type to be passed where a parameterized type is expected—
 * however, it flags this circumstance by generating an unchecked conversion warning.
 * For instance, you can assign a value of type Stack<E> to a variable of type Stack.
 * *
 * Because every parameterized type is a subtype of the corresponding raw type, but not conversely,
 * passing a parameterized type where a raw type is expected is safe (hence, no warning for getting the result from reverse),
 * but passing a raw type where a parameterized type is expected issues a warning (hence, the warning when passing an argument to reverse);
 * this is an instance of the Substitution Principle.
 * *
 * When we invoke a method on a receiver of a raw type,
 * the method is treated as if the type parameter is a wildcard,
 * so getting a value from a raw type is safe (hence, no warning for the invocation of pop),
 * but putting a value into a raw type issues a warning (hence, the warning for the invocation of push);
 * this is an instance of the Get and Put Principle.
 */
package chapter05.section03;