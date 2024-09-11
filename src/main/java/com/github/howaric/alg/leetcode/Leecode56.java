package com.github.howaric.alg.leetcode;

import com.github.howaric.alg.util.ArrayPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
public class Leecode56 {

    public static void main(String[] args) {
        int[][] input = {{3, 3}, {2, 6}, {8, 10}, {15, 18}};
        Leecode56 leecode56 = new Leecode56();
        int[][] merge = leecode56.merge(input);
        ArrayPrinter.print(merge);

    }

    public int[][] merge(int[][] intervals) {
        List<int[]> input = new ArrayList<>(Arrays.asList(intervals));
        input.sort(Comparator.comparingInt(o -> o[0]));
        int L = input.get(0)[0];
        int R = input.get(0)[1];
        List<Integer[]> result = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            int left = input.get(i)[0];
            int right = input.get(i)[1];
            if (left > R) {
                //add L and R to res
                Integer[] element = {L, R};
                result.add(element);
                L = left;
                R = right;
            } else {
                R = Math.max(R, right);
            }
        }
        result.add(new Integer[]{L, R});
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }

}
