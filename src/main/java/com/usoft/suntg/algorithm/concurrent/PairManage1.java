package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/22.
 */
public class PairManage1 extends PairManager {
    @Override
    public void increment() {
        pair.incrementX();
        pair.incrementY();
        store(pair);
    }
}
