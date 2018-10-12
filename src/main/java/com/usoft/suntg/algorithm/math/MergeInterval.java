package com.usoft.suntg.algorithm.math;

import java.util.ArrayList;
import java.util.List;

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
 */
public class MergeInterval {

    /**
     *
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultInterval = new ArrayList<Interval>();
        // TODO
        return resultInterval;
    }

    /**
     * 区间
     */
    public class Interval {
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
            return "[" + start + "," + end + "]";
        }
    }
}