package mapcreator;

import Entities2.Cell;
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
}
