package com.github.howaric.alg;

import com.github.howaric.alg.util.Timer;

public class Fib {

    //[1,1,2,3,5,8,13]
    public static void main(String[] args) {
        Timer.exec("fib1", () -> System.out.println(fib1(30)));
        Timer.exec("fib2", () -> System.out.println(fib2(30)));
        Timer.exec("fib3", () -> System.out.println(fib3(30)));
        Timer.exec("fib4", () -> System.out.println(fib4(30)));
    }

    //recurse
    private static int fib1(int n) {
        if (n < 3) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //n+1 temp array
    private static int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] tempArray = new int[n + 1];
        tempArray[1] = tempArray[2] = 1;
        return fib2(n, tempArray);
    }

    private static int fib2(int n, int[] tempArray) {
        if (tempArray[n] == 0) {
            tempArray[n] = fib2(n - 1, tempArray) + fib2(n - 2, tempArray);
        }
        return tempArray[n];
    }

    //2 len temp array
    private static int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] tempArray = new int[2];
        tempArray[0] = tempArray[1] = 1;
        for (int i = 2; i < n; i++) {
            tempArray[i % 2] = tempArray[(i + 1) % 2] + tempArray[i % 2];
        }
        return tempArray[1];
    }

    //2 temp int
    private static int fib4(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1, second = 1;
        for (int i = 3; i <= n; i++) {
            int secondTemp = second;
            second = first + second;
            first = secondTemp;
        }
        return second;
    }

}
