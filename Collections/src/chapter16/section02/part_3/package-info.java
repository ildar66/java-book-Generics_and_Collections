/**
 * WeakHashMap.
 * *
 * An ordinary Map keeps ordinary (“strong”) references to all the objects it contains.
 * That means that even when a key has become unreachable by any means other than through the map itself, it cannot be garbage collected.
 * Often, that’s exactly what we want; in the example at the beginning of this chapter, where we mapped tasks to clients,
 * we wouldn’t have wanted a mapping to disappear just because we weren’t holding a reference to the task object that we had put into the HashMap.
 * To look up the value associated with a supplied key, the HashMap will look for a key that matches (in the sense of equals) the supplied one —
 * they don’t have to be physically the same object.
 * But suppose that the objects of the key class are unique—that is, object equality is the same as object identity.
 * For example, each object might contain a unique serial number. In this case, once we no longer have a reference —
 * from outside the map—to an object being used as a key, we can never look it up again, because we can never re-create it.
 * So the map might as well get rid of the key-value pair and, in fact, there may be a strong advantage in doing so if the map is large
 * and memory is in short supply. That is the idea that {@link java.util.WeakHashMap} implements.
 * *
 * Internally {@link java.util.WeakHashMap} holds references to its key objects through references of the class java.lang.ref.WeakReference.
 * A WeakReference introduces an extra level of indirection in reaching an object.
 * For example, to make a weak reference to to the string "code gui" you would write:
 * WeakReference<String> wref = new WeakReference<String>("code gui");
 * And at a later time you would recover a strong reference to it using the get method of WeakReference:
 * String recoveredStringRef = wref.get();
 * *
 * If there are no strong references to the string "code gui" (or to any substring of it returned from its subString method),
 * the existence of the weak reference will not by itself prevent the garbage collector from reclaiming the object.
 * So the recovered reference value recoveredStringRef may, or may not, be null.
 * *
 * To see how WeakHashMap can be useful, think of a tracing garbage collector that works by determining which objects are reachable,
 * and reclaiming all others. The starting points for a reachability search include the static variables of currently loaded classes
 * and the local variables currently in scope. Only strong references are followed to determine reachability, so the keys of a WeakHashMap
 * will be available to be reclaimed if they are not reachable by any other route. Note that a key cannot be reclaimed if it is
 * strongly referenced from the corresponding value. (including from the values they correspond to).
 * *
 * Before most operations on a WeakHashMap are executed, the map checks which keys have been reclaimed.(It’s not enough to check if a key is null,
 * because null is a legal value for keys in a WeakHashMap. The WeakReference mechanism allows you to tell the garbage collector to leave information
 * in a ReferenceQueue each time it reclaims a weakly referenced object.)
 * The WeakHashMap then removes every entry of which the garbage collector has reclaimed the key.
 * *
 * What is a WeakHashMap good for?
 * Imagine you have a program that allocates some transient system resource — a buffer, for example —o n request from a client.
 * Besides passing a reference to the resource back to the client, your program might also need to store information about it locally—for example,
 * associating the buffer with the client that requested it. That could be implemented by means of a map from resource to client objects.
 * But now, even after the client has disposed of the resource, the map will still hold a reference that will prevent the resource object from
 * being garbage collected— if, that is, the reference is strong. Memory will gradually be used up by resources which are no longer in use.
 * But if the reference is weak, held by a WeakHashMap, the garbage collector will be able to reclaim the object after the last strong reference
 * has gone away, and the memory leak is prevented.
 * *
 * A more general use is in those applications—for example, caches—where you don’t mind information disappearing if memory is low.
 * Here, WeakHashMap is useful whether or not the keys are unique, because you can always re-create a key if necessary to see if the corresponding
 * value is still in the cache. WeakHashMap isn’t perfect for this purpose; one of its drawbacks is that it weakly references the map’s keys rather
 * than its values, which usually occupy much more memory. So even after the garbage collector has reclaimed a key, the real benefit in terms of
 * available memory will not be experienced until the map has removed the stale entry. A second drawback is that weak references are too weak;
 * the garbage collector is liable to reclaim a weakly reachable object at any time, and the programmer cannot influence this in any way.
 * (A sister class of WeakReference, java.lang.ref.SoftReference, is treated differently:
 * the garbage collector should postpone reclaiming these until it is under severe memory pressure.
 * Heinz Kabutz has written a SoftReference-based map using generics; see http://www.javaspecialists.co.za/archive/Issue098.html.)
 * *
 * {@link java.util.WeakHashMap} performs similarly to HashMap, though more slowly because of the overheads of the extra level of indirection for
 * keys. The cost of clearing out unwanted key-value associations before each operation is proportional to the number of associations
 * that need to be removed.
 * The iterators over collections of keys and values returned by {@link java.util.WeakHashMap} are fail-fast.
 */
package chapter16.section02.part_3;