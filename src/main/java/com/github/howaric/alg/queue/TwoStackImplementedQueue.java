package com.github.howaric.alg.queue;

import java.util.Stack;

//数组实现队列，不考虑并发
public class TwoStackImplementedQueue {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public static void main(String[] args) {
        TwoStackImplementedQueue siq = new TwoStackImplementedQueue();
        siq.push(1);
        siq.push(2);
        siq.push(3);
        System.out.println(siq.pop());
        siq.push(4);
        System.out.println(siq.pop());
        System.out.println(siq.pop());
        System.out.println(siq.pop());
    }

    //进队列
    public void push(Integer value) {
        pushStack.push(value);
        moveToPop();
    }

    //出队列
    public Integer pop() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        moveToPop();
        return popStack.pop();
    }

    private void moveToPop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

}
