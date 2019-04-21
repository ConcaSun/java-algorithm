package com.usoft.suntg.algorithm.concurrent;

import junit.framework.TestCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ConcaSun on 2019/4/21.
 */
public class EvenCheckerTest {

    public static void main(String[] args) {
        System.out.println("Test started...");
        int threadCount = 100;
        EvenGenerator evenGenerator = new DefaultEvenGenerator();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i ++) {
            executorService.execute(new EvenChecker(evenGenerator, i));
        }
        executorService.shutdown();
    }
}
