package com.github.howaric.alg.leetcode;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
public class Leecode6 {

    public static void main(String[] args) {
        String abcdef = convert("abcdefgh", 2);
        System.out.println(abcdef);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            //差和
            int msum = (numRows - 1) * 2;
            int gap = msum - i * 2 == 0 ? msum : (msum - i * 2);
            int k = i;
            while (k < n) {
                result.append(charArray[k]);
                k = k + gap;
                gap = msum - gap == 0 ? msum : (msum - gap);
            }
//            result.append("\n");
        }
        return result.toString();
    }

}
