/**
 * {@link java.util.concurrent.ConcurrentLinkedQueue}.
 * *
 * The other nonblocking {@link java.util.Queue} implementation is ConcurrentLinkedQueue, an unbounded, thread-safe, FIFO-ordered queue.
 * It uses a linked structure, similar to those we saw in chapter13.2.3 as the basis for skip lists,
 * and in chapter13.1.1 for hash table overflow chaining. We noticed there that one of the main attractions of linked structures
 * is that the insertion and removal operations implemented by pointer rearrangements perform in constant time.
 * This makes them especially useful as queue implementations, where these operations are always required on cells at the ends of the structure
 * — that is, cells that do not need to be located using the slow sequential search of linked structures.
 * *
 * {@link java.util.concurrent.ConcurrentLinkedQueue} uses a CAS-based wait-free algorithm — that is,
 * one that guarantees that any thread can always complete its current operation, regardless of the state of other threads accessing the queue.
 * It executes queue insertion and removal operations in constant time, but requires linear time to execute size.
 * This is because the algorithm, which relies on co-operation between threads for insertion and removal,
 * does not keep track of the queue size and has to iterate over the queue to calculate it when it is required.
 * *
 * {@link java.util.concurrent.ConcurrentLinkedQueue} has the two standard constructors discussed in {@link chapter12.section03}
 * Its iterators are weakly consistent.
 */
package chapter14.section02.part_2;