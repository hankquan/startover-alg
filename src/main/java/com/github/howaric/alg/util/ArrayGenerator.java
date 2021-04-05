package com.github.howaric.alg.util;

import java.util.Arrays;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArray()));
        System.out.println(Arrays.toString(randomArray(12, 5)));
        System.out.println(Arrays.toString(randomSortedArray()));
    }

    public static int[] randomArray() {
        return randomArray(10, 100);
    }

    public static int[] randomArray(int maxSize, int maxValue) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return result;
    }

    public static int[] randomSortedArray() {
        int[] result = randomArray();
        Arrays.sort(result);
        return result;
    }

}
