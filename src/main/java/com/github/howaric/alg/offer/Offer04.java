package com.github.howaric.alg.offer;

public class Offer04 {

    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();
        int[][] input = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean numberIn2DArray = offer04.findNumberIn2DArray(input, 20);
        System.out.println(numberIn2DArray);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 & j <= n - 1) {

            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }

        }
        return false;
    }

}
