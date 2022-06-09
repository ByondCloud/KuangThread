package com.cloud.demo1;

// 创建线程方式一: 继承Thread类, 重写run()方法, 调用start开启线程
public class TestThread1 extends Thread{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("窝在看代码" + i);
        }
    }
    // main主线程
    public static void main(String[] args) {
        // 创建一个线程对象
        TestThread1 testThead1 = new TestThread1();
        // 调用start()方法, 开启线程
        testThead1.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("窝在学习多线程" + i);
        }
    }
}
