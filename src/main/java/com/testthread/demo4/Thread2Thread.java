package com.testthread.demo4;


public class Thread2Thread {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread1(), "线程2").start();
    }
}

/**
 * 通过继承Thread类
 */
class MyThread1 extends Thread {
    /**
     * 重写run方法
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }
}
