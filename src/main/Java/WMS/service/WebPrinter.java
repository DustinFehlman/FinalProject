package WMS.service;


import WMS.domain.*;

import java.util.ArrayList;


public interface WebPrinter {
    ArrayList<String> orderItemTypeCount(Order order);
    ArrayList<String> boxItems(ArrayList<Box> view );
    String countBoxes(ArrayList<Box> boxes);
}

