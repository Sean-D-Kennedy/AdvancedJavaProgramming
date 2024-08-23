package j8.concurrency.threading_problems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount{
    private int balance = 50;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int balance) {
        this.balance -= balance;
    }    
}
public class RaceCondition implements Runnable {
    private static Lock lock = new ReentrantLock();
    
    // There is ONLY ONE BankAccount! It is shared between the two threads.
    private BankAccount acct = new BankAccount();
    public static void main(String []args){
        Runnable r = new RaceCondition();   // only 1 instance
        Thread john = new Thread(r);        // BOTH threads share the 1 instance
        Thread mary = new Thread(r);
        john.setName("John");
        mary.setName("Mary");
        john.start();
        mary.start();
    }

    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            makeWithdrawal(10);
            if(acct.getBalance() < 0){
                System.out.println("Account is overdrawn!");
            }
            try{
                Thread.sleep(500);
            }catch (InterruptedException ie){}
        }
    }

    private void makeWithdrawal(int amtToWithdraw){ // Overdrawn version
//    private synchronized void makeWithdrawal(int amtToWithdraw){ // synchronized solution
        if(acct.getBalance() >= amtToWithdraw){
            System.out.println(Thread.currentThread().getName()
                + ". Balance BEFORE: " + acct.getBalance());
            try{
                
                Thread.sleep(500);
            }catch (InterruptedException ie){}
            acct.withdraw(amtToWithdraw);
            System.out.println(Thread.currentThread().getName()
                    + ". Balance AFTER: " + acct.getBalance());
        }else{
            System.out.println(Thread.currentThread().getName() + " is unable to withdraw "
                    + "as balance is: " + acct.getBalance());
        }
    }

//    private void makeWithdrawal(int amtToWithdraw){   // Lock's solution
//        try{
//            lock.lock(); // blocking call; one thread gets in, others wait
//            if(acct.getBalance() >= amtToWithdraw){
//                System.out.println(Thread.currentThread().getName()
//                    + ". Balance BEFORE: " + acct.getBalance());
//                try{
//
//                    Thread.sleep(500);
//                }catch (InterruptedException ie){}
//                acct.withdraw(amtToWithdraw);
//                System.out.println(Thread.currentThread().getName()
//                        + ". Balance AFTER: " + acct.getBalance());
//            }else{
//                System.out.println(Thread.currentThread().getName() + " is unable to withdraw "
//                        + "as balance is: " + acct.getBalance());
//            }
//        } finally{
//            lock.unlock();
//        }
//    }

}
