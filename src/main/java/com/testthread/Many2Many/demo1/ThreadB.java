package com.testthread.Many2Many.demo1;


public class ThreadB extends Thread {

    private MyService myService;

    public ThreadB() {
        super();
    }

    public ThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.get();
        }
    }
}
