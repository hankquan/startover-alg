package com.github.howaric.alg.exercise;

//给定一个非负整数num,返回离num最近的,2的某次方
public class Problem3 {

    public static void main(String[] args) {
        int num = 1;
        System.out.println("result: " + calculate(num));
    }

    private static int calculate(int num) {
        num--;
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;
        return num < 0 ? 1 : num + 1;
    }

}
