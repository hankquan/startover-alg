package com.github.howaric.alg.exercise;

import com.github.howaric.alg.util.ArrayGenerator;
import com.github.howaric.alg.util.ArrayPrinter;

import java.util.Arrays;

//给定一个有序数组arr，代表坐落在X轴上的点,给定一个正数K，代表绳子的长度,返回绳子最多压中几个点
public class Problem1 {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomPositiveArray(10, 100);
        Arrays.sort(array);
        ArrayPrinter.print(array);
        System.out.println("result: " + perform(array, 5));
    }

    private static int perform(int[] array, int K) {
        int max = 0;
        int L = 0;
        int R = 0;
        while (L < array.length) {
            while (R < array.length && (array[R] - array[L] <= K)) {
                R++;
            }
            max = Math.max(max, R - L++);
        }
        return max;
    }

}
