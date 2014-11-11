package mapcreator;

import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Map {
    private  ArrayList<Room> rooms;
    public String name;

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }
    public void removeRoom(Room toRemoveRoom){
        rooms.remove(toRemoveRoom);
    }
}