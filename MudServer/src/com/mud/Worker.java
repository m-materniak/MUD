package com.mud;

import com.mud.Entities.GameWorld;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by krzysiek on 2014-11-02.
 */
public class Worker extends Thread {
    public BlockingQueue<Command> queue = new ArrayBlockingQueue<Command>(1024);
    public MapGenerator map = new MapGenerator();
    public UserRepository userRepository = new UserRepository();
    public GameWorld gameWorld = new GameWorld();

    public Worker(){
        map.GenerateMap(userRepository);
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Command command = queue.take();
                handleCommand(command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleCommand(Command command) {
        System.out.println("Handling command " + command.text);

        try {
            command.clientConnection.commandHandler.ExecuteCommand(command.text);
        }
        catch(Exception e){
            command.clientConnection.channel.writeAndFlush("Unsupported command");
        }
    }
}
