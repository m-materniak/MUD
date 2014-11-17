package com.mud.Entities;

/**
 * Created by krzysiek on 2014-11-10.
 */
public interface IItemContainer {
    Item FindItem(String name);
    Item TakeItem(String name);
    void PutItem(Item item);
}
