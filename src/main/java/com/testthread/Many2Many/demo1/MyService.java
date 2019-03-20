package com.testthread.Many2Many.demo1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        lock.lock();
        try {
            while (hasValue) {
                System.out.println("有可能连续 ######");
                condition.await();
            }
            System.out.println("打印 ######");
            hasValue = true;
//            condition.signal();//存在假死现象(唤醒的有可能是同类) “有可能连续”打印不是交替输出
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (!hasValue) {
                System.out.println("有可能连续 ******");
                condition.await();
            }
            System.out.println("打印 ******");
            hasValue = false;
//            condition.signal();//存在假死现象 “有可能连续”打印不是交替输出
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
