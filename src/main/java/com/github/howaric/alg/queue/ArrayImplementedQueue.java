package com.github.howaric.alg.queue;

//数组实现队列
public class ArrayImplementedQueue {

    private Integer[] array;
    private int len;
    private int start;
    private int end;
    private int size;

    public static void main(String[] args) {
        ArrayImplementedQueue queue = new ArrayImplementedQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.print();
        System.out.println("-------");
        System.out.println(queue.peek());
        System.out.println("-------");
        System.out.println(queue.pop());
        queue.offer(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public ArrayImplementedQueue(int size) {
        this.array = new Integer[size];
        this.len = size;
    }

    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void offer(Integer value) {
        if (size == len) {
            throw new RuntimeException("Full queue");
        }
        array[end] = value;
        end = updateIndex(end);
        size++;
    }

    private int updateIndex(int origin) {
        origin++;
        if (origin == len) {
            origin = 0;
        }
        return origin;
    }

    public Integer pop() {
        if (size == 0) {
            throw new RuntimeException("Full queue");
        }
        Integer value = array[start];
        start = updateIndex(start);
        size--;
        return value;
    }

    public Integer peek() {
        if (size == 0) {
            throw new RuntimeException("Empty queue");
        }
        return array[end];
    }

}
