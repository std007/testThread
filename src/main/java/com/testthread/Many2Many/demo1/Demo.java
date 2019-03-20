package com.testthread.Many2Many.demo1;


public class Demo {

    /**
     * 生产者/消费者模式：多对多交替打印（Condition）
     *
     * @param args
     */
    public static void main(String[] args) {
        MyService myService = new MyService();
        int count = 3;
        ThreadA[] threadAS = new ThreadA[count];
        ThreadB[] threadBS = new ThreadB[count];
        for (int i = 0; i < count; i++) {
            threadAS[i] = new ThreadA(myService);
            threadBS[i] = new ThreadB(myService);
            threadAS[i].start();
            threadBS[i].start();
        }
    }
}
