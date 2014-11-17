package com.mud.Entities;

import java.io.Serializable;

/**
 * Created by krzysiek on 2014-11-14.
 */
public class NonPlayerCharacter extends Person implements Serializable{
    public NonPlayerCharacter(GameWorld gameWorld) {
        super(gameWorld);
        gameWorld.AddPerson(this);
    }

    public NonPlayerCharacter() {
        super();
    }

    @Override
    public void EventShout(Person person, String text) {
        // ignore
    }

    @Override
    public void EventSay(Person person, String text) {
        String simpleText = text.toLowerCase();
        //if (person.location == location)
        {
            if (simpleText.equals("hello") || simpleText.equals("hi")) {
                Say(person.Name, "No siema, Sandra!");
            }
        }
    }

    @Override
    public String Describe() {
        return "Is a NPC";
    }
}
