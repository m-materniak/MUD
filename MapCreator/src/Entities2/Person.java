package Entities2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class Person extends GameElement implements ItemContainer{
    private int health;
    private int attack;
    private int defence;
    public List<Item> equipment = new ArrayList<Item>();
    public Cell location;

    public void Move(String direction) {
        TryMove(direction, "north", location.cellNorth);
        TryMove(direction, "east", location.cellEast);
        TryMove(direction, "west", location.cellWest);
        TryMove(direction, "south", location.cellSouth);
    }

    private boolean TryMove(String direction, String testedDirection, Cell newCell) {
        if (direction.equals(testedDirection) && newCell != null){
            location.RemovePerson(this);
            newCell.addPerson(this);
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
    
    public Cell getLocation() {
        return location;
    }

    public void setLocation(Cell location) {
        this.location = location;
    }
    public com.mud.Entities.Person toServerPerson(){
        com.mud.Entities.Person newPerson = new com.mud.Entities.NonPlayerCharacter();
        newPerson.setLocation(this.location.toServerCell());
        newPerson.setAttack(attack);
        newPerson.setDefence(defence);
        newPerson.setHealth(health);
        
        return newPerson;
        
    }
    
}
