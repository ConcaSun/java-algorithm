package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/21.
 */
public abstract class EvenGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}
