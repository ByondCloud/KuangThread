package com.cloud.gaoji;

import java.util.TreeMap;

// 测试生产者消费者问题2: 信号灯法, 标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}



// 生产者 --> 演员
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("节目");
            } else {
                this.tv.play("广告");
            }
        }
    }
}


// 消费者 --> 观众
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

// 产品 --> 节目
class TV {

    // 演员表演, 观众等待 T

    // 观众观看, 演员等待 F

    // 表演的节目
    String voice;
    boolean flag = true;
    // 表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了" + voice);
        // 通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }
    // 观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }



}
