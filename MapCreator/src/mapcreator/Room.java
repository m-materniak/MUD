package mapcreator;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Room {
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;
    public int id;
    public String name;
    private ArrayList<Item> items;
    private ArrayList<Container> containers;
    private ArrayList<Enemy> enemies;
    private Color color;
    private int type;
    private int cordX;
    private int cordY;
    
    
    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    
    public void addEnemy(Enemy newEnemy) {
        enemies.add(newEnemy);
    }
    public void removeEnemy(Enemy toRemoveEnemy) {
        enemies.remove(toRemoveEnemy);
    }
    public void addContainer(Container newContainer) {
        containers.add(newContainer);
    }
    public void removeContainer(Container toRemoveContainer) {
        containers.remove(toRemoveContainer);
    }
    public void addItem(Item newItem) {
        items.add(newItem);
    }
    public void removeItem(Item toRemoveItem) {
        items.remove(toRemoveItem);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
