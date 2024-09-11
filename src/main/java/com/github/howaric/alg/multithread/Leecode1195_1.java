package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Leecode1195_1 {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            run();
        }
    }

    private static void run() {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t4.start();
        t2.start();
        t1.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FizzBuzz {

    private int n;
    private volatile int num;

    private ReentrantLock lock;
    private Condition condition;

    public FizzBuzz(int n) {
        this.num = 1;
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                if (num % 3 == 0 && num % 5 != 0) {
                    printFizz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                if (num % 5 == 0 && num % 3 != 0) {
                    printBuzz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                if (num % 5 == 0 && num % 3 == 0) {
                    printFizzBuzz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                if (num % 3 != 0 && num % 5 != 0) {
                    printNumber.accept(num);
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

}