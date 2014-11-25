package Entities2;

import com.mud.Entities.Item;

/**
 * Created by krzysiek on 2014-11-10.
 */
public interface ItemContainer {
    Item FindItem(String name);
    Item TakeItem(String name);
    void PutItem(Item item);
    void removeItem(Item item);
    String getLine();
}
