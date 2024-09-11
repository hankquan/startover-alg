package com.github.howaric.alg.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
public class Leecode14 {

    public static void main(String[] args) {
        Leecode14 leecode14 = new Leecode14();
        String longestPrefix = leecode14.findLongestPrefix("0", "1");
        System.out.println(longestPrefix);
        String commonPrefix = leecode14.longestCommonPrefix(new String[]{"123", "12345", "12"});
        System.out.println(commonPrefix);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = findLongestPrefix(result, strs[i]);
            if (result.length() < 1) {
                return "";
            }
        }
        return result;
    }

    private String findLongestPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        if (len < 1) {
            return "";
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            index++;
        }

        return str1.substring(0, index);
    }

}
