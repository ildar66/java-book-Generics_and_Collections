/**
 * Evolving a Library using Stubs.
 * *
 * @see chapter05.section04.stubs.Client
 * *
 * Here we write stubs with generic signatures but no bodies.
 * We compile the generic client against the generic signatures, but run the code against the legacy class files.
 * This technique is appropriate when the source is not released, or when others are responsible for maintaining the source.
 * *
 * We introduce the same modifications to interface and class declarations and method signatures as with the minimal changes technique,
 * except we completely delete all executable code, replacing each method body with code that throws a StubException
 * (a new exception that extends UnsupportedOperationException).
 */
package chapter05.section04.stubs;