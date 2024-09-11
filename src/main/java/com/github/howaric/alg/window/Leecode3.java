package com.github.howaric.alg.window;

import java.util.HashSet;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class Leecode3 {

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //abcbcd
        int result = 0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char charVal = s.charAt(i);
            if (charSet.contains(charVal)) {
                while (charSet.contains(charVal)) {
                    charSet.remove(s.charAt(left++));
                }
            }
            charSet.add(charVal);
            result = Math.max(result, charSet.size());
        }
        return result;
    }

}
