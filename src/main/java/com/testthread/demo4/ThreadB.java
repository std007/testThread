package com.testthread.demo4;

/**
 * 通过实现 Runnable 接口来创建线程
 */
public class ThreadB implements Runnable {

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        System.out.println("通过实现 Runnable 接口来创建线程(ThreadB)");
    }

}
