package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Leecode1195_2 {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            run();
        }
    }

    private static void run() {
        FizzBuzz2 fizzBuzz = new FizzBuzz2(15);
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

class FizzBuzz2 {

    private int n;
    private volatile int num;

    private ReentrantLock lock;
    private Condition condition;
    private Condition fizzCondition;
    private Condition buzzCondition;
    private Condition fizzBuzzCondition;

    public FizzBuzz2(int n) {
        this.num = 1;
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.fizzCondition = lock.newCondition();
        this.buzzCondition = lock.newCondition();
        this.fizzBuzzCondition = lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (num > 1 && num <= n) {
                printFizz.run();
                decideNext();
            }
        } finally {
            lock.unlock();
        }
    }

    private void decideNext() {
        num++;
        if (num % 3 == 0 && num % 5 != 0) {
            //fizz
            fizzCondition.signal();
        } else if (num % 3 != 0 && num % 5 == 0) {
            buzzCondition.signal();
        } else if (num % 3 == 0 && num % 5 == 0) {
            fizzBuzzCondition.signal();
        } else {
            condition.signal();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (num > 1 && num <= n) {
                printBuzz.run();
                decideNext();
            }
        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (num > 1 && num <= n) {
                printFizzBuzz.run();
                decideNext();

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
                printNumber.accept(num);
                decideNext();
            }
        } finally {
            lock.unlock();
        }
    }

}