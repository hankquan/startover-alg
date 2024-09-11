package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Leecode1116 {

    public static void main(String[] args) {
        final ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

class ZeroEvenOdd {
    private int n;
    private ReentrantLock lock;
    private Condition printZero;
    private Condition printEven;
    private Condition printOdd;
    private boolean isZero = true;
    private int printCase = 0;// -1 odd, 1 even

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.printZero = lock.newCondition();
        this.printEven = lock.newCondition();
        this.printOdd = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                if (!isZero) {
                    printZero.await();
                }
                printNumber.accept(0);
                //通知print number
                isZero = false;
                if (i % 2 == 0) {
                    //print even
                    printCase = 1;
                    printEven.signal();
                } else {
                    printCase = -1;
                    //print odd
                    printOdd.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                if (printCase != 1) {
                    printEven.await();
                }
                printNumber.accept(i);
//                TimeUnit.MILLISECONDS.sleep(100);
                printCase = -1;
                isZero = true;
                printZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                if (printCase != -1) {
                    printOdd.await();
                }
                printNumber.accept(i);
//                TimeUnit.MILLISECONDS.sleep(100);

                printCase = 1;
                isZero = true;
                printZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}