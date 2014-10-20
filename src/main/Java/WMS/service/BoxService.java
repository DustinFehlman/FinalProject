package WMS.service;

import WMS.domain.Box;
import WMS.domain.Order;

import java.util.ArrayList;

public interface BoxService {
    ArrayList<Box> sortOrder(Order order);
}