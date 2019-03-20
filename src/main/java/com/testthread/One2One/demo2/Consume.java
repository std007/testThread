package com.testthread.One2One.demo2;


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
                if (StringUtils.isEmpty(ValueObj.value)) {
                    lock.wait();
                }
                String value = "######";
                ValueObj.value = "";
                System.out.println("get的值是:" + value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
