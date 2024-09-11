package com.github.howaric.alg.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer32 {

    public static void main(String[] args) {
        TreeNode l31 = new TreeNode(15);
        TreeNode l32 = new TreeNode(15);
        TreeNode l21 = new TreeNode(9);
        TreeNode l22 = new TreeNode(20);
        l22.left = l31;
        l22.right = l32;
        TreeNode root = new TreeNode(3);
        root.left = l21;
        root.right = l22;
        Offer32 offer32 = new Offer32();
        int[] order1 = offer32.levelOrder1(root);
        System.out.println(Arrays.toString(order1));
    }

    //[3,9,20,null,null,15,7]
    public int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> result = new ArrayList<>();


        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
