package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//插入排序
public class InsertionSort {

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

    //[21,3,7,34,4]
    //j-1 j
    //0-1
    //0-2
    //0-3
    //0-i
    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
