package j8.concurrency.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VariousTypes {
    public static void main(String[] args) {
        // CachedThreadPool
        ExecutorService es  = Executors.newCachedThreadPool();
        
        // FixedThreadPool
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);

        // SingleThreadExecutor
        ExecutorService es3 = Executors.newSingleThreadExecutor();
    }
    
}



