package com.testthread.Many2Many.demo2;

public class ThreadProduct extends Thread {

    private Product product;

    public ThreadProduct() {
        super();
    }

    public ThreadProduct(Product product){
        super();
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            product.setValue();
        }
    }
}
