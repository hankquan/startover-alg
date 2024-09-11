package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.MetricsUtils;

//矩阵置零
public class Leetcode73 {

    public static void main(String[] args) {
        int[][] metrics = MetricsUtils.randomMetrics(3, 3, 10);
        MetricsUtils.printMetrics(metrics);
        setZeroesV1(metrics);
        MetricsUtils.printMetrics(metrics);
    }

    public static void setZeroesV1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean r0 = false;
        boolean c0 = false;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                r0 = true;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                c0 = true;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (r0) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (c0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
