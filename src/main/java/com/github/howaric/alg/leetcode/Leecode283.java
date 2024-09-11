package com.github.howaric.alg.leetcode;

import java.util.Arrays;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
public class Leecode283 {

    public static void main(String[] args) {
        new Leecode283().moveZeroes(new int[]{0, 1, 0, 3, 12});

    }

    //换右边第一个非0元素
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int k = i + 1;
                while (k < n) {
                    if (nums[k] != 0) {
                        //swap k and i
                        swap(nums, k, i);
                        break;
                    }
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //左：第一个0
    //右：第一个未处理的非0
    public void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
