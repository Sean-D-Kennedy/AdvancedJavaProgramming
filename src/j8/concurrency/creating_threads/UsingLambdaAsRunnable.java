package j8.concurrency.creating_threads;

public class UsingLambdaAsRunnable {
    public static void main(String[] args) {
        Thread t = new Thread( () -> System.out.println("run(): "+
                                Thread.currentThread().getName()) );
//        t.start();
        t.run();
        System.out.println("main(): "+Thread.currentThread().getName());
    }    
}

