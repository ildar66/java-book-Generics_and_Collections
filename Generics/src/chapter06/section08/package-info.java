/**
 * Array Creation and Varargs.
 * *
 * The convenient vararg notation allows methods to accept a variable number of arguments and packs them into an array.
 * This notation is not as convenient as you might like,
 * because the arrays it creates suffer from the same issues involving reification as other arrays.
 * @see chapter06.section08.ArrayCreationAndVarargs#main(java.lang.String[])
 * *
 * Recommend that you never use varargs when the argument is of a nonreifiable type.
 * *
 * The need for generic array creation warnings and the associated workarounds would not have arisen
 * if the vararg notation had been defined to pack arguments into a list rather than an array,
 * taking T… to be equivalent to List<T> rather than T[].
 * Unfortunately, the vararg notation was designed before this problem was fully understood.
 */
package chapter06.section08;