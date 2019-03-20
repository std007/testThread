package com.testthread.demo2;

public class Demo {

    /**
     * 读写互斥
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
        int countRead = 5;
        int countWrite = 1;
        ThreadRead[] threadReads = new ThreadRead[countRead];
        ThreadWrite[] threadWrites = new ThreadWrite[countWrite];
        for (int i = 0; i < countRead; i++) {
            threadReads[i] = new ThreadRead(myService);
            threadReads[i].setName("读者" + (i + 1));
            Thread.sleep(1000);
            threadReads[i].start();
        }
        for (int i = 0; i < countWrite; i++) {
            threadWrites[i] = new ThreadWrite(myService);
            threadWrites[i].setName("写者" + (i + 1));
            threadWrites[i].start();
        }

//        Thread.sleep(5000);
//        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
//        Thread.currentThread().getThreadGroup().enumerate(threads);
//        for (int i = 0; i < threads.length; i++) {
//            System.out.println("==>" + threads[i].getName() + " " + threads[i].getState());
//        }
    }
}
