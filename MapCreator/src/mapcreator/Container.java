package mapcreator;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Container {
    public int id;
    public String name;
    private ArrayList<Item> items;
    private Color color;
    public Container(){
        items=new ArrayList<>();
    };
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
    public String getLine(){
        return Integer.toString(id)+"|"+name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
