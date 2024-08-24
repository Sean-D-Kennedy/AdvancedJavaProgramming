package j8.streams.assignment;

// Why Optionals:
// https://www.oracle.com/technical-resources/articles/java/java8-optional.html

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Q2_2023 {
    public static void main(String[] args) {
        // range() versus rangeClosed()
        IntStream is1 = IntStream.range(0,5);       //0..4
        //is1.forEach(System.out::println);           // forEach is a terminal operation
        IntStream is2 = IntStream.rangeClosed(0,5); //0..5
        //is2.forEach(System.out::println); 

        // This is why it returns OptionalDouble and not double
        OptionalDouble avg    = IntStream.range(0,0).average();
        System.out.println(avg);// OptionalDouble.empty
        
        IntStream is3  = IntStream.range(0, 0);    // 0,1,2,3,4 = 5 numbers
        double avg2    = is3.average().orElse(0);  // 0+1+2+3+4 = 10/5 = 2.0
        System.out.println(avg2);
    }            
}
