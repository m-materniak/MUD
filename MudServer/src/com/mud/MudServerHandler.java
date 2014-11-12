package com.mud;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class MudServerHandler extends SimpleChannelInboundHandler<String> {
    private Worker worker;
    private Map<Channel, ClientConnection> connections = new HashMap<Channel, ClientConnection>();
    public MudServerHandler(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx)
    {
        Channel channel = ctx.channel();
        ClientConnection clientConnection = new ClientConnection(channel);
        clientConnection.commandHandler = new SystemCommandHandler(clientConnection, worker.userRepository);
        connections.put(channel, clientConnection);
        worker.queue.add(new Command(null, clientConnection));
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx)
    {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        ClientConnection clientConnection = connections.get(channel);

        worker.queue.add(new Command(msg, clientConnection));
    }
}
