package com.github.howaric.alg.util;

public class MetricsUtils {

    public static void main(String[] args) {
        int[][] ints = randomMetrics(4, 3, 100);
        printMetrics(ints);
    }

    public static int[][] randomMetrics(int row, int col, int maxValue) {
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = (int) ((maxValue) * Math.random());
            }
        }
        return result;
    }

    public static void printMetrics(int[][] metrics) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < metrics.length; i++) {
            for (int j = 0; j < metrics[0].length; j++) {
                System.out.print(metrics[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }

}
