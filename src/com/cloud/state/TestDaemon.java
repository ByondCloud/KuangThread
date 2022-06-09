package com.cloud.state;

// 测试守护线程
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        // 默认是false, 为用户线程
        thread.setDaemon(true);

        thread.start();
        new Thread(you).start();
    }

}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("永生");
        }
    }
}


class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着");
        }
        System.out.println("goodbye");
    }
}