package com.github.howaric.alg.offer;

public class Offer53 {

    public static void main(String[] args) {
        Offer53 offer53 = new Offer53();
        int number = offer53.missingNumber(new int[]{0, 1, 2});
        System.out.println(number);
    }

    //统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    //在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    public int missingNumber(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int start, int end) {
        if (start == end) {
            if (nums[start] == start) {
                return nums.length;
            } else {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == mid) {
            return find(nums, mid + 1, end);
        } else {
            return find(nums, start, mid);
        }
    }

}
