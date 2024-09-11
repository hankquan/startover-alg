package com.github.howaric.alg.dp;

//给你一个字符串 s，找到 s 中最长的回文子串。
public class Leecode5 {

    public static void main(String[] args) {
        String s = "abba";
        CenterExpand centerExpand = new CenterExpand();
        int abba = centerExpand.findPalindrome("abbac", 1, 2);
        System.out.println(abba);
        String longestPalindrome = centerExpand.longestPalindrome(s);
        System.out.println(longestPalindrome);
        String longestPalindrome1 = new DynamicPlanning().longestPalindrome(s);
        System.out.println(longestPalindrome1);

    }

    public static class CenterExpand {

        // abcdcbee
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 1) {
                return s;
            }
            int maxLength = 1;
            int start = 0;
            int end = 0;
            for (int i = 0; i < n; i++) {
                int p1 = findPalindrome(s, i, i);
                int p2 = findPalindrome(s, i, i + 1);
                int larger = Math.max(p1, p2);
                if (larger > maxLength) {
                    maxLength = larger;
                    start = i - (maxLength - 1) / 2;
                    end = i + maxLength / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        //返回以r,l开始最长回文子串的长度
        public int findPalindrome(String s, int left, int right) {
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }

    public static class DynamicPlanning {

        // abcdcbee
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 1) {
                return s;
            }

            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            int maxLength = 1;
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

}
