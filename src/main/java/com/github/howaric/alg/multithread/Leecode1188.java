package com.github.howaric.alg.multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Leecode1188 {
}

class BoundedBlockingQueue {

    private Queue<Integer> data;
    private int capacity = 0;
    private ReentrantLock lock;
    private Condition empty;
    private Condition full;

    public BoundedBlockingQueue(int capacity) {
        this.data = new LinkedList<Integer>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.empty = lock.newCondition();
        this.full = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (data.size() == capacity) {
                full.await();
            }
            data.offer(element);
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        int res = -1;
        try {
            while (data.size() == 0) {
                empty.await();
            }
            res = data.poll();
            full.signal();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public int size() {
        return data.size();
    }
}