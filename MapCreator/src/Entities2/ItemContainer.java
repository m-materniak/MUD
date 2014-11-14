package Entities2;

/**
 * Created by krzysiek on 2014-11-10.
 */
public interface ItemContainer {
    Item FindItem(String name);
    Item TakeItem(String name);
    void PutItem(Item item);
    String getLine();
}
