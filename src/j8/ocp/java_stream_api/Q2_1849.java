package j8.ocp.java_stream_api;

import java.util.Optional;

public class Q2_1849 {
    public static void main(String[] args) {
        // Q asked on YT:
//        Optional<Double> price = Optional.ofNullable(null); // null passed in
//        System.out.println(price); // Optional.empty
//        Double x = price.orElse(null);
//        System.out.println(x); // null
//        Double x2 = price.orElseGet(()->null);// Supplier
//        System.out.println(x2); // null
        
        
        // ofNullable explained:
        //      Optional o = Optional.ofNullable(value)
        //          is the same as:
        //      Optional o = (value == null) ? Optional.empty() : Optional.of(value)
//        Optional<Double> price = Optional.ofNullable(20.0);
//        price.ifPresent(System.out::println);// 20.0
//        Double x = price.orElse(22.0);
//        System.out.println(x);// 20.0
//        Double x2 = price.orElseGet(()->33.0);// Supplier
//        System.out.println(x);// 20.0

//        Optional<Double> price = Optional.ofNullable(null); // null passed in
//        System.out.println(price); // Optional.empty
//        if (price.isEmpty()){
//            System.out.println("empty");// "empty"
//        }
//        price.ifPresent(System.out::println);// nothing
//        Double x = price.orElse(44.0);
//        System.out.println(x);// 44.0
        
        // Option 1 generates a java.lang.NullPointerException; use ofNullable
//        Optional<Double> price = Optional.of(null);
        
        // Option 4 does not compile - Optional.of(T t) takes one argument
//        Optional<Double> price = Optional.of(21.1, 10.0);

        // Option 5
//        Optional<Double> price = Optional.of(null); //  java.lang.NullPointerException
//        Optional<Double> price = Optional.ofNullable(null); 
        // Note: no "throw" in Supplier in next statement
//        Double z = 
//          price.orElseThrow(()->new RuntimeException("Bad Code"));//java.lang.RuntimeException: Bad Code
//        System.out.println(z);
    }
    
}
