package com.usoft.suntg.algorithm.patterns;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public class MultiCalculator extends AbstractCalculator {
    @Override
    public int calculate(int[] args) {
        int result = 1;
        for (int arg : args) {
            result *= arg;
        }
        return result;
    }
}
