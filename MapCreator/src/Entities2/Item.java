package Entities2;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Item extends GameElement{
    @Override
    public String Describe() {
        return "An item";
    }

    com.mud.Entities.Item toServerItem() {
        com.mud.Entities.Item newItem = null;
        newItem.Name = this.Name;
        return newItem;
    }
    
}
