package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;

/**
 * @author suntg
 * @date ${date}
 */
public class ShipPackagesTest extends TestCase {

    public void test1() {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        assertEquals(15, ShipPackages.shipWithinDays(weights, d));
    }

    public void test2() {
        int[] weights = {3,2,2,4,1,4};
        int d = 3;
        assertEquals(6, ShipPackages.shipWithinDays(weights, d));
    }

    public void test3() {
        int[] weights = {1,2,3,1,1};
        int d = 4;
        assertEquals(3, ShipPackages.shipWithinDays(weights, d));
    }

    public void testGreed1() {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        assertEquals(15, ShipPackages.shipWithInDaysWithGreed(weights, d));
    }

    public void testGreed2() {
        int[] weights = {3,2,2,4,1,4};
        int d = 3;
        assertEquals(6, ShipPackages.shipWithInDaysWithGreed(weights, d));
    }

    public void testGreed3() {
        int[] weights = {1,2,3,1,1};
        int d = 4;
        assertEquals(3, ShipPackages.shipWithInDaysWithGreed(weights, d));
    }
}
