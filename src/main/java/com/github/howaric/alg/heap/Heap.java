package com.github.howaric.alg.heap;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.traverse();
        System.out.println(minHeap.poll());
        System.out.println(minHeap.size());
    }

}

class MinHeap {

    private int size;
    private int[] data;

    public MinHeap(int initialCapacity) {
        this.data = new int[initialCapacity];
    }

    public void add(int value) {
        if (size == data.length) {
            throw new RuntimeException("Heap is full!!");
        }
        data[size] = value;
        heapInsert(size++);
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty!!");
        }
        int result = data[0];
        swap(data, 0, --size);
        heapify(0);
        return result;
    }

    //O(logN)
    //向上看父节点，如果小，则与父节点交换
    private void heapInsert(int index) {
        while (data[(index - 1) / 2] > data[index]) {
            swap(data, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    //O(logN)
    //与子节点比较，如果某个子节点小，则交换
    private void heapify(int index) {
        //左子节点
        int left = index << 1 + 1;
        //要判断是否越界
        while (left < size) {
            int largerChild = left + 1 < size && data[left] > data[left + 1] ? left : left + 1;
            int maxIndex = data[index] > data[largerChild] ? index : largerChild;
            if (maxIndex == index) {
                break;
            }
            swap(data, maxIndex, index);
            index = maxIndex;
            left = index << 1 + 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j || array[i] == array[j]) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void traverse() {
        System.out.println(Arrays.toString(data));
    }

    public int size() {
        return size;
    }

}