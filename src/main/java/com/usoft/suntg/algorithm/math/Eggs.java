package com.usoft.suntg.algorithm.math;

/**
 * 双蛋问题<br/>
 * 问题描述：有t层楼，n个鸡蛋，鸡蛋是相同的，临界楼层是指从某个楼层之上抛下来，都会碎，但从这个楼层之下抛下来，都不会碎。没有碎的鸡蛋可以重复使用。试假设能找到这个临界楼层需要抛投的最少次数。
 * Created by ConcaSun on 2020/3/21.
 */
public class Eggs {

    private Integer thisEggCounts;
    private Integer thisFloors;

    /**
     * 构造器传入对应的参数
     * @param thisFloors
     * @param thisEggCounts
     */
    public Eggs(int thisFloors, int thisEggCounts) {
        this.thisFloors = thisFloors;
        this.thisEggCounts = thisEggCounts;
    }

    /**
     * 得出结果
     * @return
     */
    public int getMinTimes() {
        return getMinTimes(this.thisFloors, this.thisEggCounts);
    }

    /**
     * 算出t层n个蛋需要的最小次数<br/>
     * 算法：如果只有一个鸡蛋，只能乖乖的一层一层楼往下扔，所以最差情况需要n次；如果有两个及以上各鸡蛋，我可以找出
     * @param floors
     * @param eggCounts
     * @return
     */
    private int getMinTimes(int floors, int eggCounts) {
        int minTimes = floors;
        if (eggCounts > 1) {
            for (int throwsAt = 1; throwsAt <= floors; throwsAt++) {
                int maxTimesWhenThrowsAtI = getMaxTimesWhenThrowsAt(floors, eggCounts, throwsAt);
                minTimes = Math.min(minTimes, maxTimesWhenThrowsAtI);
            }
        }
        return minTimes;
    }

    /**
     * 算出t层n个鸡蛋，第一在第k层楼往下丢时的最大次数
     * @param floors
     * @param eggCounts
     * @param throwsAt
     * @return
     */
    private int getMaxTimesWhenThrowsAt(int floors, int eggCounts, int throwsAt) {
        int ifBreak = getMinTimes(throwsAt - 1, eggCounts - 1);
        int ifNotBreak = getMinTimes(floors - throwsAt, eggCounts);
        return Math.max(ifBreak, ifNotBreak) + 1;
    }

}
