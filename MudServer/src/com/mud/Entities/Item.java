package com.mud.Entities;

import jdk.nashorn.internal.ir.LiteralNode;

import java.io.Serializable;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Item extends GameElement implements Serializable{


    public enum itemType {

        WEAPON, WEAR, MISC;

        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }

        public static String[] weaponNames = {
                "Sword", "Axe", "Spear"
        };

        public static String[] wearNames = {
                "Armor", "Coat"
        };

        public static itemType typeFromName(String name) {

            for (String testName : weaponNames) {
                if (name.toLowerCase().contains(testName.toLowerCase())) {
                    return WEAPON;
                }
            }

            for (String testName : wearNames) {
                if (name.toLowerCase().contains(testName.toLowerCase())) {
                    return WEAR;
                }
            }

            return MISC;

        }

    };

    private itemType type;

    public Item(String name, itemType type) {
        this.type = type;
        this.Name = name;
    }

    public Item(String name) {
        this.Name = name;
        this.type = itemType.typeFromName(name);

    }

    public boolean isWeapon() {

        return (type == itemType.WEAPON);

    }

    public boolean isWear() {

        return (type == itemType.WEAR);

    }

    @Override
    public String Describe() {
        return type.toString();
    }
}
