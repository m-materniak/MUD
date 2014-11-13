package com.mud;

import com.mud.Entities.*;
import jdk.nashorn.internal.runtime.regexp.joni.CodeRangeBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class MapGenerator {
    final int width = 6;
    final int height = 5;

    Random generator = new Random();
    public Cell[][] cells = new Cell[width][height];
    private UserRepository userRepository;

    public void GenerateMap(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                cells[x][y] = GenerateCell();
            }
        }
        ConnectAllCells();
        CreateUsers();
    }

    private void CreateUsers() {
        CreateUser("alice", "qwe", cells[0][0]);
        CreateUser("bob", "qwe", cells[0][0]);
    }

    private void CreateUser(String name, String password, Cell cell) {
        UserAccount account = userRepository.Register(name, password);
        Player player = new Player();
        player.Name = name;
        player.setLocation(cell);
        account.player = player;
    }

    private Cell GenerateCell()
    {
        Cell cell = new Cell();
        cell.Name = GenerateCellName();
        PopulateItems(cell);
        PopulatePeople(cell);
        return cell;
    }

    private void PopulatePeople(Cell cell) {
        cell.people = new ArrayList<Person>();
        final double personProbability = 0.3;
        while (generator.nextDouble() < personProbability) {
            Player person = new Player();
            person.Name = "Zdzisiek";
            cell.people.add(person);
        }
    }

    private void PopulateItems(Cell cell) {
        cell.items = new ArrayList<Item>();
        for (int x = 0; x < generator.nextInt(3) + 2; x++){
            Item item = GenerateItem();
            cell.items.add(item);
        }
    }

    private Item GenerateItem() {
        Item item = new Item();
        item.Name = GenerateItemName();
        return item;
    }

    private String GenerateItemName() {
        String[] adjectives = new String[] {"Old", "New", "Small", "Scary", "Big", "Rusty", "Wooden"};
        String[] nouns = new String[] {"Sword", "Armor", "Glass", "Brick", "Bucket", "Stick", "Table", "Chair",
        "Bottle", "Vase", "Meat"};

        String name = ConstructName(adjectives, nouns);
        return name;
    }

    private String ConstructName(String[]... wordLists) {
        List<String> words = new ArrayList<String>();
        for (String[] wordList : wordLists) {
            words.add(SampleString(wordList));
        }
        String name = String.join(" ", words);
        return name;
    }

    private String SampleString(String[] wordList) {
       return  wordList[generator.nextInt(wordList.length)];
    }

    private String GenerateCellName() {
        String[] adjectives1 = new String[] {"Huge", "Small", "Creepy", "Big", "Shocking"};
        String[] adjectives2 = new String[] {"dark", "red", "crystal", "wooden", "blue"};
        String[] nouns = new String[] {"dungeon", "corridor", "cave", "passage", "room"};

        String name = ConstructName(adjectives1, adjectives2, nouns);

        return name;
    }

    private void ConnectAllCells()
    {
        final double connectionProbability = 0.8;
        for (int x = 0; x < width - 1; x++){
            for (int y = 0; y < height - 1; y++){
                ConnectCellsWithProbability(connectionProbability, cells[x][y], cells[x+1][y], 1);
                ConnectCellsWithProbability(connectionProbability, cells[x][y], cells[x][y+1], 0);
            }
        }
    }

    private void ConnectCellsWithProbability(double connectionProbability, Cell first, Cell second, int direction) {
        if (generator.nextDouble() < connectionProbability){
            ConnectCells(first, second, direction);
        }
    }

    private void ConnectCells(Cell first, Cell second, int direction)
    {
        if (first == null || second == null)
            return;

        switch (direction)
        {
            case 0:
                first.cellNorth = second;
                second.cellSouth = first;
                break;
            case 1:
                first.cellEast = second;
                second.cellWest = first;
                break;
            case 2:
                first.cellWest = second;
                second.cellEast = first;
                break;
            case 3:
                first.cellSouth = second;
                second.cellNorth = first;
                break;
        }
    }
}
