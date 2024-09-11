package com.github.howaric.alg.multithread;

import java.util.concurrent.SynchronousQueue;

public class Leecode1114_4 {

    public static void main(String[] args) {
        final Leecode1114_4 foo = new Leecode1114_4();
        Thread first = new Thread(() -> {
            try {
                Thread.sleep(1000);
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread second = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread third = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        second.start();
        third.start();
        first.start();
        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private SynchronousQueue<Integer> block1_2 = new SynchronousQueue<>();
    private SynchronousQueue<Integer> block2_3 = new SynchronousQueue<>();

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        block1_2.put(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        block1_2.take();
        printSecond.run();
        block2_3.put(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        block2_3.take();
        printThird.run();
    }

}
