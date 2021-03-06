package com.mud.Entities;

import java.io.Serializable;
import com.mud.ITradeCommandHandler;

/**
 * Created by krzysiek on 2014-11-14.
 */
public class NonPlayerCharacter extends Person implements Serializable{
    public NonPlayerCharacter(GameWorld gameWorld) {
        super(gameWorld);
        this.gold += getRandom(100, 1000);
        gameWorld.AddPerson(this);
    }

    public NonPlayerCharacter() {
        super();
    }
    public NonPlayerCharacter(String name, int health, int attack, int defence, int level, int gold) {
        super(health, attack, defence, level, gold);
        this.Name=name;
    }
    
    @Override
    public void EventShout(Person person, String text) {
        // ignore
    }

    @Override
    public void EventAttacked(Person attacker, int damage) {
        // ignore
    }

    @Override
    public void EventDied(Person person) {
        super.EventDied(person);
    }

    @Override
    public void EventSay(Person person, String text) {
        String simpleText = text.toLowerCase();
        //if (person.location == location)
        {
            if (simpleText.contains("hello") || simpleText.contains("hi")) {
                Say(person.Name, "Hello, stranger!");
            } else if (simpleText.contains("bye")) {
                Say(person.Name, "Farewell!");
            } else {
                Say(person.Name, "Go away!");
            }
        }
    }

    @Override
    public ITradeCommandHandler StartTransaction(Player player, ITradeCommandHandler tradeCommandHandler) {
        return null;
    }

    @Override
    public void EventBuy(boolean b, Player player, Item item, int price) {

    }

    @Override
    public String Describe() {
        return "NPC level " + this.getLevel() + ", health " + this.getHealth() + "/" + this.getMaxHealth();
    }
}
