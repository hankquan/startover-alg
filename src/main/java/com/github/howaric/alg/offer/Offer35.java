package com.github.howaric.alg.offer;

import java.util.HashMap;

//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
public class Offer35 {

    public Node copyRandomList(Node head) {
        //old->new
        HashMap<Node, Node> map = new HashMap<>();
        doCopy(head, map);
        return map.get(head);
    }

    private Node doCopy(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            newNode.next = doCopy(node.next, map);
            newNode.random = doCopy(node.random, map);
        }
        return map.get(node);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
