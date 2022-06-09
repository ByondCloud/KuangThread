package com.cloud.thread;


// 死锁，多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {

    public static void main(String[] args) {
        Person g1 = new Person(0, "第一个女孩");
        Person g2 = new Person(1, "第二个女孩");


        g1.start();
        g2.start();
    }

}


// 2个资源，一个口红一个镜子
class Lipstick {}
class Mirror {}




class  Person extends Thread {

    // 需要的资源只有一份，用static来保证资源的唯一性
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择
    int choice;
    // 使用者
    String girlName;


    Person(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }


    @Override
    public void run() {
        // 化妆
        try {
            MakeUp();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    // 互相持有对方的锁
    private void MakeUp() throws InterruptedException {
        if (choice == 0) {
            // 获得口红的锁
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红");
                Thread.sleep(1000);
                // 一秒后想获得镜子
                synchronized (mirror) {
                    System.out.println(this.girlName + "想要获取镜子");
                }
            }
        } else {
            // 获取镜子的锁
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子");
                Thread.sleep(1000);
                // 一秒后想要获得口红
                synchronized (lipstick) {
                    System.out.println(this.girlName + "想要获取口红");
                }
            }
        }
    }

}
