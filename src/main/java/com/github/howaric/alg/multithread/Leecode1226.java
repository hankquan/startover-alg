package com.github.howaric.alg.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Leecode1226 {

}


class DiningPhilosophers {

    private int num;
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] conditions;
    private boolean[] forkStatus;

    public DiningPhilosophers() {
        num = 5;
        forkStatus = new boolean[num];
        initConditions();
    }

    private void initConditions() {
        conditions = new Condition[num];
        for (int i = 0; i < num; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {

            int leftFork = philosopher;
            int rightFork = (philosopher + 1) % num;

            while (forkStatus[leftFork] || forkStatus[rightFork]) {
                conditions[philosopher].await();
            }

            //
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();

            //
            putLeftFork.run();
            forkStatus[leftFork] = false;
            conditions[leftFork].signal();

            //
            putRightFork.run();
            forkStatus[rightFork] = false;
            conditions[rightFork].signal();
        }finally {
            lock.unlock();
        }

    }

}