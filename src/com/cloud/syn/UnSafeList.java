package com.cloud.syn;

import java.util.ArrayList;

public class UnSafeList {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                new Thread( ()->{
                    synchronized (list) {
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
            }

        Thread.sleep(2000);
        System.out.println(list.size());
    }


}
