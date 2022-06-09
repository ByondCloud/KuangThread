package com.cloud.test;

import sun.awt.windows.ThemeReader;

public class TestThreadStop implements Runnable{

    private boolean flag = true;


    public static void main(String[] args) throws InterruptedException {
        TestThreadStop testThreadStop = new TestThreadStop();
        new Thread(testThreadStop).start();
        Thread.sleep(5000);
        testThreadStop.stop(false);
    }

    public void stop(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {

            System.out.println(++i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

    }
}
