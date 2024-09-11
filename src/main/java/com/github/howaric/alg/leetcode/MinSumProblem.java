package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//小和问题
//求一列数，每个数左边比这个数小的所有数累加之和
public class MinSumProblem {

    public static void main(String[] args) {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            int[] array = ArrayGenerator.randomArray();
            int[] copy = Arrays.copyOfRange(array, 0, array.length);
//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(copy));
            int sum1 = minSumV1(array);
            int sum2 = minSum(copy);
            if (sum1 != sum2) {
                System.err.println("ERROR");
                System.out.println("sum1: " + sum1);
                System.out.println("sum2: " + sum2);
            }
        }
    }

    private static int minSumV1(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[j] < array[i]) {
                    sum += array[j];
                }
            }
        }
        return sum;
    }

    private static int minSum(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    private static int process(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + (R - L) / 2;
        return process(array, L, mid) + process(array, mid + 1, R) + merge(array, L, mid, R);
    }

    private static int merge(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int index = 0;
        int leftIndex = L;
        int rightIndex = M + 1;
        int sum = 0;
        while (leftIndex <= M && rightIndex <= R) {
            sum += array[leftIndex] < array[rightIndex] ? (R - rightIndex + 1) * array[leftIndex] : 0;
            temp[index++] = array[leftIndex] < array[rightIndex] ? array[leftIndex++] : array[rightIndex++];
        }
        while (leftIndex <= M) {
            temp[index++] = array[leftIndex++];
        }
        while (rightIndex <= R) {
            temp[index++] = array[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
        return sum;
    }

}
