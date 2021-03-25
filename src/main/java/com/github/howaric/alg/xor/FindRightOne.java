package com.github.howaric.alg.xor;

public class FindRightOne {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(12));
        int rightOne = findRightOne(12);
        System.out.println(rightOne);
        System.out.println(Integer.toBinaryString(rightOne));
        System.out.println(Integer.toBinaryString(-12));
    }

    //怎么把一个整型二进制最右侧的1提取出来
    private static int findRightOne(int number) {
//        return number & (-number);
        return number & ((~number) + 1);
    }


}
