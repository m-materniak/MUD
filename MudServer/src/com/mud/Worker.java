package com.mud;

import com.mud.Entities.GameWorld;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by krzysiek on 2014-11-02.
 */
public class Worker extends Thread {
    public BlockingQueue<Command> queue = new ArrayBlockingQueue<Command>(1024);
    public GameWorld gameWorld;
    public UserRepository userRepository = new UserRepository();

    public Worker(){
        MapGenerator mapGenerator = new MapGenerator();
        gameWorld = mapGenerator.GenerateMap(userRepository);
    }
    public Worker(String path){
        gameWorld = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameWorld = (GameWorld) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("GameWorld class not found");
            c.printStackTrace();
            return;
        }
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
