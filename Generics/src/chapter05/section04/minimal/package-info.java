/**
 * Evolving a Library using Minimal Changes.
 * *
 * To be precise, the changes required are:
 * • Adding type parameters to interface or class declarations as appropriate (for interface Stack<E> and class ArrayStack<E>)
 * • Adding type parameters to any newly parameterized interface or class in an extends or implements clause
 * (for Stack<E> in the implements clause of ArrayStack<E>),
 * • Adding type parameters to each method signature as appropriate (for push and pop in Stack<E> and ArrayStack<E>, and for reverse in Stacks)
 * • Adding an unchecked cast to each return where the return type contains a type parameter(for pop in ArrayStack<E>, where the return type is E)
 * —  without this cast, you will get an error rather than an unchecked warning
 * • Optionally adding annotations to suppress unchecked warnings (for Array Stack<E> and Stacks)
 * *
 * Note that we’ve suppressed warnings on the library classes, but not on the client.
 */
package chapter05.section04.minimal;