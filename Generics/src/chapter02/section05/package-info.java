/**
 * Arrays.
 * *
 * In Java, array subtyping is covariant, meaning that type S[] is considered to be a subtype of T[] whenever S is a subtype of T.
 * *
 * @see chapter02.section05.ArraysExamples
 * *
 * To summarize, it is better to detect errors at compile time rather than run timetime,
 * but Java arrays are forced to detect certain errors at run time by the decision to make array subtyping covariant.
 * *
 * In some sense, covariant arrays are an artifact of the lack of generics in earlier versions of Java.
 * Once you have generics, covariant arrays are probably the wrong design choice,
 * and the only reason for retaining them is backward compatibility.
 */
package chapter02.section05;