/**
 * Strategy.
 * *
 * The Strategy pattern is used to decouple a method from an object, allowing you to supply many possible instances of the method.
 * Our discussion of the Strategy pattern illustrates a structuring technique found in many object-oriented programs,
 * that of parallel class hierarchies.
 * *
 * We will illustrate the Strategy pattern by considering how tax payers may apply different tax strategies.
 * There will be a hierarchy for tax payers, and a related hierarchy for tax strategies.
 * For example, there is a default strategy that applies to any tax payer.
 * One subclass of tax payer is a trust, and one subclass of the default strategy is one that applies only to trusts.
 * *
 * Our discussion will also illustrate a technique often used with generic types—the use of type variables with recursive bounds.
 * *
 * Parallel Class Hierarchies:
 * A typical use of the Strategy pattern is for tax computation, as shown in Example {@link chapter09.section04.basic}
 * We have a class {@link chapter09.section04.basic.TaxPayer}
 * with subclasses {@link chapter09.section04.basic.Person} and {@link chapter09.section04.basic.Trust}.
 */
package chapter09.section04;