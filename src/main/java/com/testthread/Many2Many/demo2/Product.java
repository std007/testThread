package com.testthread.Many2Many.demo2;


import org.springframework.util.StringUtils;

public class Product {
    private String lock;

    public Product(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!StringUtils.isEmpty(ValueObj.value)) {
                    System.out.println(Thread.currentThread().getName() + " wait ******");
                    lock.wait();
                }
                String value = "******";
                ValueObj.value = value;
                System.out.println(Thread.currentThread().getName() + " runnable");
//                lock.notify();//假死（唤醒包含同类）
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
