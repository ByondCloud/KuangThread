package com.cloud.gaoji;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 回顾
public class ThreadNew {

    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();

        FutureTask<String> futureTask = new FutureTask<String>(new MyThread3());
        new Thread(futureTask).start();
        try {
            String text = futureTask.get();
            System.out.println(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}



// 1. 集成Thread
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("使用Thread创建线程");
    }
}


class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("使用Runnable创建线程");
    }
}

class MyThread3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        String text = "使用Callable创建线程";
        System.out.println(text);
        return text;
    }
}
