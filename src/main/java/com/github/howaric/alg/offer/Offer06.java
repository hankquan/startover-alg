package com.github.howaric.alg.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
