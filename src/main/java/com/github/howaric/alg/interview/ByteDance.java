package com.github.howaric.alg.interview;

import java.util.Stack;

public class ByteDance {

    public static void main(String[] args) {
        String input = "/a/b/";
        // /a  /b  /.. /
        // a b ..
        String reduce = reduce(input);
        System.out.println(reduce);
    }

    private static String reduce(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            String pathName = split[i];
            if ("..".equals(pathName)) {
                stack.pop();
                continue;
            } else if (".".equals(pathName)) {
                continue;
            }
            stack.push(pathName);
        }
        String result = "";
        while (!stack.isEmpty()) {
            String value = stack.pop();
            if (value == null || value.length() == 0) {
                continue;
            }
            result = "/" + value + result;
        }
        return result;
    }
}
