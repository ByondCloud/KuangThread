package com.cloud.state;

// 观察测试线程的状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程执行完成");
        });


        // 观察状态
        Thread.State state = thread.getState();
        System.out.println("线程未启动" + state);


        // 观察启动后
        thread.start();
        state = thread.getState();
        System.out.println("线程开启" + state);

        // 如果等于线程终止
        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println("线程状态" + state);
        }

    }


}
