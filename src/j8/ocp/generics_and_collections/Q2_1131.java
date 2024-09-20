package j8.ocp.generics_and_collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author skennedy
 */
public class Q2_1131 {
    public static void main(String[] args) {
         Deque<Integer> d = new ArrayDeque<>();         
         d.push(1);                         // F[1]      
         d.push(2);                         // F[2,1]
         d.push(3);                         // F[3,2,1]
         System.out.println(d.remove());    // 3 -> F[2,1] 
         System.out.println(d.remove());    // 2 -> F[1]
         System.out.println(d.remove());    // 1 -> []
         System.out.println(d);
    }
    
}
