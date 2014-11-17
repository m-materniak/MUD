package com.mud.Entities;

import java.io.Serializable;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class Item extends GameElement implements Serializable{
    @Override
    public String Describe() {
        return "An item";
    }
}
