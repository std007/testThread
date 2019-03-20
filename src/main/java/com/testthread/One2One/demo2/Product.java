package com.testthread.One2One.demo2;


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
                if (!StringUtils.isEmpty(ValueObj.value)) {
                    lock.wait();
                }
                String value = "******";
                ValueObj.value = value;
                System.out.println("set的值是:" + value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
