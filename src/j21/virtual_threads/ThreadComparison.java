package j21.virtual_threads;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadComparison {
    public static void main(String[] args) throws Exception {
        final int NUM_TASKS = 2_000_000, BLOCKING_CALL = 1;
        System.out.println("Starting comparison with " + NUM_TASKS + " tasks each.");

        long startTime = System.currentTimeMillis();

        // OutOfMemoryError, tries to create a platform thread for each task.
//        try (var executor = Executors.newCachedThreadPool()) {

        // 200 platform threads for NUM_TASKS tasks e.g. 10_000 => as we sleep for 1 sec/task, we have 200 tasks/sec throughput => 50 secs approx, slow.
//        try (var executor = Executors.newFixedThreadPool(200)) { // 200 platform threads

            // NUM_TASKS virtual threads e.g. 10_000 virtual threads; => 10_000 tasks/sec approx.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) { // ok
            IntStream.range(0, NUM_TASKS).forEach(i -> {   // forEach(IntConsumer) => void accept(int)
                // Future<T> submit(Callable<T>)
                executor.submit(() -> { // Callable => V call(), exceptions are stored in the returned Future<T> (ignoring)
                    Thread.sleep(Duration.ofSeconds(BLOCKING_CALL)); // simulate a blocking call (e.g. I/O or db operation)
                    return i;
                });
            });
        }  // executor.close() is called implicitly, will only close after all tasks are finished

        long endTime = System.currentTimeMillis();
        System.out.println("Duration: " + (endTime - startTime) + " ms");
    }
}
