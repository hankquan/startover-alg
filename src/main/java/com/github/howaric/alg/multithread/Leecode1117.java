package com.github.howaric.alg.multithread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Leecode1117 {

}

class H2O {

        private CyclicBarrier barrierH = new CyclicBarrier(2);
//    private CyclicBarrier barrierO = new CyclicBarrier(1);
    private Semaphore semaphoreH = new Semaphore(2);
    private Semaphore semaphoreO = new Semaphore(1);
    private Object releaseLock = new Object();


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
        release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        release();
    }

    private void release() {
        synchronized (releaseLock) {
            if (semaphoreH.availablePermits() == 0 && semaphoreO.availablePermits() == 0) {
                semaphoreH.release(2);
                semaphoreO.release(1);
            }
        }
    }

}