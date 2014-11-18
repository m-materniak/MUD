package com.mud;

import com.mud.Entities.Item;
import com.mud.Entities.Person;
import com.mud.Entities.Player;

/**
 * Created by krzysiek on 2014-11-16.
 */
public class TradeCommandHandler extends CommandHandler implements ITradeCommandHandler{
    protected Person tradingPartner;
    protected ITradeCommandHandler otherSideOfTransaction;
    private boolean accepted;

    public TradeCommandHandler(CommandHandler previousCommandHandler, boolean accepted, Person tradingPartner) {
        super( previousCommandHandler);
        this.accepted = accepted;
        this.tradingPartner = tradingPartner;
        if (accepted) {
            otherSideOfTransaction = tradingPartner.StartTransaction(clientConnection.player, this);
            TerminateTransactionIfNotAccepted();
        }
    }

    protected void TerminateTransactionIfNotAccepted() {
        if (otherSideOfTransaction == null) {
            EventTerminate();
        }
    }

    public TradeCommandHandler(CommandHandler previousCommandHandler, boolean accepted, Player tradingPartner, ITradeCommandHandler otherSideOfTransaction) {
        this(previousCommandHandler, accepted, tradingPartner);
        this.otherSideOfTransaction = otherSideOfTransaction;
    }

    @Override
    public void Initialize() {
        if (accepted) {
            Help();
        } else {
            AskForAcceptance();
        }
    }

    @Override
    public void ExecuteCommand(String command) {
        restOfCommand = command;
        if (!accepted || command == null) {
            ExecuteAcceptingCommand();
        } else {
            ExecuteTradingCommand(command);
        }
    }

    private void ExecuteAcceptingCommand() {
        String verb = TakeNextWord();
        if (verb.equals("yes")) {
            clientConnection.Send("You accepted trade with " + tradingPartner.Name + ".");
            accepted = true;
        } else if (verb.equals("no")) {
            clientConnection.Send("You declined trade with " + tradingPartner.Name + ".");
            TerminateOnBothSides();
        } else {
            clientConnection.Send("Answer only \"yes\" or \"no\"");
            AskForAcceptance();
        }
    }


    private void AskForAcceptance() {
        clientConnection.Send("Do you want to trade with " + tradingPartner.Name + "? (yes/no)");
    }

    private void ExecuteTradingCommand(String command) {
        String verb = TakeNextWord();
        if (verb.equals("exit")) {
            TerminateOnBothSides();
        } else if (verb.equals("sell")) {
            int price = Integer.parseInt(TakeNextWord());
            Item item = clientConnection.player.FindItem(restOfCommand);
            if (item != null) {
                otherSideOfTransaction.EventSell(item, price);
            }
        } else if (verb.equals("buy")) {
            clientConnection.Send("buy not supported yet");
        } else if (verb.equals("offer")) {
            clientConnection.Send("You can't see the offer yet");
        } else if (verb.equals("help")) {
            Help();
        } else {
            previousCommandHandler.ExecuteCommand(command);
        }

    }
    @Override
    public String GetHelpString() {
        return "You are in trade mode with " + tradingPartner.Name + " now.\r\n"
                + "Available commands:\r\n"
                + "\tsell PRICE ITEM\r\n"
                + "\tbuy PRICE ITEM\r\n"
                + "\toffer - see trading partners offer\r\n"
                + "\texit - terminate trade\r\n"
                + "\thelp - see this menu\r\n";
    }

    @Override
    public void EventTerminate() {
        clientConnection.Send("Your trade with " + tradingPartner.Name + " has ended.");
        clientConnection.RestoreCommandHandler();
    }

    @Override
    public void EventSell(Item item, int price) {
        SellCommandHandler sellCommandHandler = new SellCommandHandler(this, tradingPartner, item, price);
        clientConnection.SetCommandHandler(sellCommandHandler);
    }

    private void TerminateOnBothSides() {
        otherSideOfTransaction.EventTerminate();
        EventTerminate();
    }
}
