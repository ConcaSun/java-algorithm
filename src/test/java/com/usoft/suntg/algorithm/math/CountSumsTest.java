package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ConcaSun on 2019/4/24.
 */
public class CountSumsTest extends TestCase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] twoIndexFromArray = CountSums.getTwoIndexFromArray(arr, 10);
        logger.info("result: {}", twoIndexFromArray);
    }
}
