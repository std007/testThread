package com.testthread.demo2;


public class ThreadRead extends Thread {

    private MyService myService;

    public ThreadRead() {
        super();
    }

    public ThreadRead(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.read();
        }
    }
}
