package com.mud.Entities;


import java.io.Serializable;
import java.util.Random;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Item extends GameElement implements Serializable{


    public enum itemType {

        WEAPON, WEAR, MISC, FOOD, ARTIFACT, JEWELRY, GOLD;

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

        public static itemType fromInteger(int x) {
            switch (x) {
                case 0:
                    return WEAPON;
                case 1:
                    return WEAR;
                case 2:
                    return MISC;
                case 3:
                    return FOOD;
                case 4:
                    return ARTIFACT;
                case 5:
                    return JEWELRY;
                case 6:
                    return GOLD;
                default:
                    return WEAR;
            }
        }

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
            if (name.toLowerCase().contains("gold")) {
                return GOLD;
            }

            return MISC;

        }

    };

    private itemType type;
    private int attackModifier;
    private int defenceModifier;
    private int healthModifier;
    private int experienceModifier;
    private int value;

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

    public int getValue() {
        return value;
    }

    public itemType getType() {
        return type;
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
            this.value = 50 * (this.attackModifier + this.defenceModifier);
        }
        else if (this.type == itemType.WEAR) {
            this.attackModifier = 0;
            this.defenceModifier = getRandom(3,8);
            this.healthModifier = 0;
            this.experienceModifier = 0;
            this.value = 100 * (this.defenceModifier);
        }
        else if (this.type == itemType.FOOD) {
            this.attackModifier = 0;
            this.defenceModifier = 0;
            this.healthModifier = getRandom(5,50);
            this.experienceModifier = 0;
            this.value = this.healthModifier;
        }
        else if (this.type == itemType.ARTIFACT) {

            int modifierType = getRandom(1,4);

            switch (modifierType) {
                case 1:
                    this.attackModifier = getRandom(2,10);
                    this.defenceModifier = 0;
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    this.value = this.attackModifier * 200;
                    break;
                case 2:
                    this.attackModifier = 0;
                    this.defenceModifier = getRandom(2,10);
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    this.value = this.defenceModifier * 200;
                    break;
                case 3:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = getRandom(5,15);
                    this.experienceModifier = 0;
                    this.value = this.healthModifier * 200;
                    break;
                case 4:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = 0;
                    this.experienceModifier = getRandom(50,500);
                    this.value = this.experienceModifier * 10;
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
                    this.value = this.attackModifier * 50;
                    break;
                case 2:
                    this.attackModifier = 0;
                    this.defenceModifier = getRandom(3, 12);
                    this.healthModifier = 0;
                    this.experienceModifier = 0;
                    this.value = this.defenceModifier * 50;
                    break;
                case 3:
                    this.attackModifier = 0;
                    this.defenceModifier = 0;
                    this.healthModifier = getRandom(10, 20);
                    this.experienceModifier = 0;
                    this.value = this.healthModifier * 40;
                    break;
            }
        }
        else if (this.type == itemType.GOLD) {
            this.value = getRandom(5,200);
        }
        else {
            this.defenceModifier = 0;
            this.attackModifier = 0;
            this.healthModifier = 0;
            this.experienceModifier = 0;
            this.value = getRandom(1,20);
        }


    }


    public Item(String name, itemType type, int attackModifier, int defenceModifier, int healthModifier, int experienceModifier, int value) {

        this(name, type);
        this.attackModifier = attackModifier;
        this.defenceModifier = defenceModifier;
        this.healthModifier = healthModifier;
        this.value = value;

        // Experience modifier allowed only for type ARTIFACT, due to play logic
        // - item must be usable and it's without any sense when eating (using FOOD) gives experience
        if (this.type == itemType.ARTIFACT)
            this.experienceModifier = experienceModifier;

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
        modifierDescription += " Value " + value + " gold";
        return type.toString() + modifierDescription;
    }

    public void setType(itemType type) {
        this.type = type;
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    public void setDefenceModifier(int defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
    }

    public void setExperienceModifier(int experienceModifier) {
        this.experienceModifier = experienceModifier;
    }

    public void setValue(int value) {
        this.value = value;
    }
    

    @Override
    public String toString() { return Name; }
}
