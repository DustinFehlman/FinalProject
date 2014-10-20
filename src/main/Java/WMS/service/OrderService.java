package WMS.service;

import WMS.domain.Order;

public interface OrderService {

    Order getOrder();
    Order displayOrder(Order order);
    Order create(Order order);
}
