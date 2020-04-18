package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ConcaSun on 2019/4/24.
 */
public class MiddleNumbersTest extends TestCase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void test() {
        int[] arr1 = {3};
        int[] arr2 = {1,2,4};
        logger.info("result: " + MiddleNumbers.fromTwoSortedArray(arr1, arr2));
    }
}
