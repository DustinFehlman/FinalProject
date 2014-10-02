package WMS;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public int getOrderNumber() {
        return orderNumber;

    }
}
