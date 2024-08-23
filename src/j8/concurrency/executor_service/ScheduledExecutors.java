package j8.concurrency.executor_service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutors {
    private static ScheduledExecutorService schedES = Executors.newScheduledThreadPool(10);
    
    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }
    public static void schedule(){
        System.out.println("Start...");
        Future<String> future = schedES.schedule(() -> "A", 2, TimeUnit.SECONDS);
        try {
            System.out.println(future.get()); // block
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }  finally{
            schedES.shutdown();
        }
        System.out.println("Always at the end!");
    }
    public static void scheduleWithFixedDelay(){
        System.out.println("Start...");
        // 300 msecs is the time to wait from when the previous task finishes to starting the next task
        //  => previous task finishes - wait 300msecs - start next task
        final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED=300;
        schedES.scheduleWithFixedDelay(() -> System.out.println("Thread id: "+Thread.currentThread().getId()), 
                                       INITIAL_DELAY, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED, TimeUnit.MILLISECONDS);
       // schedES.shutdown(); // if I shut it down, nothing happens
    }
    public static void scheduleAtFixedRate(){
        System.out.println("Start...");
        // Assuming 500 msecs is the time after the initial delay to wait to start the next task and so forth
        //  => initial task starts at 2000msecs                 = 2000msecs
        //       task 2 starts at 2000msecs + 500 msecs         = 2500msecs
        //       task 3 starts at 2000msecs + (500 msecs * 2)   = 3000msecs
        //       task 4 starts at 2000msecs + (500 msecs * 3)   = 3500msecs and so on...
        final long INITIAL_DELAY = 2000, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK=300;
        schedES.scheduleAtFixedRate(() ->   System.out.println("Thread id: "+Thread.currentThread().getId()), 
                                            INITIAL_DELAY, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK, TimeUnit.MILLISECONDS);
        //schedES.shutdown(); // if I shut it down, nothing happens
    }
}
