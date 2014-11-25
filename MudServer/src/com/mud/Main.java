package com.mud;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        //Worker worker;
        Worker worker = new Worker("E:\\map.mm");
//        if (args.length > 0) {
//            worker = new Worker(args[0]);
//            System.out.println("Custom map loaded.");
//        } else {
//            worker = new Worker();
//            System.out.println("Test map loaded.");
//        }
        worker.start();
        MudServer mudServer = new MudServer(8511, worker);
        try {
            mudServer.run();
        } catch (InterruptedException e) {
            System.out.println("Exception when running server " + e.getMessage());
        }
        //SimpleServer simpleServer = new SimpleServer(worker);
        //simpleServer.run();
        System.out.println("Simple server is running");
    }
}
