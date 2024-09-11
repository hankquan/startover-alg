package com.github.howaric.alg.leetcode;

import java.util.Arrays;

public class Leecode88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Leecode88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int index1 = 0;
        int index2 = 0;

        while (index1 < m && index2 < n) {//
            if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                //swap nums1[index1]<>nums2[index2]
                swap(nums1, index1, nums2, index2);
                //move index2 to its location
                move(nums2, index2);
            }
        }

        int k = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[k++];
        }

//        System.out.println(Arrays.toString(nums1));
    }

    private void swap(int[] nums1, int i, int[] nums2, int j) {
        int tmp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = tmp;
    }

    private void move(int[] nums, int i) {
        while (i + 1 < nums.length && nums[i] > nums[i + 1]) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
            i++;
        }
    }

}
