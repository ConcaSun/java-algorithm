package com.usoft.suntg.algorithm.math;

import org.junit.Test;

/**
 * CanJumArray test
 * @see CanJumpArray
 * @author suntg
 */
public class CanJumpArrayTest {

    @Test
    public void test() {
        // {2,3,1,1,4} true
        // {3,2,1,0,4} false
        // {3,2,2,0,4} true
        int[] array = {3,3,1,0,4,5};
        System.out.println(CanJumpArray.canJump(array));
    }
}
