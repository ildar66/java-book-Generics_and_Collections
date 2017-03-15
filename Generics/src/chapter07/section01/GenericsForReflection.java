package chapter07.section01;

/**
 * Generics for Reflection.
 */
public class GenericsForReflection {

    public static void main(String[] args) {
        // class Class, which represents information about the type of an object at run time:
        Class ki = Integer.class;
        Number n = new Integer(42);
        Class kn = n.getClass();
        assert ki == kn;

        // class Class now takes a type parameter:
        Class<Integer> kiG = Integer.class;
        Number nG = new Integer(42);
        Class<? extends Number> knG = nG.getClass();
        assert kiG == knG;

    }
}
// Further Examples of Generics for Reflection.
// The class Class<T> contains just a few methods that use the type parameter in an interesting way:
/* class Class<T> {
    public T newInstance();
    public T cast(Object o);
    public Class<? super T> getSuperclass();
    public <U> Class<? extends U> asSubclass(Class<U> k);
    public <A extends Annotation> A getAnnotation(Class<A> k);
    public boolean isAnnotationPresent(Class<? extends Annotation> k);
    ...
}*/
