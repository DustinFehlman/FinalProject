package WMS.service.impl;

import WMS.domain.Box;
import WMS.domain.Items;
import WMS.domain.Order;
import WMS.service.BoxService;
import WMS.service.WebPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/15/14
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WebPrinterImpl implements WebPrinter {
    @Autowired
    BoxService boxService;

    public ArrayList<String> orderItemTypeCount(Order order) {
        ArrayList<String> orderInfo = new ArrayList<String>();
        ArrayList<String> productTypeTally = new ArrayList<String>();
        orderInfo.add("Order Number " + order.getOrderNumber() + " contains:");

        for (int x = 0; x < order.getItems().size(); x++) {
            productTypeTally.add(order.getItems().get(x).getItemType());
        }
        Set<String> uniqueSet = new HashSet<String>(productTypeTally);

        for (String productType : uniqueSet) {
            orderInfo.add(productType + ": " + Collections.frequency(productTypeTally, productType));
        }

        return orderInfo;
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
