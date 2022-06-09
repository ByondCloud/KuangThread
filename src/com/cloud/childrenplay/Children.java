package com.cloud.childrenplay;

public class Children extends Thread{

    static Car car = new Car();
    static Plane plane = new Plane();
    private String choice;
    private String childrenName;

    public Children(String choice, String childrenName) {
        this.choice = choice;
        this.childrenName = childrenName;
    }

    @Override
    public void run() {
        if (choice == "小车") {
            synchronized (car) {
                System.out.println(this.childrenName + "拿小车");
                synchronized (plane) {
                    System.out.println(this.childrenName + "拿飞机");
                }
            }
        } else {
            synchronized (plane) {
                System.out.println(this.childrenName + "拿飞机");
                synchronized (car) {
                    System.out.println(this.childrenName + "拿小车");
                }
            }
        }
    }

}
