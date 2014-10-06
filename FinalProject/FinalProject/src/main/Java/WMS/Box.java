package WMS;

import java.util.ArrayList;


public class Box {

    int boxRoom;
    ArrayList<Items> boxContents;


    public Box() {

        boxRoom = 9;
        boxContents = new ArrayList<Items>();

    }

    public int getBoxRoom() {
        return boxRoom;
    }

    public void setBoxRoom(int boxRoom) {
        this.boxRoom = boxRoom;
    }

    public ArrayList<Items> getBoxContents() {
        return boxContents;
    }

    public void setBoxContents(ArrayList<Items> boxContents) {
        this.boxContents = boxContents;
    }

}