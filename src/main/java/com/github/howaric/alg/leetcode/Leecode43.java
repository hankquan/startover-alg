package com.github.howaric.alg.leetcode;

/*
给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class Leecode43 {

    public static void main(String[] args) {
        String s = new Leecode43().multiply("123", "345");
        System.out.println(s);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] nums1 = num1.chars().map(num -> num - 48).toArray();
        int[] nums2 = num2.chars().map(num -> num - 48).toArray();
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                ansArr[i + j + 1] += nums1[i] * nums2[j];
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        StringBuilder ans = new StringBuilder();
        int start = ansArr[0] == 0 ? 1 : 0;
        for (int i = start; i < m + n; i++) {
            ans.append(ansArr[i]);
        }
        return ans.toString();
    }

}
