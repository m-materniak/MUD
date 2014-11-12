package com.mud;

import com.mud.Entities.Item;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class UserCommandHandler extends CommandHandler {
    CommandHandler nextCommandHandler;
    private String restOfCommand;

    public UserCommandHandler(CommandHandler commandHandler, ClientConnection clientConnection) {
        nextCommandHandler = commandHandler;
        this.clientConnection = clientConnection;
    }

    @Override
    public void ExecuteCommand(String command) {
        if(command == null) {
            DescribeRoom();
            return;
        }

        restOfCommand = command;
        String verb = TakeNextWord();

        if (verb.equals("north")) {
            MovePlayer("north");
        } else if (verb.equals("east")) {
            MovePlayer("east");
        } else if (verb.equals("west")) {
            MovePlayer("west");
        } else if (verb.equals("south")) {
            MovePlayer("south");
        } else if (verb.equals("look")) {
            DescribeRoom();
        } else if (verb.equals("take")) {
            Take();
        } else if (verb.equals("drop")) {
            Drop();
        } else if (verb.equals("say")) {
            clientConnection.Send("This command is not yet implemented");
        } else if (verb.equals("shout")) {
            clientConnection.Send("This command is not yet implemented");
            Shout(command);
        } else if (verb.equals("stats")) {
            clientConnection.Send("This command is not yet implemented");
        } else if (verb.equals("info")) {
            clientConnection.Send("This command is not yet implemented");
        } else if (verb.equals("equipment")) {
            clientConnection.Send("This command is not yet implemented");
        } else if (verb.equals("inventory")) {
            DescribeInventory();
        }
        else if (nextCommandHandler != null) {
            nextCommandHandler.ExecuteCommand(command);
        }
    }

    private void Drop() {
        Item item = clientConnection.player.TakeItem(restOfCommand);
        if (item != null) {
            clientConnection.player.location.PutItem(item);
        }
        else {
            clientConnection.Send("Item " + restOfCommand + " was not found.");
        }
    }

    private void DescribeInventory() {
        String inventoryDescription = CollectionHelper.DescribeCollection("Inventory", clientConnection.player.equipment);
        clientConnection.Send(inventoryDescription);
    }

    private void Take() {
        Item item = clientConnection.player.location.TakeItem(restOfCommand);
        if (item != null) {
            clientConnection.player.equipment.add(item);
        }
        else {
            clientConnection.Send("Item " + restOfCommand + " was not found.");
        }
    }

    private String TakeNextWord() {
        if (restOfCommand == null)
            return null;
        String[] parts = restOfCommand.split("\\s+", 2);
        String nextWord = parts[0];
        restOfCommand = parts.length > 1 ? parts[1] : null;
        return nextWord;
    }

    private void Shout(String command) {

    }

    private void MovePlayer(String direction) {
        clientConnection.player.Move(direction);
        DescribeRoom();
    }

    private void DescribeRoom() {
        String roomDescription = clientConnection.player.location.Describe();
        clientConnection.Send(roomDescription);
    }
}
