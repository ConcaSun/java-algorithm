package com.usoft.suntg.algorithm.math;

import java.util.Arrays;

/**
 * Created by ConcaSun on 2019/4/24.
 */
public class Sorting {

    /**
     * 冒泡排序
     * 主要思路：相邻的两个比较，如果前面的大于后面的进行交换，一遍就能把最大的放在最后，然后逐步把倒数第二大的放在倒数第二，以此类推...
     * 关键点：相邻的两个数比较，并马上置换
     * @param arr
     * @return
     */
    public static int[] bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr.length -i - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
            System.out.println("i = " + i + ", arr" + Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 快速排序
     * 主要思路：找出排序后当前i应该放的值的index，然后再将两者置换，比如第一个应该放所有数中最小的，第二个应该放除第一个之外的最小的
     * 关键点：找出当前位置应该置换的index，然后进行置换
     * @param arr
     * @return
     */
    public static int[] selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.println("i = " + i + ", arr" + Arrays.toString(arr));
        }

        return arr;
    }

    /**
     * 快速排序
     * @param arr
     * @return
     */
    public static int[] quickSorting(int[] arr) {
        return arr;
    }


    /**
     * 在数组内交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }


}
