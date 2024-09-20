package j8.ocp.generics_and_collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2_1150 {
    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();         
        d.add(1);       // Front -> [1] <- End   
        d.addFirst(2);  // Front -> [2, 1] <- End
        // Stacks (push(), pop()) add/remove from the *front*.
        d.pop();        // Front -> [1] <- End 
        d.offerFirst(3);// Front -> [3, 1] <- End
        System.out.println(d);
    }
    
}
