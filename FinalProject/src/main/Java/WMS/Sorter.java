package WMS;

import java.util.ArrayList;

public class Sorter {

    public static void main(String[] args) {
        ArrayList<Box> view = Sorter.sortOrder();
        System.out.println("You will need " + view.size() + " boxes:");
        for (int i = 0; i < view.size(); i++) {
            view.get(i);
            System.out.println("Box " + (i + 1) + " :");
            for (int x = 0; x < view.get(i).boxContents.size(); x++) {
                Items item = view.get(i).boxContents.get(x);
                System.out.println("\t" + item.getName());
                System.out.println("\t" + item.getItemType());
                System.out.println("\t" + item.getSku());
                System.out.println();
            }


        }
    }


    //Method with a few for loops to sort the item out and put in respective boxes based on enough size.
    public static ArrayList<Box> sortOrder() {
        ArrayList<Items> sort = OrderViewer.displayOrder();
        ArrayList<Box> boxList = new ArrayList<Box>();
        Box box = new Box();
        int boxCount = 0;
        boxList.add(box);
        //Housewares and shoes/bags can never equal 9 and should be considered core items. Beauty, clothing and accessories are considered filler items.
        String[] packOrder = new String[]{"housewares", "beauty", "clothing", "accessories" , "shoes", "bags"};

        //for loop to go though item type array
        for (int z = 0; z < packOrder.length; z++) {

            //for loop to go through the items
            for (int x = 0; x < sort.size(); x++) {
                if (sort.get(x).getItemType().equalsIgnoreCase(packOrder[z])) {
                    //for loop to go through available boxes
                    for (int y = 0; !sort.get(x).isStowed(); y++) {

                        if (boxList.get(y).getBoxRoom() >= sort.get(x).getSize()) {

                            boxList.get(y).getBoxContents().add(sort.get(x));
                            sort.get(x).setStowed(true);
                            boxList.get(y).boxRoom -= sort.get(x).getSize();
                        } else if (y == boxList.size() - 1) {
                            boxList.add(new Box());
                            boxCount++;
                            box = boxList.get(boxCount);

                            box.getBoxContents().add(sort.get(x));
                            sort.get(x).setStowed(true);
                            box.boxRoom -= sort.get(x).getSize();
                        }

                    }


                }
            }
        }
        return boxList;
    }
}

