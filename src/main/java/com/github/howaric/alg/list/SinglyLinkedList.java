package com.github.howaric.alg.list;

import java.util.Random;

public class SinglyLinkedList {

    private static class LinkedNode {
        int value;
        LinkedNode next;
    }

    public static void main(String[] args) {
        LinkedNode head = null;
        LinkedNode pre = null;
        for (int i = 0; i < 10; i++) {
            if (head == null) {
                head = newNode();
                pre = head;
                continue;
            }
            LinkedNode newNode = newNode();
            pre.next = newNode;
            pre = newNode;
        }
        System.out.println("原链表：");
        printListNode(head);
        System.out.println();
        System.out.println("新链表：");
//        ListNode newLinkedNode = reverse(head);
//        LinkedNode newLinkedNode = recursivelyReverse(head);
        LinkedNode kNode = new LinkedNode();
        kNode.value = 10;
        LinkedNode newLinkedNode = deleteKNode(head, kNode);
        printListNode(newLinkedNode);
    }

    private static void printListNode(LinkedNode linkedNode) {
        if (linkedNode == null) {
            System.out.println("empty");
            return;
        }
        do {
            System.out.print(linkedNode.value + " ");
            linkedNode = linkedNode.next;
        } while (linkedNode != null);
    }

    private static LinkedNode newNode() {
        LinkedNode linkedNode = new LinkedNode();
        linkedNode.value = new Random().nextInt(100);
        return linkedNode;
    }

    //双指针翻转单链表
    /*
    2,4,1,6,5,4
  p c
    p c
              p c
     */
    private static LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode cur = head;
        LinkedNode pre = null;
        while (cur != null) {
            LinkedNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归翻转单链表
    /*
    2,4,1,6,5,4

    5,4
    h
     */
    private static LinkedNode recursivelyReverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode newHead = recursivelyReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //删除链表中指定的元素
    private static LinkedNode deleteKNode(LinkedNode head, LinkedNode kNode) {
        if (kNode == null) {
            return head;
        }

        //get new head
        while (true) {
            if (head.value == kNode.value) {
                head = head.next;
            } else {
                break;
            }
        }

        LinkedNode cur = head;
        LinkedNode pre = null;

        while (cur != null) {
            if (cur.value == kNode.value) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

}
