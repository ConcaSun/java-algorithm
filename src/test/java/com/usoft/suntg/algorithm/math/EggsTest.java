package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by ConcaSun on 2019/4/24.
 */
public class EggsTest extends TestCase {

    public void test() {
        int maxTimes = new Eggs(4, 1).getMinTimes();
        Assert.assertEquals(maxTimes, 4);
    }

    public void test2() {
        int maxTimes = new Eggs(15, 2).getMinTimes();
        Assert.assertEquals(maxTimes, 5);
    }

    public void test3() {
        int maxTimes = new Eggs(16, 2).getMinTimes();
        Assert.assertEquals(maxTimes, 6);
    }

    public void testBubbleSorting() {
        int floors = 20;
        int eggCounts = 10;
        for (int i = 1; i < floors; i ++) {
            System.out.print(i + " floors\t");
            for (int j = 1; j < eggCounts; j ++) {
                System.out.print(new Eggs(i, j).getMinTimes() + "\t");
            }
            System.out.println();
        }
    }
}
