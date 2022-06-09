package com.cloud.proxyStatic;

public class StaticProxy {

    public static void main(String[] args) {

        new Thread( ()-> System.out.println("我爱你") ).start();

        new WeddingCompany(new You()).HappyMarry();

    }
}

interface Marry{
    void HappyMarry();
}

// 真实角色
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("结婚");
    }
}

// 代理角色， 帮助你结婚
class WeddingCompany implements Marry {

    private Marry you;

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    @Override
    public void HappyMarry() {
        before();
        this.you.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后");
    }

    private void before() {
        System.out.println("结婚之前");
    }
}
