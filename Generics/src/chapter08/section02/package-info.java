/**
 * Use Checked Collections to Enforce Security.
 * *
 * It is important to be aware that the guarantees offered by generic types apply only if there are no unchecked warnings.
 * This means that generic types are useless for ensuring security in code written by others,
 * since you have no way of knowing whether that code raised unchecked warnings when it was compiled.
 * *
 * @see chapter08.section02.UseCheckedCollectionsToEnforceSecurity
 * Compiling the devious supplier({@link chapter08.section02.DeviousSupplier}) will issue an unchecked warning,
 * but the broker({@link chapter08.section02.NaiveBroker}) has no way of knowing this.
 * *
 * The correct solution is for the broker to pass a checked list to the supplier: {@link chapter08.section02.WaryBroker}
 * Now a class cast exception will be raised if the supplier attempts to add anything to the list that is not an authenticated order.
 * *
 * Checked collections are not the only technique for enforcing security.
 * If the interface that supplies orders returns a list instead of accepting a list, then
 * the broker can use the empty loop technique of the previous section to ensure that lists contain only authorized orders before passing them on.
 * One can also use specialization, as described in the next section, to create a special type of list that can contain only authorized orders.
 */
package chapter08.section02;