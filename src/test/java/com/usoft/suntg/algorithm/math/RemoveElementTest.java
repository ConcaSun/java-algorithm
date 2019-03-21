package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;

/**
 * @author suntg
 * @date ${date}
 */
public class RemoveElementTest extends TestCase {

    public void test1() {
        int[] arr = {3,2,2,3};
        int var = 3;
        assertEquals(2, RemoveElement.removeElement(arr, var));
    }

    public void test2() {
        int[] arr = {0,1,2,2,3,0,4,2};
        int var = 2;
        assertEquals(5, RemoveElement.removeElement(arr, var));
    }
}
