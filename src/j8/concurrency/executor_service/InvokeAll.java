package j8.concurrency.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {
    public static void main(String[] args) {
        // Single Thread Executors will accept tasks sequentially in the order
        // they are submitted
//        ExecutorService es = Executors.newSingleThreadExecutor();
        // with 4 threads to share the work, there is no guarantee which letter
        // will appear first
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");
        
        try {
            // submitting a collection of tasks
            // executes synchronously and returns when all of the tasks are completed
            // order is maintained i.e. the result for callables.get(0) goes into list.get(0)
            List<Future<String>> list = es.invokeAll(callables); // TimeUnit overloaded version exists
            for(Future<String> future:list){
                System.out.println(future.get());// A, B, C, D in order
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        } finally{
            // don't forget to shutdown the executor
            // finally always executes
            es.shutdown();;
        }
        System.out.println("Always at the end!");

    }
    
}
