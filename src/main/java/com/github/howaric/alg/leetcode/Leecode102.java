package com.github.howaric.alg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 二叉树的层序遍历
public class Leecode102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        findLevel(List.of(root), result);
        return result;
    }

    private List<List<Integer>> levelOrderBRF(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int leveSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < leveSize; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    private void findLevel(List<TreeNode> list, List<List<Integer>> res) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> level = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode != null) {
                result.add(treeNode.val);
                level.add(treeNode.left);
                level.add(treeNode.right);
            }
        }
        if (!result.isEmpty()) {
            res.add(result);
        }
        findLevel(level, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
