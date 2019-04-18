package com.usoft.suntg.algorithm.concurrent;

import junit.framework.TestCase;

/**
 * @author suntg
 * @date ${date}
 */
public class ExecutorsUtilTest extends TestCase {

    public void testExecute() {
        try {
            ExecutorsUtil.createDataFile(10, 1000, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
