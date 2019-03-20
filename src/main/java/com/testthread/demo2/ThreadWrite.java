package com.testthread.demo2;




public class ThreadWrite extends Thread {

    private MyService myService;

    public ThreadWrite() {
        super();
    }

    public ThreadWrite(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
       while (true){
            myService.write();
        }
    }
}
