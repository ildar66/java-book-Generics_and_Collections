/**
 * Assertions.
 * *
 * Assertions are enabled by invoking the JVM with the -ea or -enableassertions flag.
 * *
 * We only write assertions that we expect to evaluate to true.
 * Since assertions may not be enabled, an assertion should never have side effects upon which any non-assertion code depends.
 * When checking for a condition that might not hold (such as confirming that the arguments to a method call are valid),
 * we use a conditional and throw an exception explicitly.
 * *
 */
package chapter01.section05;