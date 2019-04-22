package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/22.
 */
public class PairChecker implements Runnable {

    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }
}
