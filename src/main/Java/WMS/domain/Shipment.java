package WMS.domain;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/20/14
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Shipment {
    private ArrayList<Box> boxes;
    private int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Shipment(){

    }

    public Shipment(int orderNumber, ArrayList<Box> boxes ) {
        this.orderNumber = orderNumber;
        this.boxes = boxes;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }


}
