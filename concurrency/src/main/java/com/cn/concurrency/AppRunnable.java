package com.cn.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */

class Runner1 implements Runnable{

    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Runner1 : "+i);
        }
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
    }
    
}

class Runner2 implements Runnable{

    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Runner2 : "+i);
        }
        
    }
    
}
public class AppRunnable 
{
    public static void main( String[] args )
    {
        Thread t1 =  new Thread(new Runner1());
        Thread t2 =  new Thread(new Runner2());
        t1.start();
        t2.start();
    }
}
