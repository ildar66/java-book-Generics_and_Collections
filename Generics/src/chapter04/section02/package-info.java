/**
 * Static Members.
 * *
 * Static members of a generic class are shared across all instantiations of that class, including instantiations at different types.
 * @see chapter04.section02.StaticMembers#main(java.lang.String[])
 * *
 * Static members of a class cannot refer to the type parameter of a generic class,
 * and when accessing a static member the class name should not be parameterized.
 * @see chapter04.section02.Cell
 * *
 * You may not refer to a type parameter anywhere within a static member: {@link chapter04.section02.Cell2}
 * *
 * If we want a list of all values kept in cells, then we need to use a list of objects, as in the following variant:
 * {@link chapter04.section02.Cell3}
 */
package chapter04.section02;