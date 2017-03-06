/**
 * Exception Handling.
 * *
 * In a try statement, each catch clause checks whether the thrown exception matches a given type.
 * This is the same as the check performed by an instance test, so the same restriction applies:
 * the type must be reifiable.
 * @see chapter06.section03.ExceptionHandling
 * Type in a catch clause is required to be a subclass of Throwable.
 * Since there is little point in creating a subclass of Throwable that cannot appear in a catch clause,
 * the Java compiler complains if you attempt to create a parameterized subclass of Throwable.
 * *
 * Because exceptions cannot be parametric, the syntax is restricted so that the type must be written as an identifier, with no following parameter.
 * Type Variable in a Throws Clause Although subclasses of Throwable cannot be parametric,
 * NOTE: it is possible to use a type variable in the throws clause of a method declaration.
 */
package chapter06.section03;