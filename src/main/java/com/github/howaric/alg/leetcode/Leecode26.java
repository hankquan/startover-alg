package com.github.howaric.alg.leetcode;

import java.util.Arrays;

/*
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
将最终结果插入nums 的前 k 个位置后返回 k 。
不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Leecode26 {

    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 4, 5, 5};
        new Leecode26().removeDuplicates(input);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                swap(nums, p1 + 1, p2);
                p1++;
            }
            p2++;
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(p1);
        return p1 + 1;
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

}
