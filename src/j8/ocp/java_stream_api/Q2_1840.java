package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.List;

public class Q2_1840 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(11, 12, 22, 33, 33, 55, 66);
        
        // 1. distinct()
//        System.out.println("distinct");
//        ls.stream()
//            .distinct()
//            .forEach(n -> System.out.println(n));  // 11, 22, 33, 55, 66
        // Java only generates the amount of stream you need (lazy evaluation).
//        System.out.println("\nanyMatch");
//        System.out.println(ls.stream()
//                            .distinct()
//                            .peek(System.out::println)
//                            .anyMatch(x -> x==11));// true
        
        System.out.println("\nnoneMatch");
        System.out.println(ls.stream()
                            .peek(System.out::println)
                            .noneMatch(x -> x%11>0));// true
    }
    
}
