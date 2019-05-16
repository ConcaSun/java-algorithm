package com.usoft.suntg.algorithm.patterns.clock;

/**
 * 观察者接口
 * Created by ConcaSun on 2019/4/23.
 */
public interface Observer {
    public void update(int hours, int minutes, int seconds);
}
