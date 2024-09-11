package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//迭代实现归并排序
public class MergeSortIteration {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    //在区间上有序
    private static void process(int[] array, int L, int R) {
        int N = array.length;
        int step = 1;
        while (step < N) {
            int left = 0;
            while (left < N) {
                if (N - left < step) {
                    break;
                }
                int mid = left + step - 1;
                int right = mid + Math.min(step, N - mid - 1);
                merge(array, left, mid, right);
                left = right + 1;
            }
            if (step > N / 2) {
                break;
            }
            step *= 2;
        }
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
