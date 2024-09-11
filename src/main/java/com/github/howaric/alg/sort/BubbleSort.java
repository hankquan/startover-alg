package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//https://zhuanlan.zhihu.com/p/240237922
public class BubbleSort {

    public static void main(String[] args) {
        int arraySize = 100;
        int maxValue = 1000;
        int times = 50000;
        for (int t = 0; t < times; t++) {
            int[] array = ArrayGenerator.randomArrayWithFixSize(arraySize, maxValue);
            int[] copy = Arrays.copyOfRange(array, 0, array.length);
            Arrays.sort(copy);
            sort(array);
            for (int i = 0; i < array.length; i++) {
                if (array[i] != copy[i]) {
                    throw new RuntimeException("ERROR!");
                }
            }
        }
        System.out.println("SUCCESS!");
    }

    //冒泡排序
    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
