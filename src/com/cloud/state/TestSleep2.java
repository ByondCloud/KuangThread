package com.cloud.state;


// 模拟倒计时
public class TestSleep2 {

    public static void tenDown() {
        int num = 10;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        tenDown();

        // 打印当前系统时间
//        Date date = new Date();
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
//                date = new Date(System.currentTimeMillis());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }


}
