package chapter08.section02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Use Checked Collections to Enforce Security.
 */
public class UseCheckedCollectionsToEnforceSecurity {
        public static void main(String [] args){
            OrderProcessor processor = (orders) -> { /*some process*/ };
            OrderSupplier deviousSupplier = new DeviousSupplier();

            NaiveBroker naiveBroker = new NaiveBroker();
            naiveBroker.connect(deviousSupplier, processor); // trick broker

            WaryBroker waryBroker = new WaryBroker();
            waryBroker.connect(deviousSupplier, processor); // ClassCastException
        }
}
class Order { /*...*/ }
class AuthenticatedOrder extends Order { /*...*/ }

interface OrderSupplier {
    public void addOrders(List<AuthenticatedOrder> orders);
}
interface OrderProcessor {
    public void processOrders(List<? extends Order> orders);
}

class NaiveBroker {
    public void connect(OrderSupplier supplier, OrderProcessor processor)
    {
        List<AuthenticatedOrder> orders = new ArrayList<AuthenticatedOrder>();
        supplier.addOrders(orders);
        processor.processOrders(orders);
    }
}

class DeviousSupplier implements OrderSupplier {
    public void addOrders(List<AuthenticatedOrder> orders) {
        List raw = orders;
        Order order = new Order(); // not authenticated
        raw.add(order); // unchecked call
    }
}

class WaryBroker {
    public void connect(OrderSupplier supplier, OrderProcessor processor)
    {
        List<AuthenticatedOrder> orders = new ArrayList<AuthenticatedOrder>();
        supplier.addOrders(Collections.checkedList(orders, AuthenticatedOrder.class));
        processor.processOrders(orders);
    }
}
