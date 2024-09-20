package j11.ocp.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class Account{     
    private String id; 
    private double balance;      
    private final ReentrantLock lock = new ReentrantLock();          
    public void withdraw(double amt){         
        try{             
            lock.lock();             
            if(balance > amt) balance = balance - amt;         
        }finally{             
            lock.unlock();         
        }     
    } 
}
public class Q2_3362 {
    public static void main(String[] args) {
        Account acc = new Account(); // the one account
        Thread t1 = new Thread( () -> acc.withdraw(10) ); 
        t1.start();
        Thread t2 = new Thread( () -> acc.withdraw(20) ); 
        t2.start();
//        Thread t3 = new Thread( () -> acc.lock = new ReentrantLock() );
//        t3.start();
        
        Account acc2 = new Account(); // different account => different lock
    }
    
}
