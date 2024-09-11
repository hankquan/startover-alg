package com.github.howaric.alg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class Leecode22 {

    public static void main(String[] args) {
        List<String> list = new BFS().generateParenthesis(3);
        System.out.println(list);
    }

    public static class DFS1 {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<>();
            doback(result, "", 0, 0, n);
            return result;
        }

        private void doback(List<String> result, String sequence, int open, int close, int n) {
            if (sequence.length() == n * 2) {
                result.add(sequence);
                return;
            }

            if (open < n) {
                doback(result, sequence + "(", open + 1, close, n);
            }

            if (close < open) {
                doback(result, sequence + ")", open, close + 1, n);
            }

        }

    }

    public static class DFS2 {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<>();
            if (n < 1) {
                return result;
            }

            dfs(result, n, n, "");

            return result;
        }

        private void dfs(ArrayList<String> result, int open, int close, String sequence) {
            if (open == 0 && close == 0) {
                result.add(sequence);
                return;
            }

            if (open > close) {
                return;
            }

            if (open > 0) {
                dfs(result, open - 1, close, sequence + "(");
            }

            if (close > 0) {
                dfs(result, open, close - 1, sequence + ")");
            }


        }

    }

    public static class BFS {

        public List<String> generateParenthesis(int n) {
            if (n < 1) {
                return Collections.emptyList();
            }

            ArrayList<String> result = new ArrayList<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node("", n, n));
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left == 0 && node.right == 0) {
                    result.add(node.value);
                    continue;
                }
                if (node.right < node.left) {
                    continue;
                }
                if (node.left > 0) {
                    queue.add(new Node(node.value + "(", node.left - 1, node.right));
                }
                if (node.right > 0) {
                    queue.add(new Node(node.value + ")", node.left, node.right - 1));
                }

            }

            return result;
        }

        static class Node {
            String value;
            int left;
            int right;

            public Node(String value, int left, int right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }

    }

}
