package com.github.howaric.alg.leetcode;

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//子数组 是数组的连续子序列。
public class Leecode152 {

    public static void main(String[] args) {
        int result = new Leecode152().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int prevMin = nums[0];
        int prevMax = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = prevMin;
            int max = prevMax;
            prevMin = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            prevMax = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            result = Math.max(prevMax, result);
        }
        return result;
    }

    public int maxProductDP(int[] nums) {
        int length = nums.length;
        int[] minStore = new int[length];
        int[] maxStore = new int[length];
        minStore[0] = nums[0];
        maxStore[0] = nums[0];
        for (int i = 1; i < length; i++) {
            minStore[i] = Math.min(minStore[i - 1] * nums[i], Math.min(maxStore[i - 1] * nums[i], nums[i]));
            maxStore[i] = Math.max(minStore[i - 1] * nums[i], Math.max(maxStore[i - 1] * nums[i], nums[i]));
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, maxStore[i]);
        }
        return res;
    }

}
