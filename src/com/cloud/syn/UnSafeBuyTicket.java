package com.cloud.syn;

// 不安全的买票
// 线程不安全
public class UnSafeBuyTicket {

    public static void main(String[] args) {
        ByTicket station = new ByTicket();
        new Thread(station, "小明").start();
        new Thread(station, "小红").start();
        new Thread(station, "小花").start();
    }

}


class ByTicket implements Runnable {

    private int ticketNums = 10;
    boolean flag = true;
    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                buy();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //synchronized同步方法
    private synchronized void buy() throws InterruptedException {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "买到第" + ticketNums--);

    }

}
