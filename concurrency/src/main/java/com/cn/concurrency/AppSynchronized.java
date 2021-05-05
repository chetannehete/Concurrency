package com.cn.concurrency;

public class AppSynchronized {

    public static int counter = 0;

    public static synchronized void increment() {
        ++counter;
    }

    public static void process() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t1.getStackTrace();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String[] args) {
        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }

}
