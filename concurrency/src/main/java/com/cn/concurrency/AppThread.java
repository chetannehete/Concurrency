package com.cn.concurrency;

/**
 * Hello world!
 *
 */

class Runner11 extends  Thread{

    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Runner1 : "+i);
        }
        
    }
    
}

class Runner22 extends  Thread{

    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Runner2 : "+i);
        }
        
    }
    
}
public class AppThread 
{
    public static void main( String[] args )
    {
        Runner11 t1 =  new Runner11();
        Runner22 t2 =  new Runner22();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Process has been completed");
    }
}
