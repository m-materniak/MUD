package com.mud;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello");
        Worker worker = new Worker();
        //Worker worker = new Worker("E:\\test.ser");
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
