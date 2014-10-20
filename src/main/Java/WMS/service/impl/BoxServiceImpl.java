package WMS.service.impl;

import WMS.domain.Box;
import WMS.domain.Items;
import WMS.domain.Order;
import WMS.service.BoxService;
import WMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/15/14
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    OrderService orderService;

    public ArrayList<Box> sortOrder(Order order) {

        Order orderItems = orderService.displayOrder(order);
        ArrayList<Box> boxList = new ArrayList<Box>();
        int boxSize = 9;
        Stack<Items> itemStack = new Stack<Items>();
        int stackItemSum = 0;
        int totalOrderUnitValue;
        int y = 0;
        int d = 0;


        //Loop to go through items, until all are packed
        for (int x = 0; orderItems.getItems().size() != 0; x++) {
            //Checks to see if x is greater than the amount of items.
            if (x >= orderItems.getItems().size()) {
                x = orderItems.getItems().size() - 1;
                d = orderItems.getItems().size();
            }

            //Adds item to stack if stack is empty
            if (itemStack.size() == 0) {
                itemStack.push(orderItems.getItems().get(x));
                stackItemSum += orderItems.getItems().get(x).getSize();
                orderItems.getItems().remove(x);
            }

            //Checks to see if there are still items in the item array tp be packed.
            if (orderItems.getItems().size() > 0 ) {
                //Checks to see if item(s) in stack plus item at index x is less than 9. Resets to -1 so that at beginning of loop, x = 0.
                if (stackItemSum + orderItems.getItems().get(x).getSize() <= boxSize) {
                    itemStack.push(orderItems.getItems().get(x));
                    stackItemSum += orderItems.getItems().get(x).getSize();
                    orderItems.getItems().remove(x);
                    x = -1;


                }
            }

            //Triggers if we reach the end of the item array, and we have items that are sum greater than 9. Takes all items out fo stack and puts into array to try and re combine.
            if (orderItems.getItems().size() != 0 && x >= 0) {
                if (stackItemSum + orderItems.getItems().get(x).getSize() > boxSize && d == orderItems.getItems().size()) {
                    for (int i = 0; itemStack.size() != 0; i++) {

                        orderItems.getItems().add(itemStack.pop());

                    }
                    stackItemSum = 0;
                    x = -1;
                    y++;
                }
            }

            //Packs remaining items if there is no way to put evenly in a box of 9 units. Pop out all remaining items in the stack.
            if (y == orderItems.getItems().size()) {
                for (int i = 0; itemStack.size() != 0; i++) {

                    orderItems.getItems().add(itemStack.pop());

                }

                for (int i = 0; orderItems.getItems().size() != 0; i = 0) {
                    Box box = new Box();
                    int boxRooms = box.getBoxRoom();


                    for (int z = 0; z < orderItems.getItems().size() ; z++) {
                        if (orderItems.getItems().get(z).getSize() <= boxRooms){

                            box.getBoxContents().add(orderItems.getItems().get(z));
                            boxRooms -= order.getItems().get(z).getSize();
                            orderItems.getItems().remove(z);
                            z = -1;
                        }

                    }
                    boxList.add(box);
                }
            }

            //If stack == 9, packs items into box.
            if (stackItemSum == boxSize) {
                Box box = new Box();
                for (int i = 0; itemStack.size() != 0; i++) {

                    box.getBoxContents().add(itemStack.pop());

                }
                boxList.add(box);
                stackItemSum = 0;

            }

        }
        //If we have items in the stack that are less than 9, and no more items to pack, we pack these items into a box.
        if (itemStack.size() > 0 && orderItems.getItems().size() == 0) {
            Box box = new Box();
            for (int i = 0; itemStack.size() != 0; i++) {

                box.getBoxContents().add(itemStack.pop());

            }
            boxList.add(box);

        }

        return boxList;
    }


    public ArrayList<String> boxItems(ArrayList<Box> view ) {
        ArrayList<String> itemsInfo = new ArrayList<String>();

        for (int i = 0; i < view.size(); i++) {
            String itemInfo = "";
            itemInfo += "Box " + (i + 1) + " :\n";
            for (int x = 0; x < view.get(i).getBoxContents().size(); x++) {
                Items item = view.get(i).getBoxContents().get(x);
                itemInfo += "\t" + "Name: " + item.getName() + "\n";
                itemInfo += "\t" + "SKU: " + item.getSku() + "\n";
                itemInfo += "\t----\n";

            }
            itemsInfo.add(itemInfo);
        }
        return itemsInfo;
    }

    public String countBoxes(ArrayList<Box> boxes) {
        return "You will need " + boxes.size() + " boxes:";
    }
}
