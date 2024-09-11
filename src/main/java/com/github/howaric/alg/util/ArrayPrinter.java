package com.github.howaric.alg.util;

import java.util.Arrays;

public class ArrayPrinter {

    private ArrayPrinter() {
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        boolean[][] input = {{true, true}, {false, false}};
        print(input);
    }

    public static void print(boolean[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = 0; i < x; i++) {
            String line = "";
            for (int j = 0; j < y; j++) {
                line += array[i][j];
                line += "\t";
            }
            System.out.println(line);
        }
    }

    public static void print(int[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = 0; i < x; i++) {
            String line = "";
            for (int j = 0; j < y; j++) {
                line += array[i][j];
                line += "\t";
            }
            System.out.println(line);
        }
    }

    static void print(String[][] array) {

    }

}
