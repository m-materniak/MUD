package mapcreator;

import Entities2.Cell;
import com.mud.Entities.GameWorld;
import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Map {
    private  ArrayList<Cell> cells;
    public String name;
    int cellSize=16;
    int width=1;//ilosc komórek w poziomie
    int height=1;//ilsoc komórek w pionie
    int leftUpperCornerX = Integer.MIN_VALUE;
    int leftUpperCornerY = Integer.MIN_VALUE;

    
    public Map(){
        cells=new ArrayList<>();
    }
    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setRooms(ArrayList<Cell> rooms) {
        this.cells = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addRoom(Cell newRoom){
        cells.add(newRoom);
        updateMapSize();
        //printMapSize();
    }
    public void removeRoom(Cell toRemoveRoom){
        cells.remove(toRemoveRoom);
    }
    public Cell getRoom(int i){
        if (i<cells.size()){
            return cells.get(i);
        }else{
            return null;
        }
    }
    public boolean isEmpty(int x,int y){
       for(int i=0;i<cells.size();i++){
           if (cells.get(i).getCordX()==x && cells.get(i).getCordY()==y){
               return false;
           }
       }
       return true;
    }

    public void updateMapSize(){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Cell room : cells) {
            minX = room.getCordX()<minX ? room.getCordX() : minX;
            maxX = maxX<room.getCordX() ? room.getCordX() : maxX;
            minY = room.getCordY()<minY ? room.getCordY() : minY;
            maxY = maxY<room.getCordY() ? room.getCordY() : maxY;
        }
        width = maxY-minY+1;
        height = maxX-minX+1;//
        leftUpperCornerX = minX;
        leftUpperCornerY = minY;
    }
    public void printMapSize(){
        System.out.println("Width:              " + width);
        System.out.println("Height:             " + height);
        System.out.println("leftUpperCornerX:   " + leftUpperCornerX);
        System.out.println("leftUpperCornerY:   " + leftUpperCornerY);
        
    }

}
