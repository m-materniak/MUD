package mapcreator;

/**
 * @author Tomek
 */
public class Enemy {
    public int id;
    public String name;

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
}
