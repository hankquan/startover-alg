package com.github.howaric.alg;

import java.util.ArrayList;
import java.util.List;

public class BiTree {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(2, null, null);
        TreeNode right1 = new TreeNode(3, null, null);
        TreeNode treeNode = new TreeNode(1, left1, right1);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        process(result, root);
        return result;
    }

    public static void process(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        process(result, root.left);
        process(result, root.right);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
