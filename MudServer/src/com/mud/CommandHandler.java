package com.mud;

/**
 * Created by krzysiek on 2014-11-08.
 */
public abstract class CommandHandler {
    public ClientConnection clientConnection;
    protected String restOfCommand;

    public abstract void ExecuteCommand(String command);

    protected String TakeNextWord() {
        if (restOfCommand == null)
            return null;
        String[] parts = restOfCommand.split("\\s+", 2);
        String nextWord = parts[0];
        restOfCommand = parts.length > 1 ? parts[1] : null;
        return nextWord;
    }
}
