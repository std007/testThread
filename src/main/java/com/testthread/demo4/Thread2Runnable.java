package com.testthread.demo4;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

public class Thread2Runnable {

    public static void main(String[] args) {

        //case1:通过实现Runnable接口，来实现run方法的具体逻辑
        new Thread(new MyThread2(), "线程1").start();
        //case2:匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        }, "线程2").start();

        //其实case1和case2的本质是一样的

        //case3:作为线程任务提交给线程池，通过线程池维护的工作者线程来执行。
        ExecutorService executor = newCachedThreadPool();
        MyThread2 myThread2 = new MyThread2();
        executor.execute(myThread2);
        executor.shutdown();
    }
}

/**
 * 实现Runnable接口的线程类
 */
class MyThread2 implements Runnable {

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
    }
}
