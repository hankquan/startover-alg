package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//num的右边有多少个数乘以2之后依然小于这个数，求总个数和
public class DoubleLessProblem {

    public static void main(String[] args) {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            int[] array = ArrayGenerator.randomArray();
            int[] copy = Arrays.copyOfRange(array, 0, array.length);
            System.out.println(Arrays.toString(array));
            int result1 = doubleLessV1(array);
            int result2 = doubleLessV2(copy);
            System.out.println(Arrays.toString(copy));
            if (result1 != result2) {
                System.out.println("Failed index: " + i);
                System.out.println("result1: " + result1);
                System.out.println("result2: " + result2);
                throw new RuntimeException("ERROR!");
            }
        }
        System.out.println("SUCCESS!");
    }

    private static int doubleLessV1(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] * 2 < array[i]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static int doubleLessV2(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    private static int process(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + (R - L) / 2;
        return process(array, L, M) + process(array, M + 1, R) + merge(array, L, M, R);
    }

    private static int merge(int[] array, int L, int M, int R) {
        int counter = 0;
        int windowR = M + 1;
        for (int i = L; i <= M; i++) {
            while (windowR <= R && array[i] > array[windowR] * 2) {
                windowR++;
            }
            counter += (windowR - M - 1);
        }

//        for (int i = L; i <= M; i++) {
//            for (int j = M + 1; j <= R; j++) {
//                if (array[i] > array[j] * 2) {
//                    counter++;
//                }
//            }
//        }

        int[] temp = new int[R - L + 1];
        int index = temp.length - 1;
        int left = M;
        int right = R;
        while (left >= L && right >= M + 1) {
            temp[index--] = array[left] > array[right] ? array[left--] : array[right--];
        }

        while (left >= L) {
            temp[index--] = array[left--];
        }

        while (right >= M + 1) {
            temp[index--] = array[right--];
        }

        for (int i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
        return counter;
    }

}
