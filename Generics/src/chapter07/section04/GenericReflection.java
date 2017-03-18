package chapter07.section04;

import java.lang.reflect.InvocationTargetException;

/**
 * A type-safe library for generic reflection.
 */
public class GenericReflection {

    public static <T> T newInstance(T obj) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object newobj = obj.getClass().getConstructor().newInstance();
        return (T) newobj; // unchecked cast
    }

    public static <T> Class<? extends T> getComponentType(T[] a) {
        Class<?> k = a.getClass().getComponentType();
        return (Class<? extends T>) k; // unchecked cast
    }

    public static <T> T[] newArray(Class<? extends T> k, int size) {
        if (k.isPrimitive())
            throw new IllegalArgumentException("Argument cannot be primitive: " + k);
        Object a = java.lang.reflect.Array.newInstance(k, size);
        return (T[]) a; // unchecked cast
    }

    public static <T> T[] newArray(T[] a, int size) {
        return newArray(getComponentType(a), size);
    }
}
