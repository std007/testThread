package com.testthread.One2One.demo1;

public class Demo {

    /**
     * 生产者/消费者模式：一对一交替打印（Condition）
     *
     * @param args
     */
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();

        ThreadB threadB = new ThreadB(myService);
        threadB.start();
    }
}
