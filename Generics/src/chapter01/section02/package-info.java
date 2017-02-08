/**
 * Boxing and Unboxing.
 * *
 * One subtlety of boxing and unboxing is that == is defined differently on primitive and on reference types.
 * On type int, it is defined by equality of values, and on type Integer, it is defined by object identity.
 * *
 * A further subtlety is that boxed values may be cached.
 * Caching is required when boxing an int or short value between–128 and 127,
 * a char value between '\u0000' and '\u007f', a byte, or a boolean;
 * and caching is permitted when boxing other values.
 */
package chapter01.section02;