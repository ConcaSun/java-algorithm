package com.usoft.suntg.algorithm.concurrent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ConcaSun on 2019/5/5.
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i ++) {
            executorService.execute(new Entrance(i));
        }
        Thread.sleep(3000);
        Entrance.cancel();
        executorService.shutdown();
        if (!executorService.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }

    private static class Entrance implements Runnable {
        private static Count count = new Count();
        private static List<Entrance> entrances = new ArrayList<>();
        private static volatile boolean canceled = false;

        private int id;
        private int number;

        public Entrance(int id) {
            this.id = id;
            entrances.add(this);
        }

        public static int getTotalCount() {
            return count.getValue();
        }

        public static int sumEntrances() {
            return entrances.stream().mapToInt(Entrance::getNumber).sum();
        }

        private synchronized int getNumber() {
            return number;
        }

        public static void cancel() {
            canceled = true;
        }

        @Override
        public void run() {
            while (!canceled) {
                synchronized (this) {
                    // 单独的计数器+1
                    ++number;
                }
                // count 计数器+1
                System.out.println(this + " Total: " + count.increment());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Stopping " + this);
        }

        @Override
        public String toString() {
            return "Entrance " + id + ":" + getNumber();
        }
    }

    private static class Count {

        private int count = 0;
        private Random random = new Random(47);

        public int getValue() {
            return count;
        }

        /**
         * 特意将i++的动作进行拆分，并在中间加入yield，增加出现并发情况的几率
         * 这里如果不加入synchronized 就会导致最终的count计数与单独计数的和不一样
         * @return
         */
        public synchronized int increment() {
            int temp = count;
            // 有一半的几率会yield
            if (random.nextBoolean()) {
                Thread.yield();
            }
            count = temp + 1;
            return count;
        }
    }

}

