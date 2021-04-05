package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
//        recursiveMergeSort(array);
        iterationMergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    //递归实现
    //[4,2,1,7,9,5,6]
    public static void recursiveMergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    //将L到R排序
    private static void process(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + (R - L) / 2;
        process(array, L, M);
        process(array, M + 1, R);
        merge(array, L, M, R);
    }

    //合并L到M，M+1到R
    //[1,5,6,0,4,6]
    private static void merge(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = L;
        int j = M + 1;
        int index = 0;
        while (i <= M && j <= R) {
            if (array[i] < array[j]) {
                temp[index] = array[i++];
            } else {
                temp[index] = array[j++];
            }
            index++;
        }
        while (i <= M) {
            temp[index++] = array[i++];
        }
        while (j <= R) {
            temp[index++] = array[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[L + k] = temp[k];
        }
    }

    //迭代版
    //[4,2,1,7,9,5,6]
    private static void iterationMergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int N = array.length;
        int stepSize = 1;
        while (stepSize < N) {
            int L = 0;
            while (L < N) {
                if (N - L < stepSize) {
                    break;
                }
                int M = L + stepSize - 1;
                int R = M + Math.min(stepSize, N - M - 1);
                merge(array, L, M, R);
                L = R + 1;
            }
            if (stepSize > N / 2) {
                break;
            }
            stepSize <<= 1;
        }
    }

}
