package chapter03.section08;

import java.lang.reflect.Method;

/**
 * Covariant Overriding.
 */
public class CovariantOverriding {

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        // Point q = (Point) p.clone();
        Point q = p.clone();

        // finds all methods with the name "clone" in the class Point:
        for (Method m : Point.class.getMethods())
            if (m.getName().equals("clone"))
                System.out.println(m.toGenericString());
    }
}
/* The clone method of class Object illustrates the advantages of covariant overriding:
    class Object {
        ...
        public Object clone() { ... }
    }*/

//In Java 1.4, any class that overrides clone must give it exactly the same return type, namely Object:
    /*  class Point {
            public int x;
            public int y;
            public Point(int x, int y) { this.x=x; this.y=y; }
            public Object clone() { return new Point(x,y); }
        }*/

//In Java 5, it is possible to give the clone method a return type that is more to the point:
class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point clone() {
        return new Point(x, y);
    }
}