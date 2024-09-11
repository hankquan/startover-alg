package com.github.howaric.alg.leetcode;

//整数反转
public class Leecode7 {

    public static void main(String[] args) {
        int reverse = new Leecode7().reverse(-123);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int dig = x % 10;
            x = x / 10;
            result = result * 10 + dig;
        }
        return result;
    }

}
