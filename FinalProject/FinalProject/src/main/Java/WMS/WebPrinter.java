package WMS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WebPrinter {

    public static ArrayList<ArrayList<String>> printToWeb() {
        Order order = OrderGrabber.getOrderContents();
        ArrayList<String> orderInfo = new ArrayList<String>();
        ArrayList<Box> view = Sorter.sortOrder(order);
        ArrayList<String> productTypeTally = new ArrayList<String>();
        ArrayList<String> itemsInfo = new ArrayList<String>();
        ArrayList<String> boxCount = new ArrayList<String>();
        ArrayList<ArrayList<String>> webPrint = new ArrayList<ArrayList<String>>();
        orderInfo.add("Order Number " + order.getOrderNumber() + " contains:");

        for (int x = 0; x < order.getItems().size(); x++) {
            productTypeTally.add(order.getItems().get(x).getItemType());
        }
        Set<String> uniqueSet = new HashSet<String>(productTypeTally);
        boxCount.add("You will need " + view.size() + " boxes:");
        for (String productType : uniqueSet) {
            orderInfo.add(productType + ": " + Collections.frequency(productTypeTally, productType));
        }

            for (int i = 0; i < view.size(); i++) {
                view.get(i);
                itemsInfo.add("---------------------------- ");
                itemsInfo.add("Box " + (i + 1) + " :");
                for (int x = 0; x < view.get(i).boxContents.size(); x++) {
                    Items item = view.get(i).boxContents.get(x);
                    itemsInfo.add("\t" + "> Name: " + item.getName());
                    itemsInfo.add("\t" + "Type: " + item.getItemType());
                    itemsInfo.add("\t" + "Sku: " + item.getSku());
                    itemsInfo.add("----");
                }
            }



        webPrint.add(boxCount);
        webPrint.add(itemsInfo);
        webPrint.add(orderInfo);
        return webPrint;
    }
}

