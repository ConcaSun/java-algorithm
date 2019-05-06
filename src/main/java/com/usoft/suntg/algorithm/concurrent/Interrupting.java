package com.usoft.suntg.algorithm.concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 几种中断线程的情况
 * Created by ConcaSun on 2019/5/6.
 */
public class Interrupting {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked());
        test(new SynchronizedBlocked());
        Thread.sleep(3000);
        System.out.println("程序用exit(0)退出...");
        System.exit(0);
    }

    private static void test(Runnable runnable) throws InterruptedException {
        Future future = executorService.submit(runnable);
        Thread.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getName());
        // interrupts if running
        future.cancel(true);
        System.out.println("Interrupt send to " + runnable.getClass().getName());
    }


    private static class SleepBlocked implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exiting SleepBlocked run.");
        }
    }

    private static class IOBlocked implements Runnable {
        @Override
        public void run() {
            InputStream in = System.in;
            System.out.println("IOBlocked waiting for read()...");
            try {
                in.read();
            } catch (IOException e) {
                System.out.println("IOBlocked interrupted: " + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
            System.out.println("Exiting IOBlocked run.");
        }
    }

    private static class SynchronizedBlocked implements Runnable {

        public synchronized void f() {
            while (true) {
                Thread.yield();
            }
        }

        public SynchronizedBlocked() {
            new Thread(() -> {
                f();
            }).start();
        }

        @Override
        public void run() {
            System.out.println("SynchronizedBlocked trying to call f().");
            f();
            System.out.println("Exiting SynchronizedBlocked run.");
        }
    }
}
