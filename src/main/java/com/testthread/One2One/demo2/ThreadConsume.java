package com.testthread.One2One.demo2;

public class ThreadConsume extends Thread {

    private Consume consume;

    public ThreadConsume() {
        super();
    }

    public ThreadConsume(Consume consume) {
        super();
        this.consume = consume;
    }

    @Override
    public void run() {
        while (true) {
            consume.getValue();
        }
    }
}
