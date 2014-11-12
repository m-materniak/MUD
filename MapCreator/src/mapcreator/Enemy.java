package mapcreator;

import java.awt.Color;

/**
 * @author Tomek
 */
public class Enemy {
    public int id;
    public String name;
    public Color color;
    public Enemy(){
    
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
