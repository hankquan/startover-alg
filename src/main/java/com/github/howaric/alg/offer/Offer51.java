package com.github.howaric.alg.offer;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class Offer51 {

    public static void main(String[] args) {
        int times = 10000;
        for (int i = 0; i < times; i++) {
            int[] array = ArrayGenerator.randomArray();
            int[] copy = Arrays.copyOfRange(array, 0, array.length);
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(copy));
            int result1 = reversePairsV1(array);
            int result2 = reversePairsV2(copy);
            System.out.println(Arrays.toString(array));
            if (result1 != result2) {
                System.out.println("result1: " + result1);
                System.out.println("result2: " + result2);
                throw new RuntimeException("ERROR！");
            }
        }
        System.out.println("SUCCESS!");
    }

    private static int reversePairsV2(int[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[j] > array[i]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int reversePairsV1(int[] array) {
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
        int[] temp = new int[R - L + 1];
        int index = temp.length - 1;
        int left = M;
        int right = R;
        while (left >= L && right >= M + 1) {
            if (array[left] > array[right]) {
                counter += (right - M);
            }
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
