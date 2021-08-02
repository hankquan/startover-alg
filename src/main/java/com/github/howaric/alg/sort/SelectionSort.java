package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArrayWithFixSize(10);
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    //选择排序
    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
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
