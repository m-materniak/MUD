package com.mud.Entities;

import com.mud.ClientConnection;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Player extends Person{
    public ClientConnection connection;

    @Override
    public String Describe() {
        return "It's a player";
    }

    @Override
    public void EventShout(Player player, String text) {
        if (connection != null && player != this) {
            connection.Send(player.Name + " shouts: " + text);
        }
    }

    @Override
    public void EventSay(Player player, String text) {
        if (connection != null && player != this) {
            connection.Send(player.Name + " says to you: " + text);
        }
    }
}
