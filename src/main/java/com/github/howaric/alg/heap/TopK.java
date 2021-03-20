package com.github.howaric.alg.heap;

import com.github.howaric.alg.util.Timer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopK {

    //[12,3,24,2,67,2,33]
    //find first 3 large numbers
    public static void main(String[] args) {
        int[] input = new int[]{12, 3, 24, 2, 67, 2, 33};
        Timer.exec("topK", () -> System.out.println(Arrays.toString(topK(input, 1))));
    }

    //time:
    //space:
    private static int[] topK(int[] input, int k) {
        if (input.length <= k) {
            return input;
        }
        int index = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        while (heap.size() < k) {
            heap.add(input[index++]);
        }
        for (int i = index; i < input.length; i++) {
            int a = input[i];
            if (a > heap.peek()) {
                heap.poll();
                heap.add(a);
            }
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }

}
