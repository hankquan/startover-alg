package com.github.howaric.alg.xor;

public class FindTwoOdd {

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 3, 3, 4, 5};
        findTwoOdd(input);
    }

    //一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数？
    private static void findTwoOdd(int[] input) {
        //找到a^b
        int ab = 0;
        for (int i = 0; i < input.length; i++) {
            ab ^= input[i];
        }
        System.out.println(Integer.toBinaryString(ab));

        //找到其中一个
        int a = 0;
        int rightOne = ab & (-ab);
        for (int i = 0; i < input.length; i++) {
            if ((input[i] & rightOne) == 0) {
                a ^= input[i];
            }
        }
        int b = a ^ ab;
        System.out.println(a + "--" + b);
    }

}
