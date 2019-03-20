package com.testthread.dmeo3;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock;

    public MyService(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁定======");
        } finally {
            lock.unlock();
        }
    }


}
