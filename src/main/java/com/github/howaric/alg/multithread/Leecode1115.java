package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Leecode1115 {


}

class FooBar {
    private int n;
    private ReentrantLock lock;
    private Condition fooPrinted;
    private Condition barPrinted;
    private int signal = 0;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.fooPrinted = lock.newCondition();
        this.barPrinted = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (signal != 0) {
                    barPrinted.await();
                }
                printFoo.run();
                signal = 1;
                fooPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (signal != 1) {
                    fooPrinted.await();
                }
                printBar.run();
                signal = 0;
                barPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}