package com.cloud.lambda;

// 主函数
public class TestLambda2 {

    public static void main(String[] args) {

        ILove love = a -> System.out.println("I Love You" + a);
        love.love(2);
    }
}

// 接口 就是要做的事
interface ILove {
    void love(int a);
}


