package com.github.howaric.alg.exercise;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

//给定一个文件目录的路径,写一个函数统计这个目录下所有的文件数并返回
public class Problem2 {

    public static void main(String[] args) {
        String directory = "/Users/howaric/coding/github/howaric-home/blog/docs";
        System.out.println("result: " + countDirectory(directory));
    }

    //广度
    private static int countDirectory(String directory) {
        File root = new File(directory);
        if (root.isFile()) {
            return 1;
        }
        int count = 0;
        Queue<File> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            File pop = queue.poll();
            File[] childList = pop.listFiles();
            if (childList == null) {
                continue;
            }
            for (File child : childList) {
                if (child.isDirectory()) {
                    queue.add(child);
                } else {
                    count++;
                }
            }
        }
        return count;
    }

}
