package j8.concurrency.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAny {
    public static void main(String[] args) {
        // Single Thread Executors will accept tasks sequentially in the order
        // they are submitted
        ExecutorService es = Executors.newSingleThreadExecutor();
        // with 4 threads to share the work, there is no guarantee which letter
        // will appear first
//        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");
        
        try {
            // submitting a collection of tasks
            // executes synchronously and returns when one of the tasks has completed, all
            // other tasks are cancelled
            // Note: Single thread executor will always execute the first task submitted.
            String result = es.invokeAny(callables); // TimeUnit overloaded version exists
            System.out.println(result);
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
