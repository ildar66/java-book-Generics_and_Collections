/**
 * Array Creation.
 * *
 * Arrays reify their component types,
 * meaning that they carry run-time information about the type of their components.
 * @see chapter06.section04.ArrayCreation#main(java.lang.String[])
 * *
 * Because arrays must reify their component types,
 * it is an error to create a new array unless its component type is reifiable.
 * @see chapter06.section04.Annoying
 * *
 * Inability to create generic arrays is one of the most serious restrictions in Java.
 * Because it is so annoying, it is worth reiterating the reason it occurs:
 * generic arrays are problematic because generics are implemented via erasure,
 * but erasure is beneficial because it eases evolution.
 * *
 * By far, the best solution to the problems offered by arrays is to “just say no”:
 * use collections in preference to arrays.
 */
package chapter06.section04;