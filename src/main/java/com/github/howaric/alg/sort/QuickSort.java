package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
//        int[] ints = netherLandProblem(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(ints));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    private static void process(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int randomIndex = L + (int) ((R - L + 1) * Math.random());
        swap(array, randomIndex, R);
        int[] splits = netherLandProblem(array, L, R);
        int left = splits[0];
        int right = splits[1];
        process(array, L, left);
        process(array, right + 1, R);
    }

    private static int[] netherLandProblem(int[] array, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int lt = L - 1;
        int gt = R;
        int point = L;
        while (point < gt) {
            if (array[point] < array[R]) {
                swap(array, point++, ++lt);
            } else if (array[point] > array[R]) {
                swap(array, point, --gt);
            } else {
                point++;
            }
        }
        swap(array, R, gt);
        return new int[]{lt, gt};
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
