package com.github.howaric.alg.util;

public class Timer {

    public static void exec(String name, Runnable task) {
        System.out.println("=====================");
        System.out.println("Name: " + name);
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        System.out.println("Cost: " + (end - start) + " ms");
    }

}
