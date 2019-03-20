package com.testthread.One2One.demo1;

public class ThreadA extends ThreadB {

    private MyService myService;

    public ThreadA() {
        super();
    }

    public ThreadA(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
       while (true){
            myService.set();
        }
    }
}
