package Entities2;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class GameElement {
    private int id;
    public String Name;
    public abstract String Describe();
    
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.Name = name;
    }
        public String getName() {
        return Name;
    }
    public String getLine() {
        return Integer.toString(id) + "|" + Name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
