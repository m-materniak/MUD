package com.mud;

import com.mud.Entities.Item;
import com.mud.Entities.Person;
import com.mud.Entities.Player;

/**
 * Created by krzysiek on 2014-11-18.
 */
public class SellCommandHandler extends CommandHandler{
    private Person tradingPartner;
    private Item item;
    private int price;

    public SellCommandHandler(CommandHandler previousCommandHandler, Person tradingPartner, Item item, int price) {
        super(previousCommandHandler);
        this.previousCommandHandler = previousCommandHandler;
        this.tradingPartner = tradingPartner;
        this.item = item;
        this.price = price;
    }

    @Override
    public void Initialize() {
        DescribeSell();
    }

    protected void DescribeSell() {
        clientConnection.Send(GetHelpString());
    }

    @Override
    public void ExecuteCommand(String command) {
        restOfCommand = command;
        String verb = TakeNextWord();
        if (verb.equals("yes")) {
            Buy();
            clientConnection.RestoreCommandHandler();
            tradingPartner.EventBuy(true, clientConnection.player, item, price);
        } else if (verb.equals("no")) {
            clientConnection.Send("You declined " + tradingPartner.Name + "'s offer.");
            tradingPartner.EventBuy(false, clientConnection.player, item, price);
            clientConnection.RestoreCommandHandler();
        } else {
            clientConnection.Send("Answer only \"yes\" or \"no\"");
            DescribeSell();
        }
    }

    protected void Buy() {
        Player player = clientConnection.player;
        if (player.getGold() >= price) {
            clientConnection.Send("You bought " + item + " from " + tradingPartner.Name + ".");
            player.PutItem(tradingPartner.TakeItem(item.Name));
            player.Pay(tradingPartner, price);
        } else {
            clientConnection.Send("You can't afford " + item + ".");
        }
    }

    @Override
    public String GetHelpString() {
        String text = "Do you want to buy: " + item + " from: " + tradingPartner.Name + " for: " + price + " coins? (yes/no)\r\n";
        return text;
    }
}
