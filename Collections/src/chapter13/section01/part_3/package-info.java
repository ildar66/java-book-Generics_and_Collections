/**
 * {@link java.util.concurrent.CopyOnWriteArraySet}.
 * *
 * In functional terms, CopyOnWriteArraySet is another straightforward implementation of the {@link java.util.Set} contract,
 * but with quite different performance characteristics from {@link java.util.HashSet}.
 * This class is implemented as a thin wrapper around an instance of {@link java.util.concurrent.CopyOnWriteArrayList},
 * which in turn is backed by an array.
 * This array is treated as immutable; a change to the contents of the set results in an entirely new array being created.
 * So "add" has complexity O(n), as does contains, which has to be implemented by a linear search.
 * Clearly you wouldn’t use {@link java.util.concurrent.CopyOnWriteArraySet} in a context where you were expecting many searches or insertions.
 * But the array implementation means that iteration costs O(1) per element — faster than {@link java.util.HashSet} —
 * and it has one advantage which is really compelling in some applications:
 * it provides thread safety (see chapter11.5) without adding to the cost of read operations.
 * This is in contrast to those collections which use locking to achieve thread safety for all operations
 * (for example, the synchronized collections of chapter17.3.1). Such collections are a bottleneck in multi-threaded use
 * because a thread must get exclusive access to the collection object before it can use it in any way.
 * By contrast, read operations on copy-on-write collections are implemented on the backing array, which is never modified after its creation,
 * so they can be used by any thread without danger of interference from a concurrent write operation.
 * *
 * When would you want to use a set with these characteristics?
 * In fairly specialized cases; one that is quite common is in the implementation of the Subject-Observer design pattern (see chapter09.5),
 * which requires events to be notified to a set of observers.
 * This set must not be modified during the process of notification; with locking set implementations,
 * read and write operations share the overhead necessary to ensure this,
 * whereas with CopyOnWriteArraySet the overhead is carried entirely by write operations.
 * This makes sense for Subject-Observer;
 * in typical uses of this pattern, event notifications occur much more frequently than changes to the listener set.
 * *
 * Iterators for CopyOnWriteArraySet can be used only to read the set.
 * When they are created, they are attached to the instance of the backing array being used by the set at that moment.
 * Since no instance of this array should ever be modified, the iterators’ remove method is not implemented.
 * These are snapshot iterators (see chapter11.5); they reflect the state of the set at the time they were created,
 * and can subsequently be traversed without any danger of interference from threads modifying the set from which they were derived.
 * *
 * Since there are no configuration parameters for {@link java.util.concurrent.CopyOnWriteArraySet},
 * the constructors are just the standard ones discussed in {@link chapter12.section03}
 */
package chapter13.section01.part_3;