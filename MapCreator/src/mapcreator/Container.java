package mapcreator;

import java.util.ArrayList;

/**
 * @author Tomek
 */
public class Container {
    public int id;
    public String name;
    private ArrayList<Item> items;

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
}
