package com.github.howaric.alg.leetcode;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Leecode20 {

    public static void main(String[] args) {
        System.out.println(new Leecode20().isValid2("[]}"));
    }

    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        List<Character> leftBracket = List.of('[', '{', '(');
        if (!leftBracket.contains(s.charAt(0))) {
            return false;
        }
        List<Character> rightBracket = List.of(']', '}', ')');
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (rightBracket.contains(c) && !stack.isEmpty()) {
                if (rightBracket.indexOf(c) != leftBracket.indexOf(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> characterMap = Map.of(']', '[', '}', '{', ')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != characterMap.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
