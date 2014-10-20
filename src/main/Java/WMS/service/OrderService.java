package WMS.service;

import WMS.domain.Order;

import java.util.ArrayList;

public interface OrderService {

    Order getOrder();
    Order displayOrder(Order order);
    Order create(Order order);
    ArrayList<String> orderItemTypeCount(Order order);
}
