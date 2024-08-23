package j8.concurrency.thread_safety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// No duplicated numbers; guaranteed to get to 10.
// However, order is still not guaranteed.
public class AtomicIntegerExample {
    private static AtomicInteger atomicCount = new AtomicInteger(0) ;
    
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++){
            es.submit(() -> System.out.print(atomicCount.incrementAndGet() + " "));
        }
        es.shutdown();
        
    }
}
// 2 5 3 1 4 6 7 8 9 10 