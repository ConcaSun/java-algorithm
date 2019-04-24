package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by ConcaSun on 2019/4/24.
 */
public class SortTest extends TestCase {

    public void testBubbleSorting() {
        int[] arr = new int[]{4, 2, 5, 1, 8, 9, 7, 3, 6};
        System.out.println("开始排序：" + Arrays.toString(arr));
        System.out.println(Arrays.toString(Sorting.bubbleSorting(arr)));
    }

    public void testSelectionSorting() {
        int[] arr = new int[]{4, 2, 5, 1, 8, 9, 7, 3, 6};
        System.out.println("开始排序：" + Arrays.toString(arr));
        System.out.println(Arrays.toString(Sorting.selectionSorting(arr)));
    }
}
