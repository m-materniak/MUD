package com.mud.Entities;

import com.mud.ClientConnection;
import com.mud.ITradeCommandHandler;
import com.mud.TradeCommandHandler;
import com.sun.deploy.perf.PerfRollup;

import java.util.Iterator;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Player extends Person{
    public ClientConnection connection;

    public static int levels[] = {250, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000};
    private static int maxLevel = 10;
    private int experience;

    public int getExperience() {
        return experience;
    }

    public Player(GameWorld gameWorld) {
        super(gameWorld);
        this.experience = 0;
        gameWorld.AddPerson(this);
    }

    @Override
    public String Describe() {
        return "Player level " + this.getLevel();
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

    @Override
    public void EventAttacked(Person person, int damage) {
        if (connection != null && person != this) {
            connection.Send("You were attacked by " + person.Name + " and suffered " + damage + " hit points damage");
        }
    }

    @Override
    public void EventDied(Person person) {
        super.EventDied(person);
        if (connection != null && person != this) {
            connection.Send("You were killed by " + person.Name + "!");
        }
    }

    @Override
    public ITradeCommandHandler StartTransaction(Player player, ITradeCommandHandler otherSideOfTransaction) {
        TradeCommandHandler tradeCommandHandler = new TradeCommandHandler(connection.commandHandler, false,
                player, otherSideOfTransaction);

        connection.SetCommandHandler(tradeCommandHandler);
        return tradeCommandHandler;
    }

    @Override
    public void EventBuy(boolean isOfferAccepted, Player tradingPartner, Item item, int price) {
        if (connection == null) return;
        String isAcceptedString = isOfferAccepted ? "accepted" : "declined";
        String text = tradingPartner.Name + " " +  isAcceptedString + " your offer to sell " + item.Name
                + " for " + price + "coins.";
        connection.Send(text);
    }

    private void earnExperience(int experience) {

        this.experience += experience;

    }

    @Override
    public int Attack(Person target) {

        int attackEffect = super.Attack(target);
        if (target != null && target.getHealth() == 0) {
            earnExperience(target.getExperienceValue());
        }
        return attackEffect;
    }

}
