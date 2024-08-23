package j8.concurrency.concurrent_collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // regular Queue methods
        queue.offer("Red");                 // head -> [Red] <- tail
        queue.offer("Green");               // head -> [Red, Green] <- tail
        queue.offer("Blue");                // head -> [Red, Green, Blue] <- tail
        System.out.println(queue.poll());   // Red   head -> [Green, Blue] <- tail
        System.out.println(queue.peek());   // Green head -> [Green, Blue] <- tail
        System.out.println(queue);          // [Green, Blue]
        
        // special BlockingQueue methods
        try {
            // block is queue full...
            queue.offer("White", 100, TimeUnit.MILLISECONDS);   // head -> [Green, Blue, White] <- tail
            // block is queue empty...
            queue.poll(200, TimeUnit.MILLISECONDS);             // head -> [Blue, White] <- tail
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(queue);          // [Blue, White]
        
    }
}
