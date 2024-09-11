package com.github.howaric.alg.leetcode;

public class Leecode21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode result = null;
        ListNode current = null;
        while (l1 != null || l2 != null) {
            int val;
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                val = l2.val;
                l2 = l2.next;
            } else {
                //l1
                val = l1.val;
                l1 = l1.next;
            }
            if (result == null) {
                result = new ListNode(val);
                current = result;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
