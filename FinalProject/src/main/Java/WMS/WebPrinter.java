package WMS;


import java.util.ArrayList;

public class WebPrinter {

    public static ArrayList<ArrayList<String>> printToWeb(){
        ArrayList<Box> view = Sorter.sortOrder();
        ArrayList <String> itemsInfo = new ArrayList<String>();
        ArrayList <String> boxCount = new ArrayList<String>();
        ArrayList<ArrayList<String>> webPrint = new ArrayList<ArrayList<String>>();
        boxCount.add("You will need " + view.size() + " boxes:");
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
        return webPrint;
    }
}
