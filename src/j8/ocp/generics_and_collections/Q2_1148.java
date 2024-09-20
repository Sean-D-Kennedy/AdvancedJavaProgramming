package j8.ocp.generics_and_collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2_1148 {
    public static void main(String[] args) {
          Deque<Integer> d = new ArrayDeque<>();         
          d.push(1);        // F[1]      
          d.offerLast(2);   // F[1,2]
          d.push(3);        // F[3,1,2] 
          d.peekFirst();    // F[3,1,2]
          d.removeLast();   // F[3,1]
          d.pop();          // F[1]
          System.out.println(d);    // [1]
    }
    
}
