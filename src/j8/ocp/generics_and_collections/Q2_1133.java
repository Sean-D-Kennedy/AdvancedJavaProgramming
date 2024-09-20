// enthuware.ocpjp.v8.2.1133
package j8.ocp.generics_and_collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2_1133 {
    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();         
        d.push(1);d.push(2);d.push(3);      // F[3,2,1]     
        System.out.println(d);
        d.addFirst(4);                      // F[4,3,2,1]
        System.out.println(d);
        d.offerLast(5);                     // F[4,3,2,1,5]
        System.out.println(d);
        System.out.println(d.pollLast());   // 5 -> F[4,3,2,1]
        System.out.println(d.poll());       // 4 -> F[3,2,1]   
        System.out.println(d.pollFirst());  // 3 -> F[2,1]
        System.out.println(d.pop());        // 2 -> F[1]
        System.out.println(d);
    }
    
}
