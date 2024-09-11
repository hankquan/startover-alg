package com.github.howaric.alg.tree;

import java.util.HashMap;

//实现一个前缀树
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.increasePass();
        for (int i = 0; i < chars.length; i++) {
            int intChar = chars[i];
            HashMap<Integer, TrieNode> children = node.getChildren();
            if (!children.containsKey(intChar)) {
                children.put(intChar, new TrieNode());
            }
            node = children.get(intChar);
            node.increasePass();
        }
        node.increaseEnd();
    }

    public void delete(String word) {
        if (search(word) == 0) {
            return;
        }
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int intChar = chars[i];
            HashMap<Integer, TrieNode> children = node.getChildren();
            node = children.get(intChar);
            node.decreasePass();
            if (node.getPass() == 0) {
                children.remove(intChar);
                return;
            }
        }
        node.decreaseEnd();
    }

    //返回加入的次数
    public int search(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int intChar = chars[i];
            HashMap<Integer, TrieNode> children = node.getChildren();
            if (!children.containsKey(intChar)) {
                return 0;
            }
            node = children.get(intChar);
        }
        return node.getEnd();
    }

    //返回多少个word以prefix为前缀
    public int searchPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return 0;
        }
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int intChar = chars[i];
            HashMap<Integer, TrieNode> children = node.getChildren();
            if (!children.containsKey(intChar)) {
                return 0;
            }
            node = children.get(intChar);
        }
        return node.getPass();
    }

}

class TestMain {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.add("abc");
        trieTree.add("abc");
        trieTree.add("abc");
        trieTree.add("abcd");
        trieTree.delete("abc");
        System.out.println(trieTree.search("abc"));
        System.out.println(trieTree.searchPrefix("abc"));
    }
}

class TrieNode {
    private int pass;
    private int end;
    private HashMap<Integer, TrieNode> children;

    public TrieNode() {
        pass = 0;
        end = 0;
        children = new HashMap<>();
    }

    public int getPass() {
        return pass;
    }

    public int getEnd() {
        return end;
    }

    public HashMap<Integer, TrieNode> getChildren() {
        return children;
    }

    public void increasePass() {
        pass++;
    }

    public void increaseEnd() {
        end++;
    }

    public void decreasePass() {
        pass--;
    }

    public void decreaseEnd() {
        end--;
    }

}
