package com.github.howaric.alg.leetcode;

public class Leecode278 {


    public int firstBadVersion(int n) {
        while (n > 0) {
            if (isBadVersion(n)) {
                return n;
            }
            n--;
        }
        return 0;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
