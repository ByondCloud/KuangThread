package com.cloud.chicken;

public class Consumer extends Thread{

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            synContainer.pop(new Chicken(i));
            System.out.println("吃掉了第" + i + "只鸡");
        }
    }
}
