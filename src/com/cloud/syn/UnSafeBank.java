package com.cloud.syn;


// 不安全的取钱
// 两个人去银行取钱，账户
public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000000, "存款");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girl = new Drawing(account, 100, "女孩");

        you.start();
        girl.start();

    }
}


class Account {
    // 余额
    int money;
    // 卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    //账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {

        synchronized (account) {
            if (account.money - drawingMoney < 0 ) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不到");
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;

            System.out.println("余额为：" + account.money);
            System.out.println(this.getName() + "手头有：" + nowMoney);
        }
    }
}
