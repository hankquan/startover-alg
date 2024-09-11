package com.github.howaric.alg.offer;

import java.util.Deque;
import java.util.LinkedList;

//min栈
public class Offer30 {

    class MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (minStack.peek().equals(pop)) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }


}
