package Entities2;

//import com.mud.CollectionHelper;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Cell extends GameElement implements ItemContainer {

    public List<Person> people = new ArrayList<>();
    public List<Item> items = new ArrayList<>();
    private List<Box> boxes = new ArrayList<>();
    public Cell cellNorth, cellEast, cellWest, cellSouth;
    private int type;//może być potrzebne
    private int cordX;
    private int cordY;
    
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Person> getPeople() {
        return people;
    }
    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
    public Cell getCellNorth() {
        return cellNorth;
    }

    public void setCellNorth(Cell cellNorth) {
        this.cellNorth = cellNorth;
    }

    public Cell getCellEast() {
        return cellEast;
    }

    public void setCellEast(Cell cellEast) {
        this.cellEast = cellEast;
    }

    public Cell getCellWest() {
        return cellWest;
    }

    public void setCellWest(Cell cellWest) {
        this.cellWest = cellWest;
    }

    public Cell getCellSouth() {
        return cellSouth;
    }

    public void setCellSouth(Cell cellSouth) {
        this.cellSouth = cellSouth;
    }
    String DescribeCollection(String collectionName, Collection<? extends GameElement> collection) {
        if (collection.isEmpty())
            return "";
        String description = collectionName + ": \r\n";
        for (GameElement element : collection) {
            description += element.Name + "\r\n";
        }
        return description;
    }
    @Override
    public String Describe() {
        return Name + "\r\n"
                + DescribeCollection("Items", items)
                + DescribeExits();
    }

    private String DescribeExits() {
        return "Exits\r\n"
                + DescribeExit("north", cellNorth)
                + DescribeExit("east", cellEast)
                + DescribeExit("west", cellWest)
                + DescribeExit("south", cellSouth);
    }

    private String DescribeExit(String direction, Cell cell) {
        if (cell == null) {
            return "";
        }
        return direction + " : " + cell.Name + "\r\n";
    }

    /**
     * zwraca item leżący luzem w pokoju
     * @param name
     * @return 
     */
    @Override
    public Item FindItem(String name) {
        for (Item item : items) {
            if (item.Name.equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * zwraca item i usuwa go z listy
     * @param name
     * @return 
     */
    @Override
    public Item TakeItem(String name) {
        Item item = FindItem(name);
        if (item == null) {
            return null;
        }
        items.remove(item);
        return item;
    }

    /**
     * tak jak wcześniej addItem
     * @param item 
     */
    @Override
    public void PutItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item toRemoveItem) {
        items.remove(toRemoveItem);
    }

    public void RemovePerson(Person person) {
        people.remove(person);
    }

    public void AddPerson(Person person) {
        people.add(person);
    }

    public void addPerson(Person newEnemy) {
        people.add(newEnemy);
    }

    public void removePerson(Person toRemoveEnemy) {
        people.remove(toRemoveEnemy);
    }

    public void addBox(Box newContainer) {
        boxes.add(newContainer);
    }

    public void removeContainer(Box toRemoveContainer) {
        boxes.remove(toRemoveContainer);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }
}
