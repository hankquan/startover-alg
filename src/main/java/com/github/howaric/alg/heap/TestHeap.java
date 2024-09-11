package com.github.howaric.alg.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestHeap<T> {

    private int heapSize;
    private List<T> heapElements;
    private Comparator<T> comparator;

    public TestHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heapElements = new ArrayList<>();
    }

    public T peek() {
        return heapElements.get(0);
    }

    public T pop() {
        if (heapSize == 0) {
            return null;
        }
        T top = heapElements.get(0);
        swap(0, --heapSize);
        heapify(0);
        return top;
    }

    public void add(T t) {
        heapElements.add(t);
        heapInsert(heapSize++);
    }

    //向下看
    private void heapify(int index) {
        int leftChildIndex = index * 2 + 1;
        while (leftChildIndex < heapSize) {
            int betterChildIndex = leftChildIndex + 1 < heapSize && comparator.compare(heapElements.get(leftChildIndex + 1), heapElements.get(leftChildIndex)) < 0 ? leftChildIndex + 1 : leftChildIndex;
            if (comparator.compare(heapElements.get(index), heapElements.get(betterChildIndex)) < 0) {
                break;
            }
            swap(betterChildIndex, index);
            index = betterChildIndex;
            leftChildIndex = index * 2 + 1;
        }
    }

    //向上看
    private void heapInsert(int index) {
        //父节点小，则互换
        int parentIndex = (index - 1) / 2;
        while (comparator.compare(heapElements.get(index), heapElements.get(parentIndex)) < 0) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        T t1 = heapElements.get(i);
        T t2 = heapElements.get(j);
        heapElements.set(i, t2);
        heapElements.set(j, t1);
    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(heapElements.get(i));
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        TestHeap<Integer> heap = new TestHeap<>(Comparator.comparingInt(Integer::intValue));
        heap.add(4);
        heap.add(2);
        heap.add(6);
        heap.add(1);
        heap.add(8);
        heap.add(5);
        heap.print();
        System.out.println("====");
        System.out.println(heap.pop());
        System.out.println("====");
        heap.print();
    }
}