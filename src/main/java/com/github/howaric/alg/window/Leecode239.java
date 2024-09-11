package com.github.howaric.alg.window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值 。
 */
public class Leecode239 {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, -1}, 1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return null;
        }
        //max queue
        int[] result = new int[n - k + 1];
        Deque<Integer> maxQueue = new LinkedList<>();
        int index = 0;
        for (int R = 0; R < n; R++) {
            //pop smaller index from queue tail
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[R]) {
                maxQueue.pollLast();
            }
            //expand window
            maxQueue.addLast(R);
            //pod invalid index from queue head
            if (maxQueue.peek() <= R - k) {
                maxQueue.removeFirst();
            }
            //if queue is larger than k, add result
            if (R >= k - 1) {
                result[index++] = nums[maxQueue.peekFirst()];
            }
        }

        return result;
    }


}
