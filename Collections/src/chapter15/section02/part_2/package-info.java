/**
 * LinkedList.
 * *
 * We discussed {@link java.util.LinkedList} as a {@link java.util.Deque} implementation in chapter14.4.1.
 * You will avoid it as a List implementation if your application makes much use of random access;
 * since the list must iterate internally to reach the required position, positional add() and remove() have linear time complexity, on average.
 * *
 * Where {@link java.util.LinkedList} does have a performance advantage over {@link java.util.ArrayList}
 * is in adding and removing elements anywhere other than at the end of the list;
 * for {@link java.util.LinkedList} this takes constant time, against the linear time required for noncircular array implementations.
 */
package chapter15.section02.part_2;