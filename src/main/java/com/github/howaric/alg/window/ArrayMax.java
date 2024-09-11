package com.github.howaric.alg.window;

import com.github.howaric.alg.util.ArrayPrinter;

import java.util.LinkedList;

//假设一个固定大小为W的窗口，一次划过arr，返回每一次划出状况的最大值
//如 arr=[43543367], w=3
//output=[555467]
public class ArrayMax {

    public static void main(String[] args) {

        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxArray = findMaxArray(arr, 3);
        ArrayPrinter.print(maxArray);

    }

    private static int[] findMaxArray(int[] array, int w) {
        if (array == null || array.length < 1 || array.length < w) {
            return null;
        }
        int n = array.length;
        int[] res = new int[n - w + 1];
        int resIndex = 0;
        int r = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        //loop r
        while (r < n) {
            //pop smaller index from right
            while (!maxQueue.isEmpty() && array[maxQueue.peekLast()] <= array[r]) {
                maxQueue.pollLast();
            }
            //add to max queue
            maxQueue.addLast(r);
            //pop expired max index
            if (maxQueue.peekFirst() == r - w) {
                maxQueue.pollFirst();
            }
            //collect result
            if (r >= w - 1) {
                res[resIndex++] = array[maxQueue.peekFirst()];
            }
            r++;
        }

        return res;
    }

}
