package j8.concurrency.thread_safety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void blockingVersion(){
        Lock lock = new ReentrantLock();
        try{
            lock.lock(); // blocking call
            // critical section
        } finally{
            lock.unlock();// return the lock
        }
    }
    public static void nonBlockingVersion(){
        Lock lock = new ReentrantLock();
        // non-blocking call i.e. returns immediately:
        //    true : have the lock
        //    false: could not get the lock 
        if(lock.tryLock()){
            try{
                // do not get the lock a second time as you must then
                // unlock it twice
//                lock.lock(); // blocking call
                // critical section
            } finally{
                lock.unlock();// return the lock
            }
        }else{
            // did not get the lock, do something else 
        }
    }
    public static void main(String[] args) {
    }
}
