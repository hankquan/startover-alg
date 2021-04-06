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

//小和问题
//求一列数，每个数左边比这个数小的所有数累加之和
class MinSumProblem {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
        int sum = minSum(array);
        System.out.println(sum);
        System.out.println(Arrays.toString(array));
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
        int M = L + (R - L) / 2;
        return process(array, L, M) + process(array, M + 1, R) + merge(array, L, M, R);
    }

    private static int merge(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int index = 0;
        int indexL = L;
        int indexR = M + 1;
        int sum = 0;
        while (indexL <= M && indexR <= R) {
            if (array[indexL] < array[indexR]) {
                sum += ((R - indexR + 1) * array[indexL]);
                temp[index++] = array[indexL++];
            } else {
                temp[index++] = array[indexR++];
            }
        }
        while (indexL <= M) {
            temp[index++] = array[indexL++];
        }
        while (indexR <= R) {
            temp[index++] = array[indexR++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
        return sum;
    }
}

//逆序对之和
class ReversePairProblem {

}

//num的右边有多少个数乘以2之后依然小于这个数，求总个数和
class DoubleMinProblem {

}

//leetcode-327
//给定一个数组array，两个整数lower和upper
//返回array中有多少个子数组的累加和在[lower,upper]范围上
//解法1：前缀和数组，mergesort
//解法2：有序表
class CountRangeSumProblem {

    public static void main(String[] args) {
        int lower = 0;
        int upper = 0;
        int[] array = ArrayGenerator.randomArray();
        int countRangeSum = countRangeSum(array, lower, upper);
        System.out.println(countRangeSum);
    }

    private static int countRangeSum(int[] array, int lower, int upper) {

        return 0;
    }

}
