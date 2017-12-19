/**
 * Wrappers.
 * *
 * The {@link java.util.Collections} class provides wrapper objects that modify the behavior of standard collections classes in one of three ways —
 * by synchronizing them,
 * by making them unmodifiable,
 * or by checking the type of elements being added to them.
 * These wrapper objects implement the same interfaces as the wrapped objects, and they delegate their work to them.
 * Their purpose is to restrict the circumstances under which that work will be carried out.
 * These are examples of the use of protection proxies (see Design Patterns by Gamma, Helm, Johnson, and Vlissides, Addison-Wesley),
 * a variant of the Proxy pattern in which the proxy controls access to the real subject.
 * *
 * Proxies can be created in different ways.
 * Here, they are created by factory methods that wrap the supplied collection object in an inner class of Collections that implements
 * the collection’s interface. Subsequently, method calls to the proxy are (mostly) delegated to the collection object,
 * but the proxy controls the conditions of the call:
 * in the case of the synchronized wrappers,
 * all method calls are delegated but the proxy uses synchronization to ensure that the collection is accessed by only one thread at a time.
 * In the case of unmodifiable and checked collections,
 * method calls that break the contract for the proxy fail, throwing the appropriate exception.
 */
package chapter17.section03;