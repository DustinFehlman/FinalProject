package WMS.domain.repository.impl;

import WMS.domain.Order;
import WMS.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/13/14
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> listOfOrders;

    public InMemoryOrderRepository() {
        listOfOrders = new ArrayList<Order>();
    }

    public List<Order> getAllOrders() {
        return listOfOrders;
}

    public Order getOrderByOrderNumber(int orderNumber) {
        Order orderByOrderNumber = null;

        for(Order order : getAllOrders()) {
            if(orderNumber!=0 && order.getOrderNumber()!=0 && order.getOrderNumber() == orderNumber){
                orderByOrderNumber = order;
                break;
            }
        }

        if(orderByOrderNumber == null){
            throw new IllegalArgumentException("No order found with the orderNumber: "+ orderByOrderNumber);
        }

        return orderByOrderNumber;
    }

    public Order create(Order order) {
        listOfOrders.add(order);
        return order;
    }

    public void delete(Order order) {
        listOfOrders.remove(order);
    }
}
