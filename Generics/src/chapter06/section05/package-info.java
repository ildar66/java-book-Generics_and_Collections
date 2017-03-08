/**
 * The Principle of Truth in Advertising.
 * *
 * We will study variations of the static toArray method from the previous section;
 * the same ideas apply to the toArray method in the {@link java.util.Collection#toArray()} interface of the Collections Framework.
 * @see chapter06.section05.Wrong
 * *
 * In order to avoid this problem, you must stick to the following principle:
 * The Principle of Truth in Advertising:
 * the reified type of an array must be a subtype of the erasure of its static type.
 * *
 * The preceding principle illustrates the converse:
 * if there are unchecked warnings, then casts inserted by erasure may fail.
 * Further, the cast that fails may be in a different part of the source code than was responsible for the unchecked warning!
 * This is why code that generates unchecked warnings must be written with extreme care.
 * *
 * One way to get a new array of a generic type is to already have an array of that type.
 * Then the reified type information for the new array can be copied from the old.
 * @see chapter06.section05.Right
 */
package chapter06.section05;