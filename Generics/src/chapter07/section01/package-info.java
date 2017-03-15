/**
 * Generics for Reflection.
 * *
 * @see chapter07.section01.GenericsForReflection
 * *
 * Retention is a subclass of Annotation, so you can extract the retention annotation on a class k as follows:
 * // Retention r = k.getAnnotation(Retention.class);
 * *
 * Another use of class tokens, similar to that for annotations,
 * appears in the getListeners method of the class Component in the package java.awt:
 * // public <T extends EventListener> T[] getListeners(Class<T> listenerType);
 * *
 * As a final example of an interesting use of class tokens, the convenience class Collections:
 * // public static <T> List<T> checkedList(List<T> l, Class<T> k)
 * *
 * Generic type gains two advantages:
 * First, it means that no cast is required on the result of the call, because the generic type system can assign it precisely the correct type.
 * Second, it means that if you accidentally call the method with a class token for a class that is not a subclass of Annotation,
 * then this is detected at compile time rather than at run time.
 */
package chapter07.section01;