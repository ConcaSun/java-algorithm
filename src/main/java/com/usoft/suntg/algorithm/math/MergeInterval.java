package com.usoft.suntg.algorithm.math;

import java.util.*;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author suntg
 * @date 2018年10月15日09:13:09
 */
public class MergeInterval {

    /**
     *
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultInterval = new ArrayList<Interval>();
        // 先把区间按照起始值从小到大排列
        Collections.sort(intervals, (o1, o2) -> {
            return o1.start - o2.start;
        });

        // 最后结果的每一个区间的左右边界
        int left = intervals.get(0).start;
        int right = intervals.get(0).end;;
        for (int i = 1; i < intervals.size(); i ++) {
            Interval interval = intervals.get(i);
            if (right < interval.start) {
                // 如果当前的起始值大于之前的结束值，区间已经分割，需要把前面那个区间加入到结果集中
                resultInterval.add(new Interval(left, right));
                // 然后在把当前这个区间的起始值和结束值，当做新区间的起始值和结束值进行下一次循环
                left = intervals.get(i).start;
                right = intervals.get(i).end;
            } else {
                // 如果当前区间的起始值小于之前的结束值，区间应该合并，并去两者的结束值中较大的为新的结束值
                right = Integer.max(right, interval.end);
            }
        }
        // 把最后一个加入
        resultInterval.add(new Interval(left, right));
        return resultInterval;
    }

    /**
     * 区间
     */
    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }
        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
