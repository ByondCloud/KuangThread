package com.cloud.chicken;

public class Producer extends Thread{

    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            synContainer.push(new Chicken(i));
            System.out.println("生产到第" + i + "只");
        }
    }
}
