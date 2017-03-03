/**
 * Evolution, Not Revolution.
 * *
 * This chapter shows how to add generics to existing code;
 * it considers a small example, a library for stacks that extends the Collections Framework, together with an associated client.
 * *
 * Three ways to do this: minimal changes to the source, stub files, and wrappers.
 * The first is useful when you have access to the source and the second when you do not; we recommend against the third.
 * *
 * The foundation stone that supports all this is the decision to implement generics by erasure,
 * so that generic code generates essentially the same class files as legacy code — a property referred to as binary compatibility.
 * Usually, adding generics in a natural way causes the legacy and generic versions to be binary compatible.
 * *
 * It is interesting to compare the design of generics in Java and in C#.
 * In Java, generic types do not carry information about type parameters at run time,
 * whereas arrays do contain information about the array element type at run time.
 * In C#, both generic types and arrays contain information about parameter and element types at run time.
 * Each approach has advantages and disadvantages.
 * We will discuss problems with casting and arrays that arise because Java does not reify information about type parameters,
 * and these problems do not arise in C#.
 * On the other hand, evolution in C# is much more difficult. Legacy and generic collection classes are completely distinct,
 * and any attempt to combine legacy collections and generic collections will encounter the difficulties with wrappers discussed earlier.
 * In contrast, as we’ve seen, evolution in Java is straightforward.
 */
package chapter05;