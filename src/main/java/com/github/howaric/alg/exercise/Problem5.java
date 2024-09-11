package com.github.howaric.alg.exercise;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.HashMap;
import java.util.Map;

//数组arr,在每个数字前决定符号,但所有数字参与再给target,问最后算出target的方法数
//leecode494: https://leetcode-cn.com/problems/target-sum/
public class Problem5 {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray(10, 100);
        System.out.println(process(array, 0, 80));
        System.out.println(process2(array, 0, 80, new HashMap<>()));
    }

    //递归
    private static int process(int[] input, int index, int rest) {
        if (index == input.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(input, index + 1, rest - input[index])
                + process(input, index + 1, rest + input[index]);
    }

    //记忆化搜索，加缓冲，保存已经计算过的值
    public static int process2(int[] array, int index, int rest, Map<Integer, Map<Integer, Integer>> dp) {
        if (dp.containsKey(index) && dp.get(index).containsKey(rest)) {
            return dp.get(index).get(rest);
        }
        int result = 0;
        if (index == array.length) {
            result = rest == 0 ? 1 : 0;
        } else {
            result = process2(array, index + 1, rest - array[index], dp)
                    + process2(array, index + 1, rest + array[index], dp);
        }
        if (!dp.containsKey(index)) {
            dp.put(index, new HashMap<>());
        }
        dp.get(index).put(rest, result);
        return result;
    }

    //背包动态规划？空间压缩

}
