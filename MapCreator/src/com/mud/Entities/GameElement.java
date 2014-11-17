package com.mud.Entities;

import java.io.Serializable;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class GameElement implements Serializable{
    public String Name;
    public abstract String Describe();
}
