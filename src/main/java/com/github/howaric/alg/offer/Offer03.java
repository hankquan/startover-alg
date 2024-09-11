package com.github.howaric.alg.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {

    //找到重复数字
    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        int[] nums = {2, 3, 1, 4, 5, 4};
        int repeatNumber = offer03.findRepeatNumber(nums);
        System.out.println(repeatNumber);
        int repeatNumber2 = offer03.findRepeatNumber2(nums);
        System.out.println(repeatNumber2);
        int repeatNumber3 = offer03.findRepeatNumber3(nums);
        System.out.println(repeatNumber3);
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    //use array
    //2,3,1,4,5,4
    //0,1,2,3,4,5
    public int findRepeatNumber2(int[] nums) {
        int n = nums.length;
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            help[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (help[nums[i]] == -1) {
                help[nums[i]] = 1;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    //原地
    //2,3,1,4,5,4
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                //swap nums[i] i
                swap(nums, nums[i], i);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }

}
