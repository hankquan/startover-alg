package com.github.howaric.alg;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//二分法
public class Bisection {

    public static void main(String[] args) {
        int[] input = ArrayGenerator.randomSortedArray();
        System.out.println(Arrays.toString(input));
        int i = searchOne(input, 12);
        System.out.println(i);
    }

    //二分法找某个值k
    private static int searchOne(int[] array, int value) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //一个数组，找>=某个数k最左侧的位置
    private static int maxRightIndexForK(int[] array, int value) {

        return 0;
    }

    //一个数组，找<=某个数k最右侧的位置
    private static int minLeftIndexForK(int[] array, int value) {

        return 0;
    }

    //找到局部最小值
    private static int partialMin(int[] array) {

        return 0;
    }

}
