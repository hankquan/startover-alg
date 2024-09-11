package com.github.howaric.alg.leetcode;

import java.util.StringJoiner;

//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0开头。
public class Leetcode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        print(l1);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        print(l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        print(listNode);
    }

    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode head = null;
        ListNode next = null;

        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int value1 = list1 == null ? 0 : list1.val;
            int value2 = list2 == null ? 0 : list2.val;
            int sum = value1 + value2 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            if (head == null) {
                //first
                head = new ListNode(sum);
                next = head;
            } else {
                //add
                ListNode nextNode = new ListNode(sum);
                next.next = nextNode;
                next = nextNode;
            }
            list1 = list1 == null ? null : list1.next;
            list2 = list2 == null ? null : list2.next;
        }
        return head;
    }

    private static void print(ListNode head) {
        ListNode node = head;
        StringJoiner result = new StringJoiner(",");
        while (node != null) {
            result.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println("[" + result.toString() + "]");
    }
}
