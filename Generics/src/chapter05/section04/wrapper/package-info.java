/**
 * Evolving a Library using Wrappers.
 * *
 * We leave the legacy source and class files unchanged,
 * and provide a generic wrapper class that accesses the legacy class via delegation.
 * We present this technique mainly in order to warn you against its use
 * — it is usually better to use minimal changes or stubs.
 * *
 * Wrappers also present deeper and subtler problems.
 * If the code uses object identity, problems may appear because the legacy object and the wrapped object are distinct.
 * Further, complex structures will require multiple layers of wrappers.
 * *
 * Because wrapped and legacy objects are distinct,
 * it may be hard or even impossible to always ensure that the wrapped objects view all changes to the legacy objects.
 * *
 * The design of Java generics, by ensuring that legacy objects and generic objects are the same,
 * avoids all of these problems with wrappers.
 * The design of generics for C# is very different: legacy classes and generic classes are completely distinct,
 * and any attempt to combine legacy collections and generic collections will bump into the difficulties with wrappers discussed here.
 */
package chapter05.section04.wrapper;