package com.mud.Entities;

import com.mud.CollectionHelper;

import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Cell extends GameElement implements IItemContainer {
    public List<Person> people;
    public List<Item> items;
    public Cell cellNorth, cellEast, cellWest, cellSouth;

    @Override
    public String Describe() {
        return Name + "\r\n"
                + CollectionHelper.DescribeCollection("Items", items)
                + DescribeExits();
    }

    private String DescribeExits() {
        return "Exits\r\n"
                + DescribeExit("north", cellNorth)
                + DescribeExit("east", cellEast)
                + DescribeExit("west", cellWest)
                + DescribeExit("south", cellSouth);
    }

    private String DescribeExit(String direction, Cell cell) {
        if (cell == null)
            return "";
        return direction + " : " + cell.Name + "\r\n";
    }

    @Override
    public Item FindItem(String name) {
        for (Item item : items){
            if (item.Name.equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Item TakeItem(String name) {
        Item item = FindItem(name);
        if (item == null)
            return null;
        items.remove(item);
        return item;
    }

    @Override
    public void PutItem(Item item) {
        items.add(item);
    }

    public void RemovePerson(Person person) {
        people.remove(person);
    }

    public void AddPerson(Person person) {
        people.add(person);
    }
}
