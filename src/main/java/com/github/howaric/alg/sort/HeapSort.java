package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        //0到n调成大顶堆，将0换到n
        //0到n-1调成大顶堆，将0换到n-1
        //n从len-1到1
        for (int i = array.length - 1; i > 0; i--) {
            heapify(array, i, array.length);
        }
        //循环
        int heapSize = array.length;
        while (heapSize > 1) {
            heapify(array, 0, heapSize);
            swap(array, 0, heapSize - 1);
            heapSize--;
        }
    }

    //向下调整
    private static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largerChildIndex = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            int maxIndex = array[largerChildIndex] > array[index] ? largerChildIndex : index;
            if (maxIndex == index) {
                break;
            }
            swap(array, maxIndex, index);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] data, int i, int j) {
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }

}
