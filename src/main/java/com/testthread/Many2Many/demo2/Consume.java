package com.testthread.Many2Many.demo2;


import org.springframework.util.StringUtils;

public class Consume {

    private String lock;

    public Consume(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (StringUtils.isEmpty(ValueObj.value)) {
                    System.out.println(Thread.currentThread().getName() + "wait ######");
                    lock.wait();
                }
                ValueObj.value = "";
                System.out.println(Thread.currentThread().getName() + "runnable");
//                lock.notify();//假死（唤醒包含同类）
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
