/**
 * Bridges.
 * *
 * Generics are implemented by erasure: when you write code with generics,
 * it compiles in almost exactly the same way as the code you would have written without generics.
 * In the case of a parameterized interface such as Comparable<T>, this may cause additional methods to be inserted by the compiler;
 * these additional methods are called bridges.
 * *
 * @see chapter03.section07.Bridges
 * *
 * The bridge method is generated automatically by the compiler.
 * Compiled version of the code for both examples is essentially identical.
 * *
 * You can see the bridge if you apply reflection: {@link chapter03.section07.Bridges#main(java.lang.String[])}:
 * public int Integer.compareTo(Integer)
 * public "bridge" int Integer.compareTo(java.lang.Object)
 * *
 * Bridges can play an important role when converting legacy code to use generics.
 */
package chapter03.section07;