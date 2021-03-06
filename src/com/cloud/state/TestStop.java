package com.cloud.state;

// 测试stop
// 1.建议线程正常停止 ----> 利用次数, 不建议死循环
// 2.建议使用标志位 ----> 设置一个标志位
// 3. 不用使用stop(), destroy()等过时方法

public class TestStop implements Runnable {

    private boolean flag = true;

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run" + ++i);
        }
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 20000; i++) {
            System.out.println("main" + i);
            if (i == 19000){
                testStop.stop();
                System.out.println("线程停止");
            }

        }
    }


}
