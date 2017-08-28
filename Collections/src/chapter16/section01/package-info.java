/**
 * Using the Methods of {@link java.util.Map}.
 * *
 * One problem with basing the to-do manager on priority queues, as we have done in the last two chapters,
 * is that priority queues are unable to preserve the order in which elements are added to them
 * (unless that can be incorporated in the priority ordering, for example as a timestamp or sequence number).
 * To avoid this, we could use as an alternative model a series of FIFO queues, each one assigned to a single priority.
 * A {@link java.util.Map} would be suitable for holding the association between priorities and task queues;
 * {@link java.util.EnumMap} in particular is a highly efficient Map implementation specialized for use with keys which are members of an enum.
 * *
 * This model will rely on a {@link java.util.Queue} implementation that maintains FIFO ordering.
 * To focus on the use of the Map methods, let’s assume a single-threaded client and use a series of ArrayDeques as the implementation:
 * *
 * @see chapter16.section01.UsingTheMethodsOfMap#main(java.lang.String[])
 * *
 * To see the use of some of the other methods of Map,
 * let’s extend the example a little to allow for the possibility that some of these tasks might actually earn us some money by being billable.
 * One way of representing this would be by defining a class Client:
 * class Client {...}
 * Client acme = new Client("Acme Corp.",...);
 * *
 * and creating a mapping from tasks to clients:
 * Map<Task,Client> billingMap = new HashMap<Task,Client>();
 * billingMap.put(interfaceCode, acme);
 * *
 * We need to ensure that the system can still handle nonbillable tasks.
 * We have a choice here: we can either simply not add the name of a nonbillable task into the billing Map, or we can map it to null.
 * In either case, as part of the code for processing a task t, we can write:
 * Task t = ...
 * Client client = billingMap.get(t);
 * if (client != null) { client.bill(t); }
 * *
 * When we have finally finished all the work we were contracted to do by our client Acme Corp.,
 * the map entries that associate tasks with Acme can be removed:
 * Collection<Client> clients = billingMap.values();
 * for (Iterator<Client> iter = clients.iterator() ; iter.hasNext() ; )
 * {
 * if (iter.next().equals(acme)) { iter.remove(); }
 * }
 * A neater alternative takes advantage of the method Collections.singleton (see chapter 17.2),
 * a factory method which returns an immutable Set containing only the specified element:
 * clients.removeAll(Collections.singleton(acme));
 * Both ways cost O(n), with similar constant factors in Sun’s current implementation.
 */
package chapter16.section01;