package com.github.howaric.alg.stack;

public class ArrayImplementedStack {

    private Integer[] array;
    private int index;
    private int size;

    public ArrayImplementedStack(int size) {
        this.array = new Integer[size];
    }

    public static void main(String[] args) {
        ArrayImplementedStack stack = new ArrayImplementedStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void push(Integer value) {
        if (size == array.length) {
            throw new RuntimeException("Stack full");
        }
        array[index] = value;
        index++;
        size++;
    }

    public Integer pop() {
        if (size == 0) {
            throw new RuntimeException("Stack empty");
        }
        Integer result = array[index - 1];
        index--;
        size--;
        return result;
    }

}
