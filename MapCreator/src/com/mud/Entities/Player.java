package com.mud.Entities;

import com.mud.ClientConnection;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Player extends Person{
    public ClientConnection connection;

    public Player(GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public String Describe() {
        return "It's a player";
    }

    @Override
    public void EventShout(Person person, String text) {
        if (connection != null && person != this) {
            connection.Send(person.Name + " shouts: " + text);
        }
    }

    @Override
    public void EventSay(Person person, String text) {
        if (connection != null && person != this) {
            connection.Send(person.Name + " says to you: " + text);
        }
    }
}
