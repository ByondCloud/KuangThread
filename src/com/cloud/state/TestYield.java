package com.cloud.state;

// 测试礼让线程
// 礼让不一定成功
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "A").start();
        new Thread(myYield, "B").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        // 线程礼让
        Thread.yield();
        System.out.println("线程礼让");
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
