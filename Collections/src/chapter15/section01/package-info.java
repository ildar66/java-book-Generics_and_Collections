/**
 * Using the Methods of List.
 * *
 * @see chapter15.section01.TaskScheduler
 * *
 * With the implementation chosen, we can understand the constructor of Example {@link chapter15.section01.TaskScheduler} writing to the list
 * is expensive, so it is sensible to use a conversion constructor to set it up with a year’s worth of task queues in one operation (line //1).
 * *
 * Notice that the rollOver method is quite expensive; it writes to the schedule twice, and since the schedule is represented by a
 * CopyOnWriteArrayList (see chapter15.2.3), each write causes the entire backing array to be copied. The argument in favour of this implementation
 * choice is that {@link chapter15.section01.TaskScheduler#rollOver()} is very rarely invoked compared to the number of calls made on getTask(),
 * which iterates over the schedule.
 * *
 * The alternative to {@link java.util.concurrent.CopyOnWriteArrayList} would be a {@link java.util.concurrent.BlockingQueue} implementation, but the
 * improvement that would provide in the rarely-used rollOver() method would come at the cost of slowing down the frequently-used getTask() method,
 * since queue iterators are not intended to be used in performance-critical situations.
 * *
 * ********************** Using Range-View and Iterator *********************
 * Methods Of the four List method groups above, Example {@link chapter15.section01.TaskScheduler} makes use of the methods of one group,
 * positional access, in several places. To see how range-view and iterator methods could also be useful, consider how the TaskScheduler could export
 * its schedule, or a part of it, for a client to modify. You would want the client to be able to view this subschedule and perhaps to insert or
 * remove tasks, but you would definitely want to forbid the insertion or removal of elements of the list itself, since these represent the sequence
 * of days for which tasks are being scheduled. The standard way to achieve this would be by means of an unmodifiable list, as provided by the
 * Collections class (see chapter17.3.2). An alternative in this case would be to return a list iterator, as the snapshot iterators for copy-on-write
 * collections do not support modification of the backing collection. So we could define a method to provide clients with a “planning window”:
 * *
 * listIterator<StoppableTaskQueue> getSubSchedule(int startDay, int endDay) {
 *      return schedule.subList(startDay, endDay).listIterator();
 * }
 * This view will be fine for today, but we have to remember to discard it at midnight,
 * when the structural changes of removing and adding entries will invalidate it.
 */
package chapter15.section01;