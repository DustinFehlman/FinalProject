package WMS.domain.repository;
import WMS.domain.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/13/14
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderByOrderNumber(int orderNumber);
    Order create(Order order);
}
