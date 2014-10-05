package WMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OrderViewer {

    // Counts the amount of product types.  Prints out order contents, and assigns the item a size based on type.
    public static ArrayList<Items> displayOrder() {
        Order order = OrderGrabber.getOrderContents();
        ArrayList<Items> orderItems = order.getItems();
        ArrayList<String> productTypeTally = new ArrayList<String>();
        int y = 1;

        for (int x = 0; x < orderItems.size(); x++) {
            productTypeTally.add(orderItems.get(x).getItemType());
        }
        System.out.println("Order " + order.getOrderNumber() + " contains:");
        Set<String> uniqueSet = new HashSet<String>(productTypeTally);
        int test = 0;
        for (String productType : uniqueSet) {
            System.out.println(productType + ": " + Collections.frequency(productTypeTally, productType));
        }
        System.out.println();
        System.out.println("Order List:");
        for (Items view : orderItems) {

            if (view.getItemType().equalsIgnoreCase("accessories")) {

                view.setSize(1);
                test += 1;
            }
            if (view.getItemType().equalsIgnoreCase("beauty") || view.getItemType().equalsIgnoreCase("clothing")) {

                view.setSize(2);
                test += 2;
            }

            if (view.getItemType().equalsIgnoreCase("shoes") || view.getItemType().equalsIgnoreCase("bags")) {
                view.setSize(3);
                test += 3;
            }

            if (view.getItemType().equalsIgnoreCase("housewares")) {
                view.setSize(5);
                test += 5;
            }
            System.out.println(y + "." + view.getName() + " | " + view.getSku());

            y++;
        }
        //Tester to check mathematically if we are creating the right amount of boxes. Will  not be in final version. Adds up total unit value and divides by 9.
        double testTwo = test / 9;
        int testThree = test % 9;
        System.out.println(test + " / 9 = " + testTwo + " remainder " + testThree);
        if (testThree > 0)
            testTwo += 1;
        System.out.println("Boxes needed: " + testTwo);
        System.out.println();
        return orderItems;


    }
}