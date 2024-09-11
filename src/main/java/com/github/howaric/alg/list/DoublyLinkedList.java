package com.github.howaric.alg.list;

import java.util.Random;

public class DoublyLinkedList {

    private static class LinkedNode {
        int value;
        LinkedNode pre;
        LinkedNode next;
    }

    public static void main(String[] args) {
        //init doubly linked list
        int size = 10;
        LinkedNode head = null;
        LinkedNode pre = null;
        LinkedNode tail = null;
        for (int i = 0; i < size; i++) {
            if (head == null) {
                head = newNode();
                head.pre = null;
                head.next = null;
                pre = head;
                tail = pre;
                continue;
            }
            LinkedNode newNode = newNode();
            newNode.pre = pre;
            pre.next = newNode;
            newNode.next = null;
            pre = newNode;
            tail = pre;
        }
        System.out.println("原链表：");
        printDoublyLinkedNode(head);
        //reverse
        System.out.println();
        LinkedNode reversedHead = reverse(head);
        System.out.println("新链表：");
        printDoublyLinkedNode(reversedHead);
    }

    private static LinkedNode newNode() {
        LinkedNode node = new LinkedNode();
        node.value = new Random().nextInt(100);
        return node;
    }

    private static void printDoublyLinkedNode(LinkedNode head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        do {
            System.out.print(head.value + " ");
            head = head.next;
        } while (head != null);
    }

    //翻转双向链表
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
            cur.pre = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
