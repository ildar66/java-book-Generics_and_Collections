/**
 * Using the Methods of Collection.
 * *
 * To illustrate the use of the collection classes, let’s construct a tiny example.
 * @see chapter12.section01.Task
 * We only require four operations on tasks: equals, compareTo, hashCode and toString.
 * Equality will be used to test whether a collection contains a given task,
 * comparison will be used by ordered collections (such as OrderedSet and OrderedMap)
 * and the hash code will be used by collections based on hash tables (such as HashSet and HashMap),
 * and the string representation of a task will be used whenever we show the contents of a collection.
 * *
 * We define subclasses for two kinds of tasks, writing some code and making a phone call:
 * {@link chapter12.section01.CodingTask} and {@link chapter12.section01.PhoneTask}
 * In accordance with good practice, we have made both kinds of task immutable by declaring the fields to be final,
 * and we have declared both subclasses to be final so that no one can later define mutable subclasses
 * (see item “Minimize mutability”/“Favor immutability”) in Chapter 4 of Effective Java by Joshua Bloch, Addison-Wesley).
 * *
 * We also define an empty task: {@link chapter12.section01.EmptyTask}
 * Since the empty string precedes all others in the natural ordering on strings,
 * the empty task comes before all others in the natural ordering on tasks.
 * This task will be useful when we construct range views of sorted sets (see chapter13.2).
 * *
 * Example tasks and task collections for the task manager: {@link chapter12.section01.StaticTestData}
 * *
 * Now we can use the methods of {@link java.util.Collection} to work with these categories:
 * @see chapter12.section01.CollectionMethodsTest
 * This example provides an explanation of the signatures of methods in this group and the next.
 * We have already discussed (chapter02.6) why they take arguments of type Object or Collection<?>
 * when the methods for adding to the collection restrict their arguments to its parametric type.
 * Taking the example of retainAll,
 * its contract requires the removal of those elements of this collection which do not occur in the argument collection.
 * That gives no justification for restricting what the argument collection may contain;
 * in the preceding example it can contain instances of any kind of Task, not just PhoneTask.
 * And it is too narrow even to restrict the argument to collections of supertypes of the parametric type;
 * we want the least restrictive type possible, which is Collection<?>.
 * Similar reasoning applies to remove, removeAll, contains, and containsAll.
 * *
 * Merging collections using natural ordering: {@link chapter12.section01.MergeCollections}
 */
package chapter12.section01;