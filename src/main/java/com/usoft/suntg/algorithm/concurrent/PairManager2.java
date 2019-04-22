package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/22.
 */
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            pair.incrementX();;
            pair.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
