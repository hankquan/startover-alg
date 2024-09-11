package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayGenerator;

//leetcode-327
//给定一个数组array，两个整数lower和upper
//返回array中有多少个子数组的累加和在[lower,upper]范围上
//解法1：前缀和数组，mergesort
//解法2：有序表
public class Leetcode327 {

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
