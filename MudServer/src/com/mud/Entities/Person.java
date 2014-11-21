package com.mud.Entities;

import java.io.Serializable;
import com.mud.ITradeCommandHandler;
import com.mud.TradeCommandHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class Person extends GameElement implements IItemContainer, Serializable{

    private static int initialHealth = 100;

    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int defence;
    protected int level;
    protected Item weapon;
    protected Item wear;
    protected Item jewelry;

    public int getLevel() {
        return level;
    }


    public List<Item> equipment = new ArrayList<Item>();

    private GameWorld gameWorld;
    protected Cell location;

    protected static int getRandom(int min, int max) {

        Random generator = new Random();

        return generator.nextInt(max - min + 1) + min;

    }

    public Person(GameWorld gameWorld) {

        this();
        this.gameWorld = gameWorld;

    }

    public Person(int health, int attack, int defence, int level) {
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defence = defence;
        this.level = level;
    }

    public Person(GameWorld gameWorld, int health, int attack, int defence, int level) {
        this(health, attack, defence, level);
        this.gameWorld = gameWorld;
    }

    public Person() {

        this.health = 100;
        this.maxHealth = initialHealth;
        this.attack = getRandom(6,14);
        this.defence = getRandom(6,14);
        this.level = 1;

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


    public boolean EquipItem(String itemName) {

        Item item = TakeItem(itemName);
        if (item == null) {
            return false;
        }

        if (item.isWeapon()) {

            if (this.weapon != null) {
                equipment.add(this.weapon);
            }
            this.weapon = item;
            return true;

        }

        if (item.isWear()) {

            if (this.wear != null) {
                equipment.add(this.wear);
            }
            this.wear = item;
            return true;

        }

        if (item.isJewelry()) {

            if (this.jewelry != null) {
                equipment.add(this.wear);
            }
            this.jewelry = item;
            this.attack += this.jewelry.getAttackModifier();
            this.defence += this.jewelry.getDefenceModifier();

            this.health += this.jewelry.getHealthModifier();
            this.maxHealth += this.jewelry.getHealthModifier();

            return true;

        }

        return false;

    }

    public boolean UnequipItem(String itemName) {

        if (this.weapon != null && this.weapon.Name.equals(itemName)) {
            equipment.add(this.weapon);
            this.weapon = null;
            return true;
        }

        if (this.wear != null && this.wear.Name.equals(itemName)) {
            equipment.add(this.wear);
            this.wear = null;
            return true;
        }
        if (this.jewelry != null && this.jewelry.Name.equals(itemName)) {
            equipment.add(this.jewelry);

            this.attack -= this.jewelry.getAttackModifier();
            this.defence -= this.jewelry.getDefenceModifier();

            if (this.health - this.jewelry.getHealthModifier() <= 0)
                return false;

            this.health -= this.jewelry.getHealthModifier();
            this.maxHealth -= this.jewelry.getHealthModifier();

            this.jewelry = null;

            return true;
        }

        return false;

    }

    public String getEquipmentDescription() {

        String description = "";

        if (this.weapon != null) {
            if (!description.isEmpty())
                description += "\r\n";
            description += this.weapon.Name + " - " + this.weapon.Describe();
        }
        if (this.wear != null) {
            if (!description.isEmpty())
                description += "\r\n";
            description += this.wear.Name + " - " + this.wear.Describe();
        }
        if (this.jewelry != null) {
            if (!description.isEmpty())
                description += "\r\n";
            description += this.jewelry.Name + " - " + this.jewelry.Describe();
        }
        return description;

    }

    public abstract void EventShout(Person person, String text);

    public abstract void EventSay(Person person, String text);

    public abstract void EventAttacked(Person person, int damage);

    public void EventDied(Person person) {

        for (Item nextItem : equipment) {
            Drop(nextItem.Name);
        }

    }

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

    public void Hurt(Person attacker, int damage) {

        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            EventDied(attacker);
        }

    }

    public String Use(String itemName) {
        Item item = TakeItem(itemName);

        if (item == null) {
            return "";
        }

        if (item.isFood()) {

            this.health += item.getHealthModifier();
            if (this.health > this.maxHealth) {
                int healthGained = item.getHealthModifier() - (this.health - this.maxHealth);
                this.health = this.maxHealth;
                return healthGained + " health";
            }
            return item.getHealthModifier() + " health";

        }

        equipment.add(item);
        return "";
    }

    public int getExperienceValue() {
        return this.attack + this.defence + this.health + level*100;
    }

    public int Attack(Person target) {

        if (target != null) {

            int damage = attack + getRandom(-5 + level, level);

            if (this.weapon != null) {
                damage += weapon.getAttackModifier() + getRandom(-5, 5);
            } else {
                damage -= 2;
            }
            if (this.wear != null) {
                damage += wear.getAttackModifier() + getRandom(-2, 2);
            }

            damage -= (target.wear == null ? 0 : target.wear.getDefenceModifier()) + defence + getRandom(-10 + level, level);
            damage = (damage > 0) ? damage : 0;
            target.EventAttacked(this, damage);
            target.Hurt(this, damage);
            return damage;

        }

        return -1;

    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public abstract ITradeCommandHandler StartTransaction(Player player, ITradeCommandHandler tradeCommandHandler);

    public abstract void EventBuy(boolean b, Player player, Item item, int price);
}
