/**
 * Sets.
 * *
 * A set is a collection of items that cannot contain duplicates; adding an item if it is already present in the set has no effect.
 * The {@link java.util.Set} interface has the same methods as those of {@link java.util.Collection},
 * but it is defined separately in order to allow the contract of add (and addAll, which is defined in terms of add) to be changed in this way.
 * *
 * Returning to the task manager example in the previous chapter, suppose that on Monday you have free time to carry out your telephone tasks.
 * You can make the appropriate collection by adding all your telephone tasks to your Monday tasks.
 * Let mondayTasks and phone Tasks be as declared in Example {@link chapter12.section01.StaticTestData}.
 * Using a set (again choosing a conveniently common implementation of {@link java.util.Set}), you can write:
 * *
 * Set<Task> phoneAndMondayTasks = new TreeSet<Task>(mondayTasks);
 * phoneAndMondayTasks.addAll(phoneTasks);
 * assert phoneAndMondayTasks.toString().equals( "[code logic, phone Mike, phone Paul]");
 * *
 * This works because of the way that duplicate elements are handled.
 * The task mike Phone, which is in both mondayTasks and phoneTasks, appears as intended, only once,
 * in phoneAndMondayTasks — you definitely don’t want to have to do all such tasks twice over!
 */
package chapter13;