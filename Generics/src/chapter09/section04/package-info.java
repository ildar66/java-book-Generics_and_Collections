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
 * **************************
 * Parallel Class Hierarchies:
 * A typical use of the Strategy pattern is for tax computation, as shown in Example {@link chapter09.section04.basic.Test}
 * We have a class {@link chapter09.section04.basic.TaxPayer}
 * with subclasses {@link chapter09.section04.basic.Person} and {@link chapter09.section04.basic.Trust}.
 * *
 * This example illustrates a structuring technique found in many object-oriented programs — that of parallel class hierarchies.
 * In this case, one class hierarchy consists of TaxPayer, Person, and Trust.
 * A parallel class hierarchy consists of strategies corresponding to each of these: two strategies,
 * {@link chapter09.section04.basic.DefaultTaxStrategy} and {@link chapter09.section04.basic.DodgingTaxStrategy} apply to any TaxPayer,
 * no specialized strategies apply to {@link chapter09.section04.basic.Person},
 * and there is one specialized strategy for {@link chapter09.section04.basic.Trust}.
 * **************************
 * An Advanced Strategy Pattern with Recursive Generics:
 * In more advanced uses of the Strategy pattern, an object contains the strategy to be applied to it.
 * Modelling this situation requires recursive generic types and exploits a trick to assign a generic type to this.
 * *
 * The revised Strategy pattern is shown in Example {@link chapter09.section04.advanced.Test}
 * This structure is often preferable, since one may associate a given tax strategy directly with a given tax payer.
 * *
 * Before, we used a class TaxPayer and an interface TaxStrategy<P>,
 * where the type variable P stands for the subclass of TaxPayer to which the strategy applies.
 * Now we must add the type parameter P to both, in order that the class TaxPayer<P> can have a field of type TaxStrategy<P>.
 * The new declaration for the type variable P is necessarily recursive,
 * as seen in the new header for the {@link chapter09.section04.advanced.TaxPayer} class: class TaxPayer<P extends TaxPayer<P>>
 * *
 * We have seen similar recursive headers before:
 * interface Comparable<T extends Comparable<T>>
 * class Enum<E extends Enum<E>>
 * *
 * In the base class TaxPayer<P> we define an abstract method getThis that is intended to return the same value as this but gives it the type P.
 * The method is instantiated in each class that corresponds to a specific kind of tax payer,
 * such as Person or Trust, where the type of this is indeed the same as the type P.
 * In outline, the corrected code now looks like this:
 * @see chapter09.section04.advanced.TaxPayer#getThis()
 * @see chapter09.section04.advanced.Person#getThis()
 * @see chapter09.section04.advanced.Trust#getThis()
 * *
 * Say we wanted a subclass NonProfitTrust of Trust.
 * Then not only would we have to remove the final declaration on the class Trust, we would also need to add a type parameter to it.
 * Here is a sketch of the required code:
 * abstract class Trust<T extends Trust<T>> extends TaxPayer<T> { ... }
 * final class NonProfitTrust extends Trust<NonProfitTrust> { ... }
 * final class ForProfitTrust extends Trust<ForProfitTrust> { ... }
 */
package chapter09.section04;