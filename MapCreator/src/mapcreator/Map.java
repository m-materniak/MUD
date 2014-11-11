package mapcreator;

import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Map {
    private  ArrayList<Room> rooms;
    public String name;
    int cellSize=16;
    int width=1;//ilosc komórek w poziomie
    int height=1;//ilsoc komórek w pionie

    
    public Map(){
        rooms=new ArrayList<>();
    }
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
    public Room getRoom(int i){
        if (i<rooms.size()){
            return rooms.get(i);
        }else{
            return null;
        }
    }
    public boolean isEmpty(int x,int y){
        return true;
    }
}
