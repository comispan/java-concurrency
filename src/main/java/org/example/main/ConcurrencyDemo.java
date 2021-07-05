package org.example.main;

import org.example.task.CallableTask;
import org.example.task.RunnableTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrencyDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Integer>> list = new ArrayList<>();

        // callable task
        Callable<Integer> callable = new CallableTask(1000);
        // runnable task
        RunnableTask runnableTask = new RunnableTask(999);


        // submit runnable x1
        executor.submit(runnableTask);

        // submit callable x4
        for(int i=0; i< 4; i++){
            Future<Integer> future = executor.submit(callable);
            list.add(future);
        }

        for(Future<Integer> fut : list){
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
