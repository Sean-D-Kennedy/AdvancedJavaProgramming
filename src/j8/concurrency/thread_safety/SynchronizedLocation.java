package j8.concurrency.thread_safety;

class UseCounter { 
    private int x;
    public void incrementA() { // <=> incrementB()
        // non-static blocks lock on an object e.g. 'this'
        synchronized(this){
            x++;
        }
    }
    // non-static methods lock on 'this'
    public synchronized void incrementB() { // <=> incrementA()
        x++;
    }
    
    private static int y;
    public static void decrementA() { 
        // static blocks lock on the class object 
        // Every class is associated with an object of Class type
        // accessible using Classname.class
        synchronized(UseCounter.class){
            y--;
        }
    }
    // static methods lock on the class object
    public static synchronized void decrementB() { 
        y--;
    }
    
}



public class SynchronizedLocation {
    
}
