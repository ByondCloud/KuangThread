package com.cloud.gaoji;

// 测试: 生产者消费者模型 --> 利用缓冲区解决: 管程法

// 生产者， 消费者， 产品， 缓冲区
public class TestPC {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }

}

// 生产者
class Productor extends Thread {
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + synContainer.pop().id + "只鸡");

        }
    }
}

// 产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}


// 缓冲区
class SynContainer {
    // 容器
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产
    public synchronized void push(Chicken chicken) {
        // 如果容器满了，就需要等待消费
        if (count == chickens.length) {
            // 通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;

        this.notifyAll();
    }

    // 消费
    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}
