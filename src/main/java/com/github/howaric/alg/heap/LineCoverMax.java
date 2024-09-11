package com.github.howaric.alg.heap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.PriorityQueue;

//最大线段重合数问题
//贪心？
//O(N*logN)
/*
给定很多线段，每个线段都有两个数[start, end]，
表示线段开始位置和结束位置，左右都是闭区间
规定：
1）线段的开始和结束位置一定都是整数值
2）线段重合区域的长度必须>=1
返回线段最多重合区域中，包含了几条线段
 */
public class LineCoverMax {

    public static void main(String[] args) {
        Line line0 = new Line(0, 2);
        Line line1 = new Line(1, 5);
        Line line2 = new Line(1, 3);
        Line line4 = new Line(1, 2);
        Line line3 = new Line(2, 6);
        Line[] input = new Line[]{line0, line1, line4, line2, line3};
        int result = calculate(input);
        System.out.println("重合线段数：" + result);
    }

    private static int calculate(Line[] input) {
        Arrays.sort(input);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            Line line = input[i];
            while (!heap.isEmpty() && heap.peek() <= line.start) {
                heap.poll();
            }
            heap.add(line.end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

}

@Data
@AllArgsConstructor
class Line implements Comparable<Line> {
    int start;
    int end;

    @Override
    public int compareTo(Line o) {
        return this.start - o.getStart();
    }
}