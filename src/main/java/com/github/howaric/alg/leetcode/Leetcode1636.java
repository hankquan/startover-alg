package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;
import java.util.HashMap;

//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
//请你返回排序后的数组。
public class Leetcode1636 {

    public static void main(String[] args) {
        int[] nums = ArrayGenerator.randomArray(10, 100);
        frequencySortV1(nums);
    }

    //hashmap
    public static int[] frequencySortV1(int[] nums) {
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
        }
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (t1, t2) -> {
            if (counterMap.get(t1) == counterMap.get(t2)) {
                return t2 - t1;
            }
            return counterMap.get(t1) - counterMap.get(t2);
        });
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    //桶排序
    public static int[] frequencySortV2(int[] nums) {


        return null;
    }

}
