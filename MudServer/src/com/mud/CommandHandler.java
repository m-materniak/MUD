package com.mud;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class CommandHandler {
    public ClientConnection clientConnection;

    public abstract void ExecuteCommand(String command);
}
