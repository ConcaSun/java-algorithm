package com.usoft.suntg.algorithm.math;

/**
 * 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/comments/
 * @author suntg
 * @date 2019-3-27 10:16:03
 */
public class ShipPackages {

    /**
     * 无穷大值
     */
    private static final int INF = 0x3f3f3f3f;

    /**
     * 二分法
     * @param weights
     * @param d
     * @return
     */
    public static int shipWithinDays(int[] weights, int d) {
        int max = 0, sum = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        int result = INF;
        int l = max, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (shipEnough(weights, d, mid)) {
                r = mid - 1;
                result = Math.min(result, mid);
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    /**
     * 贪心算法
     * @param weights
     * @param d
     * @return
     */
    public static int shipWithInDaysWithGreed(int[] weights, int d) {
        int max = 0, sum = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        while (max <= sum) {
            if (shipEnough(weights, d, max)) {
                return max;
            }
            max ++;
        }
        return sum;
    }

    private static boolean shipEnough(int[] weights, int day, int shipCapacity) {
        int needDays = 1;
        int weightSum = 0;
        for (int w : weights) {
            if (weightSum + w > shipCapacity) {
                needDays ++;
                if (needDays > day) {
                    return false;
                }
                weightSum = 0;
            }
            weightSum += w;
        }
        return true;
    }
}
