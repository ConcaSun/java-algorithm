package com.usoft.suntg.algorithm.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 */
public class MergeIntervalTest {

    @Test
    public void test() {
        // 初始化
        List<MergeInterval.Interval> intervals = new ArrayList<MergeInterval.Interval>();
        intervals.add(new MergeInterval.Interval(1,3));
        intervals.add(new MergeInterval.Interval(2,6));
        intervals.add(new MergeInterval.Interval(8,10));
        intervals.add(new MergeInterval.Interval(15,18));
        intervals.add(new MergeInterval.Interval(4,5));

        // 处理
        List<MergeInterval.Interval> resultIntervals = MergeInterval.merge(intervals);

        // 输出结果
        for (MergeInterval.Interval interval : resultIntervals) {
            System.out.println(interval);
        }
    }
}
