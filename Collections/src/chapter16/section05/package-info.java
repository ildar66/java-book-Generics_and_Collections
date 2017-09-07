/**
 * ConcurrentNavigableMap.
 * *
 * {@link java.util.concurrent.ConcurrentNavigableMap} inherits from {@link java.util.concurrent.ConcurrentMap} and {@link java.util.NavigableMap},
 * and contains just the methods of these two interfaces with a few changes to make the return types more precise.
 * The range-view methods inherited from {@link java.util.SortedMap} and NavigableMap now return views of type ConcurrentNavigableMap.
 * The compatibility concerns that prevented NavigableMap from overriding the methods of SortedMap don’t apply here to overriding the
 * range-view methods of NavigableMap or SortedMap; because neither of these has any implementations that have been retrofitted to the
 * new interface, the danger of breaking implementation subclasses does not arise.
 * For the same reason, it is now possible to override keySet() to return {@link java.util.NavigableSet}.
 */
package chapter16.section05;