package com.github.howaric.alg.xor;

public class FindOneOdd {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 2, 5, 1, 3, 5};
        System.out.println(findOneOdd(input));
    }

    //一个数组中有一个数出现了奇数次，其他数都出现了偶数次，请找出这个数
    private static int findOneOdd(int[] input) {
        int xor = 0;
        for (int i = 0; i < input.length; i++) {
            xor ^= input[i];
        }
        return xor;
    }

}
