package com.task.customlogging.service;

public class LogCounter extends Thread {

    public LogCounter() {
        super("my extending thread");
        System.out.println("my thread created" + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread interrupted");
        }
        System.out.println("My thread run is over");
    }
}
