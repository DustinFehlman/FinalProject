package WMS.service;

import WMS.domain.Box;
import WMS.domain.Order;

import java.util.ArrayList;

public class BoxService {
    public static ArrayList<Box> sortOrder(Order order) {
        Order sort = OrderService.displayOrder(order);
        ArrayList<Box> boxList = new ArrayList<Box>();
        Box box = new Box();
        int boxCount = 0;
        boxList.add(box);
        //Housewares and shoes/bags can never equal 9 and should be considered core items. Beauty, clothing and accessories are considered filler items.
        String[] packOrder = new String[]{"housewares", "beauty", "clothing", "accessories" , "shoes", "bags"};

        //for loop to go though item type array
        for (int z = 0; z < packOrder.length; z++) {

            //for loop to go through the items
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
}