package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//递归实现归并排序
public class MergeSortRecursion {

    public static void main(String[] args) {
        int[] input = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void sort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    private static void process(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        // mid
        int mid = L + (R - L) / 2;
        //left sort
        process(array, L, mid);
        //right sort
        process(array, mid + 1, R);
        //merge
        merge(array, L, mid, R);
    }

    private static void merge(int[] array, int L, int M, int R) {
        //辅助数组
        int[] temp = new int[R - L + 1];
        int left = L;
        int right = M + 1;
        int index = 0;
        while (left <= M && right <= R) {
            if (array[left] <= array[right]) {
                temp[index] = array[left++];
            } else {
                temp[index] = array[right++];
            }
            index++;
        }
        while (left <= M) {
            temp[index++] = array[left++];
        }
        while (right <= R) {
            temp[index++] = array[right++];
        }
        //拷贝temp到array L-M
        for (int i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
    }

}
