package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//二分法查找
public class Leecode704 {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int[] array = ArrayGenerator.randomSortedArray();
            int search = new Leecode704().searchIterator(array, 5);
            if (search != -1) {
                System.out.println(Arrays.toString(array));
                System.out.println(search);
                break;
            }
        }
    }

    //给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    public int searchIterator(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int find(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return find(nums, left, mid - 1, target);
        } else {
            return find(nums, mid + 1, right, target);
        }
    }

}
