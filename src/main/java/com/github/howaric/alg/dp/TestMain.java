package com.github.howaric.alg.dp;

public class TestMain {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcb"));
    }

    // abcdcbee
    // dp
    // dp[i,j] == dp[i+1,j-1]&& s[i]=s[j]
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //斜对角都是true
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLength = 0;
        int start = 0, end = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

}
