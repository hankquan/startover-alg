package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//按序打印
public class Leecode1114_1 {

    public static void main(String[] args) {
        final Leecode1114_1 foo = new Leecode1114_1();
        Thread first = new Thread(() -> {
            try {
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
        first.start();
        third.start();
        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Leecode1114_1() {

    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition firstPrintedCondition = lock.newCondition();
    private Condition secondPrintedCondition = lock.newCondition();
    private boolean firstPrinted = false;
    private boolean secondPrinted = false;


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        printFirst.run();
        firstPrinted = true;
        firstPrintedCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        if (!firstPrinted) {
            firstPrintedCondition.await();
        }
        printSecond.run();
        secondPrinted = true;
        secondPrintedCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        if (!secondPrinted) {
            secondPrintedCondition.await();
        }
        printThird.run();
        lock.unlock();
    }

}
