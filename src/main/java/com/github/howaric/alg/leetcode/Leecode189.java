package com.github.howaric.alg.leetcode;

import java.util.Arrays;

public class Leecode189 {

    public static void main(String[] args) {
        int[] input = {-1, -100, 3, 99};
        //[3,99,-1,-100]
        Leecode189 leecode189 = new Leecode189();
        leecode189.rotatev2(input, 2);
        System.out.println(Arrays.toString(input));
//        leecode189.reverseArray(input, 0, 4);
//        System.out.println(Arrays.toString(input));
//        System.out.println(leecode189.gcd(10, 5));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    public void rotatev2(int[] nums, int k) {
        int count = 0;
        out: for (int i = 0; i < nums.length; i++) {
            //index->k%=nums.length
            int current = i;
            int previousValue = nums[current];
            do {
                if (count == nums.length) {
                    break out;
                }
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = previousValue;
                previousValue = temp;
                current = next;
                count++;
            } while (current != i) ;
        }
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (end > start) {
            //swap r and l
            swap(nums, start, end);
            end--;
            start++;
        }
    }

    private void swap(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}


