package com.github.howaric.alg.offer;

import java.util.Deque;
import java.util.LinkedList;

//用两个栈实现队列
public class Offer09 {

    class CQueue {

        private Deque<Integer> stack;
        private Deque<Integer> helper;

        public CQueue() {
            stack = new LinkedList<>();
            helper = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (helper.isEmpty()) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
            }

            if (helper.isEmpty()) {
                return -1;
            }

            return helper.pop();
        }
    }

}
