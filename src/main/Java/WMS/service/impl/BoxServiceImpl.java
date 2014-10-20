package WMS.service.impl;

import WMS.domain.Box;
import WMS.domain.Items;
import WMS.domain.Order;
import WMS.service.BoxService;
import WMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        Order sort = orderService.displayOrder(order);
        ArrayList<Box> boxList = new ArrayList<Box>();
        Box box = new Box();
        int boxCount = 0;
        boxList.add(box);
        //Housewares and shoes/bags can never equal 9 and should be considered core items. Beauty, clothing and accessories are considered filler items.
        String[] packOrder = new String[]{"housewares", "beauty", "clothing", "accessories" , "shoes", "bags"};

        //for loop to go though item type array
        for (int z = 0; z < packOrder.length; z++) {

            //for loop to go through the itemsfg
            for (int x = 0; x < sort.getItems().size(); x++) {
                if (sort.getItems().get(x).getItemType().equalsIgnoreCase(packOrder[z])) {
                    //for loop to go through available boxes
                    for (int y = 0; !sort.getItems().get(x).isStowed(); y++) {
                        if (boxList.get(y).getBoxRoom() >= sort.getItems().get(x).getSize()) {
                            boxList.get(y).getBoxContents().add(sort.getItems().get(x));
                            sort.getItems().get(x).setStowed(true);
                            int boxRoom = boxList.get(y).getBoxRoom();
                            boxRoom -= sort.getItems().get(x).getSize();
                            boxList.get(y).setBoxRoom(boxRoom);
                        } else if (y == boxList.size() - 1) {
                            boxList.add(new Box());
                            boxCount++;
                            box = boxList.get(boxCount);

                            box.getBoxContents().add(sort.getItems().get(x));
                            sort.getItems().get(x).setStowed(true);
                            int boxRoom = boxList.get(y).getBoxRoom();
                            boxRoom -= sort.getItems().get(x).getSize();
                            boxList.get(y).setBoxRoom(boxRoom);
                        }

                    }


                }
            }
        }

        return boxList;
    }

    public ArrayList<String> boxItems(ArrayList<Box> view ) {
        ArrayList<String> itemsInfo = new ArrayList<String>();

        for (int i = 0; i < view.size(); i++) {
            String itemInfo = "";
            itemInfo += "----------------------------\n";
            itemInfo += "Box " + (i + 1) + " :\n";
            for (int x = 0; x < view.get(i).getBoxContents().size(); x++) {
                Items item = view.get(i).getBoxContents().get(x);
                itemInfo += "\t" + "> Name: " + item.getName() + "\n";
                itemInfo += "----\n";

            }
            itemsInfo.add(itemInfo);
            System.out.println(itemInfo);
        }
        return itemsInfo;
    }

    public String countBoxes(ArrayList<Box> boxes) {
        return "You will need " + boxes.size() + " boxes:";
    }
}
