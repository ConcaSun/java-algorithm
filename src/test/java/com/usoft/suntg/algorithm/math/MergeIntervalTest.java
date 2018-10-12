package com.usoft.suntg.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 */
public class MergeIntervalTest {

    public void test() {
        // 初始化
        List<MergeInterval.Interval> intervals = new ArrayList<MergeInterval.Interval>();

        // 处理
        List<MergeInterval.Interval> resultIntervals = MergeInterval.merge(intervals);

        // 输出结果
        for (MergeInterval.Interval interval : resultIntervals) {
            System.out.print(interval);
        }
    }
}
