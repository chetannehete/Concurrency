package com.cn.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class OfficeBoy implements Callable<String> {

    private String cleaning;
    private int frequency;
    
    
    public OfficeBoy(String cleaning, int frequency) {
        this.cleaning = cleaning;
        this.frequency = frequency;
    }
    

    public String call() throws Exception {
        return  (cleaning +": "+ frequency);
    }
    
}


public class AppCallableFuture {

        
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureWork = new ArrayList<Future<String>>();
         
        for (int i = 0; i <10; i++) {
            Future<String> result =  executorService.submit(new OfficeBoy("floor"+Math.random(), i));
            futureWork.add(result);
        }
        
        System.out.println(futureWork);
        for (Future<String> future : futureWork) {
            System.out.println(": data : "+future.get()+": isDone : "+future.isDone()+" : isCancelled : "+future.isCancelled());
        }
    }

}
