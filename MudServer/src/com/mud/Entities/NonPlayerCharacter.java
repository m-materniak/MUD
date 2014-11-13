package com.mud.Entities;

/**
 * Created by krzysiek on 2014-11-14.
 */
public class NonPlayerCharacter extends Person {
    @Override
    public void EventShout(Player player, String text) {
        // ignore
    }

    @Override
    public void EventSay(Player player, String text) {
        String simpleText = text.toLowerCase().replaceAll("[\\W\\S]", "");
        if (player.location == location) {
            if (simpleText.equals("Hello") || simpleText.equals("Hi")) {

            }
        }
    }

    @Override
    public String Describe() {
        return "Is a NPC";
    }
}
