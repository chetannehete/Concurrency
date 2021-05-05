/**
 * 
 */
package com.cn.concurrency;

/**
 * @author chetan
 */

abstract class VolatileObject implements Runnable {
    protected String parentString = "Kon Bola mujse na ho payega";
    abstract String getData();
}

class Worker1 extends VolatileObject {

    private volatile boolean isTerminated = false;   

    public void run() {

        while (!isTerminated) {
            System.out.println("Hello From wroker Class...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(super.parentString);
            System.out.println(getData());
        }

    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean isTerminated) {
        this.isTerminated = isTerminated;
    }

    @Override
    String getData() {
        return "ae Ganpat";
    }

}

public class AppVolatile {

    public static void main(String[] args) {
        Worker1 worker = new Worker1();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Finished work...");
    }

}
