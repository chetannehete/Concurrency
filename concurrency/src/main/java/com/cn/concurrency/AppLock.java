/**
 * 
 */
package com.cn.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chetan
 */

class Worker {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void consumer() throws InterruptedException {
        
        lock.lock();
        Thread.sleep(2000);
        System.out.println("inside consumer");
        condition.signal();
        System.out.println("after consumer signal");
        lock.unlock();
    }

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("inside producer");
        condition.await();
        System.out.println("after producer await");
        lock.unlock();
    }

}

public class AppLock {

    public static void main(String[] args) {
        final Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    worker.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {
                    worker.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
