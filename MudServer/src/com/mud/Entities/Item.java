package com.mud.Entities;

import jdk.nashorn.internal.ir.LiteralNode;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Item extends GameElement implements Serializable{


    public enum itemType {

        WEAPON, WEAR, MISC, FOOD, ARTIFACT, JEWELRY;

        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }

        public static String[] weaponNames = {
                "Sword", "Axe", "Spear"
        };

        public static String[] wearNames = {
                "Armor", "Coat"
        };

        public static String[] foodNames = {
                "Meat", "Apple", "Potion"
        };

        public static String[] artifactNames = {
                "Book", "Scroll"
        };

        public static String[] jewelryNames = {
                "Ring", "Necklace"
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

            for (String testName : foodNames) {
                if (name.toLowerCase().contains(testName.toLowerCase())) {
                    return FOOD;
                }
            }

            for (String testName : artifactNames) {
                if (name.toLowerCase().contains(testName.toLowerCase())) {
                    return ARTIFACT;
                }
            }

            for (String testName : jewelryNames) {
                if (name.toLowerCase().contains(testName.toLowerCase())) {
                    return JEWELRY;
                }
            }

            return MISC;

        }

    };

    private itemType type;
    private int attackModifier;
    private int defenceModifier;
    private int healthModifier;
    private int experienceModifier;

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getExperienceModifier() {
        return experienceModifier;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    private static int getRandom(int min, int max) {

        Random generator = new Random();

        return generator.nextInt(max - min + 1) + min;

    }

    private void generateModifiers() {

        if (this.type == itemType.WEAPON) {
            this.attackModifier = getRandom(3,8);
            this.defenceModifier = getRandom(1,3);
            this.healthModifier = 0;
            this.experienceModifier = 0;
        }
        else if (this.type == itemType.WEAR) {
            this.attackModifier = 0;
            this.defenceModifier = getRandom(3,8);
            this.healthModifier = 0;
            this.experienceModifier = 0;
        }
        else if (this.type == itemType.FOOD) {
            this.attackModifier = 0;
            this.defenceModifier = 0;
            this.healthModifier = getRandom(5,50);
            this.experienceModifier = 0;
        }
        else if (this.type == itemType.ARTIFACT) {

            int modifierType = getRandom(1,4);

            switch (modifierType) {
                case 1:
                    this.attackModifier = getRandom(2,10);
                    this.defenceModifier = 0;
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    break;
                case 2:
                    this.attackModifier = 0;
                    this.defenceModifier = getRandom(2,10);
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    break;
                case 3:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = getRandom(5,15);
                    this.experienceModifier = 0;
                    break;
                case 4:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = 0;
                    this.experienceModifier = getRandom(50,500);
                    break;
            }
        }
        else if (this.type == itemType.JEWELRY) {

            int modifierType = getRandom(1, 3);

            switch (modifierType) {
                case 1:
                    this.attackModifier = getRandom(3, 12);
                    this.defenceModifier = 0;
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    break;
                case 2:
                    this.attackModifier = 0;
                    this.defenceModifier = getRandom(3, 12);
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    break;
                case 3:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = getRandom(10, 20);
                    this.experienceModifier = 0;
                    break;
            }
        }
        else {
            this.defenceModifier = 0;
            this.attackModifier = 0;
            this.healthModifier = 0;
            this.experienceModifier = 0;
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

    public boolean isArtifact() {

        return (type == itemType.ARTIFACT);

    }

    public boolean isFood() {

        return (type == itemType.FOOD);

    }

    public boolean isJewelry() {

        return (type == itemType.JEWELRY);

    }

    @Override
    public String Describe() {
        String modifierDescription = "";
        if (attackModifier > 0)
            modifierDescription += " Attack +" + attackModifier;
        if (defenceModifier > 0)
            modifierDescription += " Defence +" + defenceModifier;
        if (healthModifier > 0)
            modifierDescription += " Health +" + healthModifier;
        if (experienceModifier > 0)
            modifierDescription += "Experience +" + experienceModifier;
        return type.toString() + modifierDescription;
    }

    @Override
    public String toString() { return Name; }
}
