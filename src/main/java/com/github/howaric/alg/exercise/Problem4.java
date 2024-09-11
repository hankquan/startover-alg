package com.github.howaric.alg.exercise;

//数组只有两种字符g,b,所有g放在左侧,b放在右侧,或所有g放在右侧,所有b放在左侧返回至少交换几次
public class Problem4 {

    public static void main(String[] args) {
        String[] input = new String[]{"G", "B", "G", "G", "G"};
        System.out.println("result: " + solve(input));
    }

    private static int solve(String[] input) {
        return Math.min(doSolve(input, "G"), doSolve(input, "B"));
    }

    //贪心
    private static int doSolve(String[] input, String character) {
        int index = 0;
        int point = 0;
        int result = 0;
        while (point < input.length) {
            String item = input[point];
            if (character.equals(item)) {
                result += (point - index);
                index++;
            }
            point++;
        }
        return result;
    }

}
