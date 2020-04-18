package com.usoft.suntg.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 求和类算法
 * Created by ConcaSun on 2020/4/18.
 */
public class CountSums {

    /**
     * leetCode题库No.1 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 解题思路：
     * 1、用一个hashMap，循环数组往Map里面设置，key 为当前value 对应target的补数，value 为下标index，因为要返回的是下标
     * 2、循环过程中如果发现当前的value已经存在Map的key中了，说明这是之前数中的一个补数，返回即可
     * @param arr
     * @param target
     * @return
     */
    public static int[] getTwoIndexFromArray(int[] arr, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i ++) {
            if (hashMap.containsKey(arr[i])) {
                result[0] = hashMap.get(arr[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(target - arr[i], i);
        }
        return result;
    }

}
