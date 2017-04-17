/**
 * The Collection Interface.
 * *
 * The interface {@link java.util.Collection} defines the core functionality that we expect of any collection other than a map.
 * It provides methods in four groups.
 * *
 * *************** Adding Elements: *********
 * boolean add(E e) // add the element e
 * boolean addAll(Collection<? extends E> c) // add the contents of c
 * *
 * The boolean result returned by these methods indicates whether the collection was changed by the call.
 * It can be false for collections, such as sets, which will be unchanged if they are asked to add an element that is already present.
 * But the method contracts specify that the elements being added must be present after execution so,
 * if the collection refuses an element for any other reason (for example, some collections don’t permit null elements),
 * these methods must throw an exception.
 * *
 * The signatures of these methods show that, as you might expect, you can add elements or element collections only of the parametric type.
 * *
 * ************** Removing Elements: **********
 * boolean remove(Object o) // remove the element o
 * void clear() // remove all elements
 * boolean removeAll(Collection<?> c) // remove the elements in c
 * boolean retainAll(Collection<?> c) // remove the elements *not* in c
 * *
 * If the element 0 is null, remove removes a null from the collection if one is present.
 * Otherwise, if an element e is present for which 0.equals(e), it removes it.
 * If not, it leaves the collection unchanged.
 * Where a method in this group returns a boolean, the value is true if the collection changed as a result of applying the operation.
 * *
 * In contrast to the methods for adding elements, these methods—and those of the next group—will accept elements or element collections of any type.
 * *
 * *************** Querying the Contents of a Collection: ************
 * boolean contains(Object o) // true if o is present
 * boolean containsAll(Collection<?> c) // true if all elements of c are present in the collection
 * boolean isEmpty() // true if no elements are present
 * int size() // return the element count (or Integer.MAX_VALUE if that is less)
 * *
 * The decision to make size return Integer.MAX_VALUE for extremely large collections was probably taken on the assumption that such collections —
 * with more than two billion elements—will rarely arise.
 * Even so, an alternative design which raises an exception instead of returning an arbitrary value would have the merit of ensuring
 * that the contract for size could clearly state that if it does succeed in returning a value, that value will be correct.
 * *
 * ******** Making a Collection’s Contents Available for Further Processing: *******
 * Iterator<E> iterator() // return an Iterator over the elements
 * Object[] toArray() // copy contents to an Object[]
 * <T> T[] toArray(T[] t) // copy contents to a T[] (for any T)
 * *
 * The last two methods in this group convert collections into arrays.
 * The first method will create a new array of Object,
 * and the second takes an array of T and returns an array of the same type containing the elements of the collection.
 * *
 * These methods are important because, although arrays should now be regarded as a legacy data type (see chapter06.9), many APIs,
 * especially older ones that predate the Java Collections Framework, have methods that accept or return arrays.
 * *
 * As discussed in chapter06.4, the argument of the second method is required in order to provide at run time the reifiable type of the array,
 * though it can have another purpose as well: if there is room, the elements of the collection are placed in it—otherwise,
 * a new array of that type is created.
 * The first case can be useful if you want to allow the toArray method to reuse an array that you supply; this can be more efficient,
 * particularly if the method is being called repeatedly.
 * The second case is more convenient—a common and straightforward idiom is to supply an array of zero length:
 * Collection<String> cs = ...
 * String[] sa = cs.toArray(new String[0]);
 * *
 * A more efficient alternative, if a class uses this idiom more than once, is to declare a single empty array of the required type,
 * that can then be used as many times as required:
 * private static final String[] EMPTY_STRING_ARRAY = new String[0];
 * Collection<String> cs = ...
 * String[] sa = cs.toArray(EMPTY_STRING_ARRAY);
 * *
 * Why is any type allowed for T in the declaration of toArray ?
 * One reason is to give the flexibility to allocate a more specific array type if the collection happens to contain elements of that type:
 * List<Object> l = Array.asList("zero","one");
 * String[] a = l.toArray(new String[0]);
 * Here, a list of objects happens to contain only strings, so it can be converted into a string array,
 * in an operation analogous to the promote method described in chapter06.2.
 * *
 * If the list contains an object that is not a string, the error is caught at run time rather than compile time:
 * List<Object> l = Array.asList("zero","one",2);
 * String[] a = l.toArray(new String[0]); // run-time error
 * Here, the call raises ArrayStoreException, the exception that occurs if you try to assign to an array with an incompatible reified type.
 * *
 * In general, one may want to copy a collection of a given type into an array of a more specific type
 * (for instance, copying a list of objects into an array of strings, as we showed earlier),
 * or of a more general type (for instance, copying a list of strings into an array of objects).
 * One would never want to copy a collection of a given type into an array of a completely unrelated type
 * (for instance, copying a list of integers into an array of strings is always wrong).
 * However, there is no way to specify this constraint in Java, so such errors are caught at run time rather than compile time.
 * *
 * One drawback of this design is that it does not work with arrays of primitive type:
 * List<Integer> l = Array.asList(0,1,2);
 * int[] a = l.toArray(new int[0]); // compile-time error
 * This is illegal because the type parameter T in the method call must, as always, be a reference type.
 * The call would work if we replaced both occurrences of int with Integer, but often this will not do because,
 * for performance or compatibility reasons, we require an array of primitive type.
 * In such cases, there is nothing for it but to copy the array explicitly:
 * List<Integer> l = Array.asList(0,1,2);
 * int[] a = new int[l.size()];
 * for (int i=0; i<l.size(); i++) a[i] = l.get(i);
 * The Collections Framework does not include convenience methods to convert collections to arrays of primitive type.
 * Fortunately, this requires only a few lines of code.
 */
package chapter12;