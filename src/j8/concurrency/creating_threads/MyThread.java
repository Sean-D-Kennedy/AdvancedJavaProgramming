package j8.concurrency.creating_threads;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("run(): "+getName());
    }
    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("main(): "+Thread.currentThread().getName());
    }
}
