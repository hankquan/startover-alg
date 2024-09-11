package com.github.howaric.alg.leetcode;

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。
 */
public class Leecode9 {

    public static void main(String[] args) {
        isPalindrome(12321);
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int y = 0;
        while (x > y) {
            int dig = x % 10;
            y = y * 10 + dig;
            x = x / 10;
        }
        if (x == y || y / 10 == x) {
            return true;
        }
        System.out.println(x);
        System.out.println(y);
        return false;
    }

}
