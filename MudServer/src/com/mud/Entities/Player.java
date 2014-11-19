package com.mud.Entities;

import com.mud.ClientConnection;
import com.mud.ITradeCommandHandler;
import com.mud.TradeCommandHandler;

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
}
