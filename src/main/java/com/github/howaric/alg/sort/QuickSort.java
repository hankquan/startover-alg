package com.github.howaric.alg.sort;

import com.github.howaric.alg.util.ArrayGenerator;

import java.util.Arrays;

//时间复杂度期望：O(N*logN)~O(N2)，期望：O(N*logN)
//额外空间复杂度：O(logN)~O(N)，期望：O(logN)
public class QuickSort {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
        int[] array1 = Arrays.copyOfRange(array, 0, array.length);
        quickSortV1(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = Arrays.copyOfRange(array, 0, array.length);
        quickSortV2(array2);
        System.out.println(Arrays.toString(array2));
        int[] array3 = Arrays.copyOfRange(array, 0, array.length);
        quickSortV3(array3);
        System.out.println(Arrays.toString(array3));

//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < 100000; i++) {
//            int x = 6 + (int) ((10 - 6) * Math.random());
//            hashSet.add(x);
//        }
//        System.out.println(hashSet);
    }

    //<=  |  >
    private static void quickSortV1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        processV1(array, 0, array.length - 1);
    }

    private static void processV1(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int flagLeftRight = NetherlandsFlagProblem.netherlandsFlagLeftRight(array, L, R);
        processV1(array, L, flagLeftRight - 1);
        processV1(array, flagLeftRight + 1, R);
    }

    //<   =   >
    private static void quickSortV2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        processV2(array, 0, array.length - 1);
    }

    private static void processV2(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] leftRightFlags = NetherlandsFlagProblem.netherlandsFlagLeftMidRight(array, L, R);
        int leftFlag = leftRightFlags[0];
        int rightFlag = leftRightFlags[1];
        processV2(array, L, leftFlag - 1);
        processV2(array, rightFlag + 1, R);
    }

    //random sort
    private static void quickSortV3(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        processV3(array, 0, array.length - 1);
    }

    private static void processV3(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(array, R, L + (int) ((R - L + 1) * Math.random()));
        int[] leftRightIndex = netherlandsFlagLeftMidRight(array, L, R);
        int leftIndex = leftRightIndex[0];
        int rightIndex = leftRightIndex[1];
        processV3(array, L, leftIndex - 1);
        processV3(array, rightIndex + 1, R);
    }

    private static int[] netherlandsFlagLeftMidRight(int[] array, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int lt = L - 1;
        int gt = R;
        int index = L;
        while (index < gt) {
            if (array[index] < array[R]) {
                swap(array, index++, ++lt);
            } else if (array[index] > array[R]) {
                swap(array, index, --gt);
            } else {
                index++;
            }
        }
        swap(array, gt, R);
        return new int[]{lt + 1, gt};
    }

    //非递归版本
    private static void quickSortV4(int[] array) {

    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

//一列数，分为左右两部分
//一列数，分为左中右三部分
class NetherlandsFlagProblem {

    public static void main(String[] args) {
        int[] array = ArrayGenerator.randomArray();
        System.out.println(Arrays.toString(array));
        int flag = netherlandsFlagLeftRight(array, 0, array.length - 1);
        int[] flags = netherlandsFlagLeftMidRight(array, 0, array.length - 1);
        System.out.println(Arrays.toString(flags));
        System.out.println(Arrays.toString(array));
    }

    //<=   >
    //最左，最右
    static int netherlandsFlagLeftRight(int[] array, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessFlag = L - 1;
        int index = L;
        while (index < R) {
            if (array[index] <= array[R]) {
                swap(array, index, ++lessFlag);
            }
            index++;
        }
        swap(array, ++lessFlag, R);
        return lessFlag;
    }

    //<  =  >
    //return [leftEQ, rightEQ]
    static int[] netherlandsFlagLeftMidRight(int[] array, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int ltIndex = L - 1;
        int gtIndex = R;
        int point = L;
        while (point < gtIndex) {
            if (array[point] < array[R]) {
                swap(array, point++, ++ltIndex);
            } else if (array[point] > array[R]) {
                swap(array, point, --gtIndex);
            } else {
                point++;
            }
        }
        swap(array, R, gtIndex);
        return new int[]{ltIndex + 1, gtIndex};
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
