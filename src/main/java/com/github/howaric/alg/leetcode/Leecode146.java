package com.github.howaric.alg.leetcode;

import java.util.HashMap;

//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//实现 LRUCache 类：
//LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value)
// 如果关键字key 已经存在，则变更其数据值value ；
// 如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
//函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
public class Leecode146 {

    public static void main(String[] args) {
//
//["LRUCache","put","put","put","put","get","get"]
//[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

//        [null,null,null,null,null,-1,-1]
        //[null,null,null,null,null,-1,3]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    static class LRUCache {

        private int capacity;
        private int size;
        private Node head;
        private Node tail;
        private HashMap<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.previous = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                //move node to last
                moveToLast(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                //存过
                map.get(key).value = value;
                moveToLast(map.get(key));
            }else {
                Node node = new Node(key, value);
                map.put(key, node);
                //add node to last
                addToLast(node);
                size++;
            }
            //remove useless nodes
            removeNodes();
        }

        private void moveToLast(Node node) {
            if (node.next == tail) {
                return;
            }
            //remove current relation
            node.next.previous = node.previous;
            node.previous.next = node.next;
            //add to Last
            addToLast(node);
        }

        private void addToLast(Node node) {
            tail.previous.next = node;
            node.previous = tail.previous;
            tail.previous = node;
            node.next = tail;
        }

        private void removeNodes() {
            //from head
            while (size > capacity) {
                map.remove(head.next.key);
                deleteFirst();
                size--;
            }
        }

        private void deleteFirst() {
            head.next.next.previous = head;
            head.next = head.next.next;
        }

        static class Node {
            int key;
            int value;
            Node previous;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    }
}
