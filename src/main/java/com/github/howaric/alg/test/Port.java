package com.github.howaric.alg.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.submit(() -> {
            try {
                System.out.println("This is thread1: " + Thread.currentThread().getName());
                if(true){
                    throw new NoClassDefFoundError("error happened!");
                }
                countDownLatch.countDown();
            }finally {
                System.out.println("this is finally");
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.submit(() -> {
            System.out.println("This is thread2: " + Thread.currentThread().getName());
        });

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
