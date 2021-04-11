package com.github.howaric.alg.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//已知一个几乎有序的数组。
//几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说是比较小的。
//O(N*log(range))
public class RangeKeySort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 4, 6, 5};
        int range = 3;
        rangeSort(array, range);
        System.out.println(Arrays.toString(array));
    }

    //使用堆
    private static void rangeSort(int[] array, int range) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(range);
        int index = 0;
        while (index <= range) {
            heap.add(array[index++]);
        }
        int i = 0;
        while (index < array.length) {
            array[i++] = heap.poll();
            heap.add(array[index++]);
        }
        while (i < array.length) {
            array[i++] = heap.poll();
        }
    }

}
