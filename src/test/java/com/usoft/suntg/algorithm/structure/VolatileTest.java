package com.usoft.suntg.algorithm.structure;

import junit.framework.TestCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ConcaSun on 2019/4/7.
 */
public class VolatileTest extends TestCase {

    public static int inc = 0;
    private static Lock lock = new ReentrantLock();

    public static synchronized void increace() {
        try {
            inc ++;
            int i = 0;
            int j = 6 / i;
        } catch (Exception e) {

        } finally {
        }
    }

    public void test1() {
        VolatileTest volatileTest = new VolatileTest();

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increace();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        assertEquals(100000, inc);
    }

    public void test2() {
        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();
    }

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();
    }



}
