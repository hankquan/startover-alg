package com.github.howaric.alg.leetcode;

public class Leecode70 {

    public static void main(String[] args) {
        Leecode70 leecode70 = new Leecode70();
        int stairs = leecode70.climbStairs3(45);
        System.out.println(stairs);
        int stairs2 = leecode70.climbStairs2(45);
        System.out.println(stairs2);
    }

    //记忆化递归
    public int climbStairs(int n) {
        int[] temp = new int[n + 1];
        return doClimb(n, temp);
    }

    private int doClimb(int n, int[] temp) {
        if (temp[n] > 0) {
            return temp[n];
        }

        if (n == 1) {
            temp[n] = 1;
        } else if (n == 2) {
            temp[n] = 2;
        } else {
            temp[n] = doClimb(n - 1, temp) + doClimb(n - 2, temp);
        }

        return temp[n];
    }

    //动态规划
    public int climbStairs2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //improve 2
    public int climbStairs3(int n) {
        if (n < 1) {
            return 0;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

}
