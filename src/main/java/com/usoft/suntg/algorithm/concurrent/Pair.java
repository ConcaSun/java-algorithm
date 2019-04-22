package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/22.
 */
public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x ++;
    }

    public void incrementY() {
        y ++;
    }

    @Override
    public String toString() {
        return "x: " + x + ",y: " + y;
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualsException();
        }
    }

    public class PairValueNotEqualsException extends RuntimeException {
        public PairValueNotEqualsException() {
            super("Pair values not equals: " + Pair.this);
        }
    }
}
