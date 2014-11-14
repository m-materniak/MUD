/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author epifaniusz
 */
public class Box extends GameElement implements ItemContainer{
    public List<Item> items = new ArrayList<Item>();
    
    @Override
    public Item FindItem(String name) {
        for (Item item : items){
            if (item.Name.equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Item TakeItem(String name) {
        Item item = FindItem(name);
        if (item == null)
            return null;
        items.remove(item);
        return item;
    }

    @Override
    public void PutItem(Item item) {
        items.add(item);
    }
    
    @Override
    public String Describe() {
        return "This is " + Name + ".\r\n"
                + DescribeContent();
    }

    private String DescribeContent() {
        if (!items.isEmpty()){
            String description = "Content:\r\n";
            for (Item item : items) {
                description += item.Name + "\r\n";
            }
            return description;
        }
        else return "It's empty.";

    }

    private String DescribeExit(String direction, Cell cell) {
        if (cell == null)
            return "";
        return direction + " : " + cell.Name + "\r\n";
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
