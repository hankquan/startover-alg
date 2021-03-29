package com.github.howaric.alg.stack;

import java.util.Stack;

//实现一个栈，pop,push,getMin操作的时间复杂度都是O(1)
public class GetMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        GetMinStack minStack = new GetMinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        minStack.push(2);
        System.out.println(minStack.getMin());
    }

    public void push(Integer value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        Integer min = minStack.peek();
        if (value < min) {
            minStack.push(value);
        } else {
            minStack.push(min);
        }
    }

    public Integer pop() {
        return stack.pop();
    }

    public Integer getMin() {
        return minStack.pop();
    }

}
