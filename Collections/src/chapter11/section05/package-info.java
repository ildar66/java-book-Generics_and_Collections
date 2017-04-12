/**
 * Collections and Thread Safety.
 * *
 * Although concurrency may be essential to achieving good performance, it comes at a price.
 * Different threads simultaneously accessing the same memory location can produce unexpected results,
 * unless you take care to constrain their access.
 * *
 * For {@link chapter11.section05.ArrayStack} to work correctly, the variable index should always point at the top element of the stack,
 * no matter how many elements are added to or removed from the stack. This is an invariant of the class.
 * Now think about what can happen if two threads simultaneously attempt to push an element on to the stack.
 * As part of the push method, each will execute the lines //1 and //2,
 * which are correct in a single-threaded environment but in a multi-threaded environment may break the invariant.
 * *
 * For example, if thread A executes line //1, thread B executes line //1 and then line //2, and finally thread A executes line //2,
 * only the value added by thread B will now be on the stack, and it will have overwritten the value added by thread A.
 * The stack pointer, though, will have been incremented by two, so the value in the top position of the stack is whatever happened to be there before.
 * This is called a race condition, and it will leave the program in an inconsistent state,
 * likely to fail because other parts of it will depend on the invariant being true.
 * *
 * The increasing importance of concurrent programming during the lifetime of Java has led to a corresponding emphasis
 * in the collections library on flexible and efficient concurrency policies.
 * As a user of the Java collections, you need a basic understanding of the concurrency policies of the different collections
 * in order to know how to choose between them and how to use them appropriately.
 */
package chapter11.section05;