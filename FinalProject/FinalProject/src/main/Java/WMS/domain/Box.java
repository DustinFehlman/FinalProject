package WMS.domain;

import java.util.ArrayList;


public class Box {

    int boxRoom;
    ArrayList<Items> boxContents;

    final int INITIAL_BOX_ROOM = 9;

    public Box() {

        boxRoom = INITIAL_BOX_ROOM;
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