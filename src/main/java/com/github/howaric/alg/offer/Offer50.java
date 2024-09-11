package com.github.howaric.alg.offer;

import java.util.HashMap;
import java.util.Map;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
public class Offer50 {

    public static void main(String[] args) {
        String input = "abaccdeff";

    }

    public char firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                map.put(item, -1);
            } else {
                map.put(item, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer index = entry.getValue();
            if (index != -1 && index < first) {
                first = index;
            }
        }

        return first == n ? ' ' : s.charAt(first);
    }

}
