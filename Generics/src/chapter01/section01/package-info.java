/**
 * Generics.
 * *
 * Cast-iron guarantee: the implicit casts added by the compilation of generics never fail.
 * *
 * Java reifies array component types but does not reify list element types (or other generic types):
 * Executing: new String[size] allocates an array, and stores in that array an indication that its components are of type String.
 * In contrast, executing: new ArrayList<String>() allocates a list, but does not store in the list any indication of the type of its elements.
 * *
 * Generics Versus Templates Generics in Java resemble templates in C++.
 * Semantically, Java generics are defined by erasure, whereas C++ templates are defined by expansion.
 * In C++ templates, each instance of a template at a new type is compiled separately.
 * In Java, no matter how many types of lists you use, there is always one version of the code, so bloat does not occur.
 * *
 * In C++, you also may instantiate a template with a constant value rather than a type,
 * making it possible to use templates as a sort of “macroprocessor on steroids” that can perform arbitrarily complex computations at compile time.
 * Java generics are deliberately restricted to types, to keep them simple and easy to understand.
 */
package chapter01.section01;