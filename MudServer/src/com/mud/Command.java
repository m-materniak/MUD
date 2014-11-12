package com.mud;

import io.netty.channel.Channel;

/**
 * Created by krzysiek on 2014-11-02.
 */
public class Command {
    public String text;
    public ClientConnection clientConnection;

    public Command(String text, ClientConnection clientConnection)
    {
        this.text = text;
        this.clientConnection = clientConnection;
    }
}
