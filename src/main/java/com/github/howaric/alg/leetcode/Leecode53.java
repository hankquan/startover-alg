package com.github.howaric.alg.leetcode;

import java.util.Arrays;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组 是数组中的一个连续部分。
public class Leecode53 {

    public static void main(String[] args) {
//        Leecode53 leecode53 = new Leecode53();
//        //要求O(n)的时间复杂度
//        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(leecode53.maxSubArray1(input));
        String format = String.format("%04d", 10);
        System.out.println(format);
    }

    //贪心
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    //DP
    public int maxSubArray1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).max().getAsInt();
    }


}
