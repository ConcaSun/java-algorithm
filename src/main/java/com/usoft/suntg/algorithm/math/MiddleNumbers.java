package com.usoft.suntg.algorithm.math;

/**
 * 从两个有序数组中查找中位数，时间复杂度O(Log(m+n))，leetcode No.4<br/>
 * Created by ConcaSun on 2020/4/17.
 */
public class MiddleNumbers {

    public static double fromTwoSortedArray(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int index1 = (length1 + length2 + 1) / 2;
        int index2 = (length1 + length2 + 2) / 2;
        int left = getByIndexFromTwoArray(arr1, 0, arr2, 0, index1);
        int right = getByIndexFromTwoArray(arr1, 0, arr2, 0, index2);
        return (left + right ) / 2.0;
    }

    public static int getByIndexFromTwoArray(int[] arr1, int startIndex1, int[] arr2, int startIndex2, int index) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        if (length1 - 1 < startIndex1) {
            return arr2[startIndex2 + index - 1];
        }

        if (length2 - 1 < startIndex2) {
            return arr1[startIndex1 + index - 1];
        }

        if (index == 1) {
            return Math.min(arr1[startIndex1], arr2[startIndex2]);
        }

        int index2 = index / 2;
        int middleValue1 = startIndex1 + index2 - 1 < length1 ? arr1[startIndex1 + index2 - 1] : Integer.MAX_VALUE;
        int middleValue2 = startIndex2 + index2 - 1 < length2 ? arr2[startIndex2 + index2 - 1] : Integer.MAX_VALUE;
        if (middleValue1 < middleValue2) {
            return getByIndexFromTwoArray(arr1, startIndex1 + index2, arr2, startIndex2, index - index2);
        } else {
            return getByIndexFromTwoArray(arr1, startIndex1, arr2, startIndex2 + index2, index - index2);
        }

    }

}
