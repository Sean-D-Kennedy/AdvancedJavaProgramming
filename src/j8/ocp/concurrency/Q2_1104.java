package j8.ocp.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Q2_1104 {
    
}
class Student {
    private Map<String, Integer> marksObtained = new HashMap<String, Integer>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void setMarksInSubject(String subject, Integer marks){
        lock.writeLock().lock(); //1
        try{
            marksObtained.put(subject, marks);
        }finally{
            lock.writeLock().unlock(); //2
        }
    }
    public double getAverageMarks(){
        lock.readLock().lock(); //3
        double sum = 0.0;
        try{
            for(Integer mark : marksObtained.values()){
                sum = sum + mark;
            }
            return sum/marksObtained.size();
        }finally{
            lock.readLock().unlock();//4
        }
    }
    public static void main(String[] args) {
        
        final Student s = new Student();

        //create one thread that keeps adding marks
        new Thread( () -> { // lambda for run()
                int x = 0;
                while(true){
                    int m = (int)(Math.random()*100);
                    s.setMarksInSubject("Sub "+x, m);
                    x++;
                }
            } // end lambda
        ).start();

       //create 5 threads that get average marks
       for(int i=0;i<5; i++){
            new Thread(){ // anon. inner class
                @Override
                public void run(){
                    while(true){
                        double av = s.getAverageMarks();
                        System.out.println(av);
                    }
                }
            }.start();
        }
    }
   
}