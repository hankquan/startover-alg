package com.github.howaric.alg.offer;

public class Offer24 {

    public ListNode reverseList(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = next;
        }
        return p1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
