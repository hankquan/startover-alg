package com.github.howaric.alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//全排列
//广度优先，深度优先
public class Leecode46 {

    public static void main(String[] args) {
        List<List<Integer>> permute = new Leecode46().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    //广度
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(List.of(nums[i]));
        }
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            if (poll.size() == nums.length) {
                result.add(poll);
                continue;
            }
            //add a number
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (!poll.contains(num)) {
                    List<Integer> list = new ArrayList<>(poll);
                    list.add(num);
                    queue.add(list);
                }
            }
        }
        return result;
    }

    //深度+回溯
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();

        dfs(result, used, path, nums);

        return result;
    }

    private void dfs(List<List<Integer>> result, boolean[] used, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //find a not used value, set used to true, add to path,
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(result, used, path, nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
