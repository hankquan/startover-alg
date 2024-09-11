package com.github.howaric.alg.leetcode;

import java.util.Arrays;

//给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
//返回这三个数的和。
//假定每组输入只存在恰好一个解。
public class Leecode16 {

    public static void main(String[] args) {
        int closest = new Leecode16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(closest);
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int result = 10000000;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {//要变小，右指针左移，条件是左移的右指针大于j
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
                if (sum < target) {//要变大，左指针右移，条件是右移的左指针小于k
                    j++;
                    while (k > j && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }

}
