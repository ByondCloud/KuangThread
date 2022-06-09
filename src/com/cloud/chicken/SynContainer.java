package com.cloud.chicken;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynContainer {

//    Chicken[] chickens = new Chicken[10];
    List<Chicken> chickens = new CopyOnWriteArrayList<>();

    int count = 0;

    // 生产
    public synchronized void push(Chicken chicken) {
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        chickens.add(chicken);
        this.notifyAll();
    }

    public synchronized void pop(Chicken chicken) {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        chickens.remove(chicken);
        this.notifyAll();
    }



}
