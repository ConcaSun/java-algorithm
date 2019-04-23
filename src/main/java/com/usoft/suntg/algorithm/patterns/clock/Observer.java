package com.usoft.suntg.algorithm.patterns.clock;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public interface Observer {
    public void update(int hours, int minutes, int seconds);
}
