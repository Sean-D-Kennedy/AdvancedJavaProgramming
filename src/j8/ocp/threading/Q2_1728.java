package j8.ocp.threading;

public class Q2_1728 {
     class Runner implements Runnable{         
       @Override
       public void run(){             
           System.out.println("In Run");         
       }     
   }      
   public static void main(String[] args) {        
//       Runner r = new Runner(); // static
       Q2_1728.Runner r = new Q2_1728().new Runner();   // inner       
       Thread t1 = new Thread(r);         
       Thread t2 = new Thread(r);         
       t1.start();       
       t2.start();     
   }    
}




/*
package j8.ocp.threading;

public class Q2_1728 {
     class Runner implements Runnable{         
       @Override
       public void run(){             
           System.out.println("In Run");         
       }     
   }      
   public static void main(String[] args) {         
       Runner r = new Runner();         
       Thread t1 = new Thread(r);         
       Thread t2 = new Thread(r);         
       t1.start();       
       t2.start();     
   }    
   public static void sm(){
       Runner r2 = new Q2_1728.Runner(); // static        
   }
   public void m1(){
       Runner r  = new Runner();         
//       Runner r1 = this.new Runner();
   }
}

*/