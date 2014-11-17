package com.mud;

import com.mud.Entities.Person;
import com.mud.Entities.Player;
import io.netty.channel.Channel;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class ClientConnection {
    public Channel channel;
    public Player player;
    public CommandHandler commandHandler;

    public ClientConnection(Channel channel){
        this.channel = channel;
    }

    public void Send(String text) {
        channel.writeAndFlush(text + "\r\n");
    }

    public void Disconnect() {
        Send("You were disconnected");
        channel.disconnect();
    }
}
