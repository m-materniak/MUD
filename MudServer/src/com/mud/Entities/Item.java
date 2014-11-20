package com.mud.Entities;

import jdk.nashorn.internal.ir.LiteralNode;

import java.io.Serializable;
import java.util.Random;

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
    private int attackModifier;

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    private int defenceModifier;

    private static int getRandom(int min, int max) {

        Random generator = new Random();

        return generator.nextInt(max - min + 1) + min;

    }

    private void generateModifiers() {

        if (this.type == itemType.WEAPON) {
            this.attackModifier = getRandom(3,8);
            this.defenceModifier = getRandom(1,3);
        }
        else if (this.type == itemType.WEAR) {
            this.attackModifier = 0;
            this.defenceModifier = getRandom(3,8);
        }
        else {
            this.defenceModifier = 0;
            this.attackModifier = 0;
        }


    }


    public Item(String name, itemType type, int attackModifier, int defenceModifier) {

        this(name, type);
        this.attackModifier = attackModifier;
        this.defenceModifier = defenceModifier;

    }

    public Item(String name, itemType type) {
        this.type = type;
        this.Name = name;
        generateModifiers();
    }

    public Item(String name) {

        this(name, itemType.typeFromName(name));

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

    @Override
    public String toString() { return Name; }
}
