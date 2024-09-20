package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Q2_1784 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2, 4, 6, 9); //1 
        Predicate<Integer> check = (Integer i) -> {     
            return i == 4;//2 
        }; 
//        Predicate even = (Integer i)-> i%2==0;  //3 
//        Predicate<Object> even = (Integer i)-> i%2==0;  //3 
//        Predicate<Integer> even = (Integer i)-> i%2==0;  //3 

        Predicate even = (Object o)-> ((Integer)o)%2==0;  //3 
        values.stream()
                .filter(check)
              //  .peek(System.out::println)//4
                .filter(even)
                .peek(System.out::println)//4
                .count(); //4
    }
    
}
