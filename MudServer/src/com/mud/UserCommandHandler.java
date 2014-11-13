package com.mud;

import com.mud.Entities.GameWorld;
import com.mud.Entities.Item;
import com.mud.Entities.Person;

import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class UserCommandHandler extends CommandHandler {
    GameWorld gameWorld;
    CommandHandler nextCommandHandler;

    public UserCommandHandler(CommandHandler commandHandler, ClientConnection clientConnection, GameWorld gameWorld) {
        nextCommandHandler = commandHandler;
        this.gameWorld = gameWorld;
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
            Say();
        } else if (verb.equals("shout")) {
            Shout();
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
            clientConnection.player.getLocation().PutItem(item);
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
        Item item = clientConnection.player.getLocation().TakeItem(restOfCommand);
        if (item != null) {
            clientConnection.player.equipment.add(item);
        }
        else {
            clientConnection.Send("Item " + restOfCommand + " was not found.");
        }
    }

    private void Say() {
        String name = TakeNextWord();
        Person person = gameWorld.GetPerson(name);
        if (person != null) {
            person.EventSay(clientConnection.player, restOfCommand);
        }
    }

    private void Shout() {
        List<Person> people = gameWorld.GetPeople();
        for (Person person : people) {
            person.EventShout(clientConnection.player, restOfCommand);
        }
    }

    private void MovePlayer(String direction) {
        clientConnection.player.Move(direction);
        DescribeRoom();
    }

    private void DescribeRoom() {
        String roomDescription = clientConnection.player.getLocation().Describe();
        clientConnection.Send(roomDescription);
    }
}
