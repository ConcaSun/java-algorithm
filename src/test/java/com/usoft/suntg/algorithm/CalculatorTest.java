package com.usoft.suntg.algorithm;

import com.usoft.suntg.algorithm.patterns.AbstractCalculator;
import com.usoft.suntg.algorithm.patterns.MultiCalculator;
import com.usoft.suntg.algorithm.patterns.PlusCalculator;
import junit.framework.TestCase;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public class CalculatorTest extends TestCase {

    public void testPlus() {
        AbstractCalculator calculator = new PlusCalculator();
        int result = calculator.getResult("2,3", ",");
        assertEquals(5, result);
    }

    public void testMulti() {
        AbstractCalculator calculator = new MultiCalculator();
        int result = calculator.getResult("2,3", ",");
        assertEquals(6, result);
    }
}
