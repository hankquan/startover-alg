package com.github.howaric.alg;

public class TestMain {

    public static void main(String[] args) {
        //删除单链表倒数第k个节点
        //1->2->3->4->null
        //二叉树是不是镜像二叉树


    }

    private static boolean isMirrorTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static void removeLastK(Node head, int k) {
        Node left = head;
        Node right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        Node pre = null;
        while (right != null) {
            pre = left;
            left = left.next;
            right = right.next;
        }
        pre.next = left.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}