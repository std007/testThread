package com.testthread.Many2Many.demo1;



public class ThreadA extends Thread {

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
