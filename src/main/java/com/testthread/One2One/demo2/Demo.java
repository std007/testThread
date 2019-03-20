package com.testthread.One2One.demo2;

public class Demo {

    /**
     * 生产者/消费者模式：一对一交替打印（static变量）
     *
     * @param args
     */
    public static void main(String[] args) {

        String lock = "";
        Product product = new Product(lock);
        ThreadProduct threadProduct = new ThreadProduct(product);
        threadProduct.start();

        Consume consume = new Consume(lock);
        ThreadConsume threadConsume = new ThreadConsume(consume);
        threadConsume.start();
    }
}
