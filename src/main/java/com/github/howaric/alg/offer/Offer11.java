package com.github.howaric.alg.offer;

//旋转数组的最小数字
public class Offer11 {

    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        int result = offer11.minArray(new int[]{3, 4, 5, 1, 2});
        System.out.println(result);
    }

    public int minArray(int[] numbers) {
        int prev = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (prev > numbers[i]) {
                return numbers[i];
            }
            prev = numbers[i];
        }

        return numbers[0];
    }

}
