package mapcreator;

import java.awt.Color;

/**
 * @author Tomek
 */
public class Item {

    public int id;
    public String name;
    public Color color;
    public Item(){
    
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

    public String getLine() {
        return Integer.toString(id) + "|" + name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
