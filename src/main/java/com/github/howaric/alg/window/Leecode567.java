package com.github.howaric.alg.window;

import java.util.HashMap;

/*
给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

 */
public class Leecode567 {

    public static void main(String[] args) {
        Leecode567 leecode567 = new Leecode567();
        boolean result = leecode567.checkInclusion("ab", "eidbaooo");
        System.out.println(result);
    }

    /*
    输入：s1 = "ab" s2 = "eidbaooo"
    输出：true
    解释：s2 包含 s1 的排列之一 ("ba").
     */
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        int length = s2.length();

        if (window > length) {
            return false;
        }

        HashMap<Character, Integer> patternCounter = new HashMap<>();
        HashMap<Character, Integer> textCounter = new HashMap<>();

        //计算window的counter
        for (int i = 0; i < window; i++) {
            char charValue = s1.charAt(i);
            patternCounter.put(charValue, patternCounter.getOrDefault(charValue, 0) + 1);
        }

        int R = 0;
        for (; R < window; R++) {
            char charValue = s2.charAt(R);
            textCounter.put(charValue, textCounter.getOrDefault(charValue, 0) + 1);
        }

        while (R < length) {
            if (patternCounter.equals(textCounter)) {
                return true;
            }
            //右移一位
            int L = R - window;
            Character leftChar = s2.charAt(L);
            Character rightChar = s2.charAt(R);
            //left out, right in
            textCounter.put(leftChar, textCounter.get(leftChar) - 1);
            if (textCounter.get(leftChar) == 0) {
                textCounter.remove(leftChar);
            }
            textCounter.put(rightChar, textCounter.getOrDefault(rightChar, 0) + 1);
            R++;
        }

        return patternCounter.equals(textCounter);
    }

}
