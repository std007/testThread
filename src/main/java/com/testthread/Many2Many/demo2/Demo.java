package com.testthread.Many2Many.demo2;

public class Demo {

    /**
     * 生产者/消费者模式：多对多交替打印（static变量）
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        String lock = "";
        Product product = new Product(lock);
        Consume consume = new Consume(lock);
        int count = 2;
        ThreadProduct[] threadProducts = new ThreadProduct[count];
        ThreadConsume[] threadConsumes = new ThreadConsume[count];
        for (int i = 0; i < count; i++) {
            threadProducts[i] = new ThreadProduct(product);
            threadProducts[i].setName("生产者" + (i + 1));
            threadConsumes[i] = new ThreadConsume(consume);
            threadConsumes[i].setName("消费者" + (i + 1));
            threadProducts[i].start();
            threadConsumes[i].start();
        }

        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }

    }
}
