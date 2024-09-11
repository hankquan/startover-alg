package com.github.howaric.alg.stack;

import java.util.LinkedList;
import java.util.Queue;

//两个队列实现栈
public class TwoQueueImplementedStack {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public static void main(String[] args) {
        TwoQueueImplementedStack stack = new TwoQueueImplementedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void push(Integer value) {
        queue.offer(value);
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        Integer result = queue.poll();
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return result;
    }

}
