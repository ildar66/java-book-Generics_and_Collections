/**
 * Specialize to Create Reifiable Types.
 * *
 * Parameterized types are not reifiable, but some operations, such as instance tests, casting, and array creation apply only to reifiable types.
 * In such cases, one workaround is to create a specialized version of the parameterized type.
 * Specialized versions can be created either
 * by delegation (that is, wrappers) or
 * by inheritance (that is, subclassing).
 * *
 * Example {@link chapter08.section03.ListStrings} shows how to specialize lists to strings;
 * specializing to other types is similar.
 * However, specialization at wildcard types can be problematic.
 * ***********
 * Delegation:
 * To specialize by delegation, we define a static method wrap {@link chapter08.section03.ListStrings#wrap(java.util.List)}
 * that takes an argument of type List<String> and returns a result of type ListString.
 * *
 * @see chapter08.section03.Test#testDelegation()
 * *
 * The Java Collections Framework specifies that whenever a list supports fast random access it should implement the marker interface RandomAccess:
 * {@link java.util.ArrayList} implements RandomAccess and extends AbstractList, while {@link java.util.LinkedList} extends Abstract-SequentialList
 * ************
 * Inheritance:
 * To specialize by inheritance, we declare a specialized class {@link chapter08.section03.ArrayListString}
 * that implements the specialized interface and inherits from a suitable implementation of lists.
 * *
 * The code is quite compact. All methods are inherited from the superclass, so we only need to define specialized constructors.
 * If the only constructor required was the default constructor, then the class body could be completely empty!
 * *
 * As before, array creation, instance tests, and casts now pose no problem.
 * @see chapter08.section03.Test#testInheritance()
 * *************
 * However, delegation and inheritance are not interchangeable.
 * Specialization by delegation creates a view of an underlying list, while specialization by inheritance constructs a new list.
 * Further, specialization by delegation has better security properties than specialization by inheritance.
 * @see chapter08.section03.Test#testSecurity()
 * *
 * Another difference is that inheritance can only be applied to a public implementation that can be subclassed (such as ArrayList or LinkedList),
 * whereas delegation can create a view of any list (including lists returned by methods such as Arrays.asList or Collections.immutableList,
 * or by the subList method on lists).
 */
package chapter08.section03;