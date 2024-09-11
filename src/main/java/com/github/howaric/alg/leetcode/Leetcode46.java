package com.github.howaric.alg.leetcode;

import java.util.*;

/**
 * 给定一个不含重复数字的数组nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @see <a href="https://leetcode-cn.com/problems/permutations/">Leetcode46</a>
 */
public class Leetcode46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
//        List<List<Integer>> result = permuteDFS(nums);
        List<List<Integer>> result = permuteBFS(nums);
        System.out.println(result);
    }

    //回溯法
    public static List<List<Integer>> permuteDFS(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, result, 0, path, used);
        return result;
    }

    private static void dfs(int[] nums, ArrayList<List<Integer>> result, int depth, Stack<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (used[index]) {
                continue;
            }
            int value = nums[index];
            path.push(value);
            used[index] = true;
            dfs(nums, result, depth + 1, path, used);
            path.pop();
            used[index] = false;
        }
    }

    public static List<List<Integer>> permuteBFS(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        //queue, add根，然后遍历，add，
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(nums.length));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.isLeaf()) {
                result.add(node.path);
            } else {
                Arrays.stream(nums).filter(value -> !node.path.contains(value))
                        .forEach(value -> queue.offer(new Node(node,value)));
            }
        }
        return result;
    }

    private static class Node {
        int depth;
        int len;
        List<Integer> path;

        public Node(int len) {
            this.depth = 0;
            this.len = len;
            this.path = new ArrayList<>();
        }

        public Node(Node parent, int newValue) {
            this.len = parent.len;
            this.depth = parent.depth + 1;
            this.path = new ArrayList<>(parent.path);
            this.path.add(newValue);
        }

        public boolean isLeaf() {
            return depth == len;
        }

    }

}