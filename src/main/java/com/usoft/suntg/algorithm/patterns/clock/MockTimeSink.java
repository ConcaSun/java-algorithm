package com.usoft.suntg.algorithm.patterns.clock;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public class MockTimeSink implements Observer {

    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public void update(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
