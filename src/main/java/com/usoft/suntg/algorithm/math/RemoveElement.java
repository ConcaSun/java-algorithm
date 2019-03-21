package com.usoft.suntg.algorithm.math;

/**
 * @author suntg
 * @date ${date}
 */
public class RemoveElement {

    public static int removeElement(int[] arr, int var) {
        int index = 0;
        for (int a : arr) {
            if (a != var) {
                arr[index ++] = a;
            }
        }
        return index;
    }
}
