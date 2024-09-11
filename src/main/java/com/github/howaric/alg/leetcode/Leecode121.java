package com.github.howaric.alg.leetcode;

public class Leecode121 {

    public static void main(String[] args) {
        int result = new Leecode121().maxProfit(new int[]{2, 4, 1, 11, 7});
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
