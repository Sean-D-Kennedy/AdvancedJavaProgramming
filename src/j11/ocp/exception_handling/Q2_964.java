package j11.ocp.exception_handling;

public class Q2_964 {
    public static void main(String[] args) throws Exception {
          try{           
              m1();           
              System.out.println("A");        
          } 
          finally{           
              System.out.println("B");        
          }        
          System.out.println("C");
    }
     public static void m1() throws Exception { throw new Exception(); }    
}
