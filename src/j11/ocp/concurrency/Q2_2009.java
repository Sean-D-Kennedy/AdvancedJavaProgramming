package j11.ocp.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class Q2_2009 {
    public static void main(String[] args) {
        var rlock = new ReentrantLock();         
//        var f1 = rlock.lock();
//        System.out.println(f1);
//        var f2 = rlock.lock();
//        System.out.println(f2);
        
        var x = m();
    }
    public static int m(){
        return 0;
    } 
}
