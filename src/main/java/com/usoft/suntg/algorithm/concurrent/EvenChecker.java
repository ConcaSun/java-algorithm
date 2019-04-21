package com.usoft.suntg.algorithm.concurrent;

/**
 * Created by ConcaSun on 2019/4/21.
 */
public class EvenChecker implements Runnable {

    private EvenGenerator evenGenerator;
    private final int id;

    public EvenChecker(EvenGenerator evenGenerator, int id) {
        this.evenGenerator = evenGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!evenGenerator.isCanceled()) {
            int even = evenGenerator.next();
            if(even % 2 != 0) {
                System.out.println(even + " is not even.");
                evenGenerator.cancel();
            }
        }
    }
}
