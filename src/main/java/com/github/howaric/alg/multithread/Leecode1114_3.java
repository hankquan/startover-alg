package com.github.howaric.alg.multithread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

public class Leecode1114_3 {

    public static void main(String[] args) {
        final Leecode1114_3 foo = new Leecode1114_3();
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
        foo.addThread(first);
        foo.addThread(second);
        foo.addThread(third);
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

    private int number = 1;
    private Set<Thread> threadSet = new HashSet<>();

    public void addThread(Thread thread) {
        threadSet.add(thread);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        while (number != 1) {
            LockSupport.park();
        }
        printFirst.run();
        number = 2;
        unParkAll();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (number != 2) {
            LockSupport.park();
        }
        printSecond.run();
        number = 3;
        unParkAll();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (number != 3) {
            LockSupport.park();
        }
        printThird.run();
        number = 1;
        unParkAll();
    }

    private void unParkAll() {
        threadSet.forEach(LockSupport::unpark);
    }
}
