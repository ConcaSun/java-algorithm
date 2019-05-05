package com.usoft.suntg.algorithm.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ConcaSun on 2019/5/5.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(3);
            new Thread(new TaskA(countDownLatch)).start();
            new Thread(new TaskB(countDownLatch)).start();
            new Thread(new TaskC(countDownLatch)).start();
            // 任务ABC执行之后都会将计数器减1，减到0时就会执行后面的动作
            countDownLatch.await();
            System.out.println("All tasks executed success.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 因为在static方法中用了，所以这个class也要是static
     */
    public static class TaskA implements Runnable {
        private CountDownLatch countDown;

        public TaskA(CountDownLatch countDownLatch) {
            this.countDown = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Task A executed success.");
                countDown.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class TaskB implements Runnable {
        private CountDownLatch countDown;

        public TaskB(CountDownLatch countDownLatch) {
            this.countDown = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Task B executed success.");
                countDown.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class TaskC implements Runnable {
        private CountDownLatch countDown;

        public TaskC(CountDownLatch countDownLatch) {
            this.countDown = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                System.out.println("Task C executed success.");
                countDown.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
