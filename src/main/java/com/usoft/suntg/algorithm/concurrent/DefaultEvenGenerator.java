package com.usoft.suntg.algorithm.concurrent;

import static java.lang.Thread.yield;

/**
 * Created by ConcaSun on 2019/4/21.
 */
public class DefaultEvenGenerator extends EvenGenerator {

    private int currentEvenValue = 0;

    public int next() {
        currentEvenValue ++;
        yield();
        currentEvenValue ++;
        return currentEvenValue;
    }

}
