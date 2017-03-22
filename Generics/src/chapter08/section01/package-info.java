/**
 * Take Care when Calling Legacy Code.
 * *
 * Consider a legacy library that contains methods to add items to a given list and to return a new list containing given items:
 * {@link chapter08.section01.LegacyLibrary}
 * *
 * There is no warning when passing the integer list to the method {@link chapter08.section01.LegacyLibrary#addItems(java.util.List)},
 * because the parameterized type List<Integer> is considered a subtype of List: {@link chapter08.section01.NaiveClient#processItems()}
 * At run-time, a class cast exception will be raised.
 * *
 * A less-naïve client may design code that catches the error earlier and is easier to debug:
 * {@link chapter08.section01.WaryClient#processItems()}
 * *
 * The method {@link java.util.Collections#checkedList(java.util.List, java.lang.Class)}
 * in the convenience class Collections takes a list and a class token and returns a checked view of the list;
 * whenever an attempt is made to add an element to the checked view,
 * reflection is used to check that the element belongs to the specified class before adding it to the underlying list
 * *
 * Checked lists provide useful guarantees only when the list elements are of a reifiable type.
 */
package chapter08.section01;