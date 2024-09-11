package com.github.howaric.alg.leetcode;

import java.util.PriorityQueue;

public class Leecode215 {

    public static void main(String[] args) {
        int[] input = {-1, 2, 0};
        System.out.println(new Leecode215().findKthLargest(input, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }

}
