package com.mud;

import com.mud.Entities.GameWorld;
import com.mud.Entities.Item;
import com.mud.Entities.Person;
import com.mud.Entities.Player;

import java.util.List;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class UserCommandHandler extends CommandHandler {
    GameWorld gameWorld;
    private String helpString = "AvailableCommands:"
            + "\tnorth - go north\r\n"
            + "\teast - go east\r\n"
            + "\twest - go west\r\n"
            + "\tsouth - go south\r\n"
            + "\tlook - look at current location\r\n"
            + "\ttake ITEM - take one of items in the room\r\n"
            + "\tdrop ITEM - drop one of items in your inventory\r\n"
            + "\tsay PERSON TEXT - say something to a particular person\r\n"
            + "\tshout TEXT - say something to everyone\r\n"
            + "\tattack PERSON - attack selected target\r\n"
            + "\tinventory - show all items currently in your backpack\r\n"
            + "\tequipment - show currently equipped weapon and wear\r\n"
            + "\tequip ITEM - equip weapon or wear\r\n"
            + "\tunequip ITEM - unequip item and put in your backpack\r\n"
            + "\tuse ITEM - use an item from your backpack\r\n"
            + "\tpromote ATTRIBUTE - promote to next level and upgrade your attack, defence or health"
            + "\tstats - show your personal stats\r\n"
            + "\thelp - display this menu\r\n"
            + "\t\r\n";

    public UserCommandHandler(CommandHandler commandHandler, GameWorld gameWorld) {
        super(commandHandler);
        this.gameWorld = gameWorld;
    }

    @Override
    public void Initialize() {
        DescribeRoom();
    }

    @Override
    public void ExecuteCommand(String command) {
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
        } else if (verb.equals("trade")) {
            Trade();
        } else if (verb.equals("info")) {
            clientConnection.Send("This command is not yet implemented");
        } else if (verb.equals("equipment")) {
            DescribeEquipment();
        } else if (verb.equals("inventory")) {
            DescribeInventory();
        } else if (verb.equals("equip")) {
            EquipItem();
        } else if (verb.equals("unequip")) {
            UnequipItem();
        } else if (verb.equals("attack")) {
            Attack();
        } else if (verb.equals("stats")) {
            ShowStats();
        } else if (verb.equals("use")) {
            Use();
        } else if (verb.equals("promote")) {
            Promote();
        } else if (verb.equals("help")) {
            Help();
        }
        else if (previousCommandHandler != null) {
            previousCommandHandler.ExecuteCommand(command);
        }
    }

    private void Trade() {
        String name = TakeNextWord();
        Person tradingPartner = gameWorld.GetPerson(name);
        TradeCommandHandler tradeCommandHandler = new TradeCommandHandler(this, true, tradingPartner);
        clientConnection.SetCommandHandler(tradeCommandHandler);
    }

    @Override
    public String GetHelpString() {
        return helpString;
    }

    private void Drop() {
        String itemName = restOfCommand;
        Item item = clientConnection.player.Drop(itemName);
        if (item != null) {
            clientConnection.Send("You dropped " + item.Name);
        }
        else {
            clientConnection.Send("Item " + itemName + " was not found.");
        }
    }

    private void DescribeInventory() {
        String inventoryDescription = CollectionHelper.DescribeCollection("Inventory", clientConnection.player.equipment);
        clientConnection.Send(inventoryDescription);
    }

    private void DescribeEquipment() {
        clientConnection.Send(clientConnection.player.getEquipmentDescription());
    }

    private void Take() {
        Item item = clientConnection.player.Take(restOfCommand);
        if (item != null) {
            clientConnection.Send("You picked up " + item.Name);
        }
        else {
            clientConnection.Send("Item " + restOfCommand + " was not found.");
        }
    }

    private void Say() {
        String name = TakeNextWord();
        String text = restOfCommand;
        clientConnection.player.Say(name, text);
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

    private void EquipItem() {
        String itemName = restOfCommand;
        if (clientConnection.player.EquipItem(itemName)) {
            clientConnection.Send(itemName + " equipped");
        }
        else {
            clientConnection.Send("You can't equip " + itemName);
        }
    }

    private void UnequipItem() {

        String itemName = restOfCommand;
        if (clientConnection.player.UnequipItem(itemName)) {
            clientConnection.Send(itemName + " unequipped");
        }
        else {
            clientConnection.Send("You can't unequip " + itemName);
        }

    }

    private void Use() {

        String itemName = restOfCommand;
        String result = clientConnection.player.Use(itemName);
        if (!result.isEmpty()) {
            clientConnection.Send("You used " + itemName +", which result in " + result + " gain");
            if (clientConnection.player.canPromote())
                clientConnection.Send("You can promote now!");
        }
        else {
            clientConnection.Send("You can't use " + itemName);
        }

    }

    private void Promote() {

        String itemName = restOfCommand;
        if (clientConnection.player.canPromote()) {
            if (restOfCommand.equals("attack")) {
                int gain = clientConnection.player.Promote(Person.Attribute.ATTACK);
                clientConnection.Send("You promoted to level " + clientConnection.player.getLevel() + " and gain " + gain + " attack");
                if (clientConnection.player.canPromote())
                    clientConnection.Send("You can promote now!");
            }
            else if (restOfCommand.equals("defence")) {
                int gain = clientConnection.player.Promote(Person.Attribute.DEFENCE);
                clientConnection.Send("You promoted to level " + clientConnection.player.getLevel() + " and gain " + gain + " defence");
                if (clientConnection.player.canPromote())
                    clientConnection.Send("You can promote now!");
            }
            else if (restOfCommand.equals("health")) {
                int gain = clientConnection.player.Promote(Person.Attribute.HEALTH);
                clientConnection.Send("You promoted to level " + clientConnection.player.getLevel() + " and gain " + gain + " health");
                if (clientConnection.player.canPromote())
                    clientConnection.Send("You can promote now!");
            }
            else {
                clientConnection.Send("You chose incorrect attribute");
            }
        }
        else {
            clientConnection.Send("You can't promote now");
        }
    }

    private void Attack() {

        String targetName = restOfCommand;

        List<Person> inRoom = clientConnection.player.getLocation().people;
        Person target = null;
        for (Person nextPerson : inRoom ) {
            if (nextPerson.Name.equals(targetName)) {
                target = nextPerson;
                break;
            }
        }

        if (target != null) {

            int attackEffect = clientConnection.player.Attack(target);

            if (attackEffect >= 0) {
                clientConnection.Send("Inflicted damage " + attackEffect + ", opponent " + targetName + " has " + target.getHealth() + " hit points left");

                if (target.getHealth() == 0) {
                    clientConnection.Send("You killed " + targetName + " and earned " + target.getExperienceValue() + " experience points!");
                    if (clientConnection.player.canPromote())
                        clientConnection.Send("You can promote now!");
                }

            }
        }
        else {
            clientConnection.Send("Target isn't present in your location");
        }
    }


    private void ShowStats() {
        if (clientConnection.player.canPromote())
            clientConnection.Send("You can promote now!");
        clientConnection.Send("Your personal stats:" +
                                                  "\r\nGold: " + clientConnection.player.getGold() +
                                                  "\r\nLevel: " + clientConnection.player.getLevel() +
                                                  "\r\nHealth :" + clientConnection.player.getHealth() +"/" + clientConnection.player.getMaxHealth() +
                                                  "\r\nAttack :" + clientConnection.player.getAttack() +
                                                  "\r\nDefence: " + clientConnection.player.getDefence() +
                                                  "\r\nExperience: " + clientConnection.player.getExperience() + "/" + clientConnection.player.levels[clientConnection.player.getLevel()-1]);

    }

    private void DescribeRoom() {
        String roomDescription = clientConnection.player.getLocation().Describe();
        clientConnection.Send(roomDescription);
    }
}
