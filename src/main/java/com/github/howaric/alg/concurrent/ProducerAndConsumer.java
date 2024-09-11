package com.github.howaric.alg.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

/**
 * 生产者消费者示例
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorage(10);
        Thread t1 = new Thread(new Producer(productStorage));
        Thread t2 = new Thread(new Consumer(productStorage));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Producer implements Runnable {

    private final ProductStorage dataBank;

    public Producer(ProductStorage dataBank) {
        this.dataBank = dataBank;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (dataBank) {
                if (dataBank.isFull()) {
                    dataBank.notify();
                    try {
                        dataBank.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
                while (!dataBank.isFull()) {
                    dataBank.createProduct(UUID.randomUUID().toString());
                }
            }
        }
    }

}

class Consumer implements Runnable {

    private final ProductStorage dataBank;

    public Consumer(ProductStorage dataBank) {
        this.dataBank = dataBank;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (dataBank) {
                if (dataBank.isEmpty()) {
                    dataBank.notify();
                    try {
                        dataBank.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (!dataBank.isEmpty()) {
                    dataBank.sellProduct();
                }
            }
        }
    }

}

class ProductStorage {

    private final Queue<String> dataBank;
    private final int max;

    public ProductStorage(int max) {
        this.max = max;
        dataBank = new LinkedList<>();
    }

    public boolean isFull() {
        return dataBank.size() == max;
    }

    public boolean isEmpty() {
        return dataBank.isEmpty();
    }

    public void createProduct(String productId) {
        if (dataBank.size() < max) {
            dataBank.add(productId);
            System.out.println("create product: " + productId);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sellProduct() {
        if (!dataBank.isEmpty()) {
            System.out.println("sell product: " + dataBank.poll());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

