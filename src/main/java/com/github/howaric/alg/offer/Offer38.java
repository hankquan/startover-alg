package com.github.howaric.alg.offer;

import java.util.*;

//输入一个字符串，打印出该字符串中字符的所有排列。
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
public class Offer38 {

    public static void main(String[] args) {
        String[] abcs = new Offer38().permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }

    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        //深度
        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[array.length];
        StringBuilder path = new StringBuilder();
        dfs(result, path, used, array);
        return result.toArray(new String[0]);
    }

    private void dfs(Set<String> result, StringBuilder path, boolean[] used, char[] array) {
        if (path.length() == array.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                path.append(array[i]);
                used[i] = true;
                dfs(result, path, used, array);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }

}
