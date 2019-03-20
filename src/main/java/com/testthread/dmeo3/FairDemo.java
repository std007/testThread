package com.testthread.dmeo3;


public class FairDemo {

    /**
     * 公平锁（顺序执行）
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        //isFair
        final MyService myService = new MyService(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始执行了");
                myService.serviceMethod();
            }
        };
        int count = 10;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }


}
