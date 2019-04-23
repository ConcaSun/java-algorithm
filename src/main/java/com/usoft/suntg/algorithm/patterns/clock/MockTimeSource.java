package com.usoft.suntg.algorithm.patterns.clock;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public class MockTimeSource extends Subject implements TimeSource {

    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public void setTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        notify();
    }
}
