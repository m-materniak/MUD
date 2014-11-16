package com.mud.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class Person extends GameElement implements IItemContainer{
    private int health;
    private int attack;
    private int defence;
    public List<Item> equipment = new ArrayList<Item>();
    private GameWorld gameWorld;

    public Person(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public Cell getLocation() {
        return location;
    }

    public void setLocation(Cell location) {
        if (this.location != null) {
            this.location.RemovePerson(this);
        }
        this.location = location;
        this.location.AddPerson(this);
    }

    protected Cell location;

    public void Move(String direction) {
        TryMove(direction, "north", location.cellNorth);
        TryMove(direction, "east", location.cellEast);
        TryMove(direction, "west", location.cellWest);
        TryMove(direction, "south", location.cellSouth);
    }

    private boolean TryMove(String direction, String testedDirection, Cell newCell) {
        if (direction.equals(testedDirection) && newCell != null){
            location.RemovePerson(this);
            newCell.AddPerson(this);
            location = newCell;
            return true;
        }
        return false;
    }

    @Override
    public Item FindItem(String name) {
        for (Item item : equipment){
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
        equipment.remove(item);
        return item;
    }

    @Override
    public void PutItem(Item item) {
        equipment.add(item);
    }

    public abstract void EventShout(Person person, String text);

    public abstract void EventSay(Person person, String text);

    public Item Take(String itemName) {
        Item item = location.TakeItem(itemName);
        if (item != null) {
            equipment.add(item);
        }
        return item;
    }

    public Item Drop(String itemName) {
        Item item = TakeItem(itemName);
        if (item != null) {
            location.PutItem(item);
        }
        return item;
    }

    public void Say(String name, String text) {
        Person person = gameWorld.GetPerson(name);
        if (person != null) {
            person.EventSay(this, text);
        }
    }

}
