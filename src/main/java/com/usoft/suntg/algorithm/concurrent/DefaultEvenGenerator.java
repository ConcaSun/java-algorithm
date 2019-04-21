package com.usoft.suntg.algorithm.concurrent;

import static java.lang.Thread.yield;

/**
 * Created by ConcaSun on 2019/4/21.
 */
public class DefaultEvenGenerator extends EvenGenerator {

    private int currentEvenValue = 0;

    /**
     * 如果加了synnchronized 关键字，方法被加锁，不会同时被多个线程调用，所以一直会是偶数
     * 如果不加，因为i++不是原子性，所以会出现公用资源，出现奇数
     * @return
     */
    public synchronized int next() {
        currentEvenValue ++;
        yield();
        currentEvenValue ++;
        return currentEvenValue;
    }

}
