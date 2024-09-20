package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.Arrays;
import java.util.List;

public class Q2_1866 {
    public static void main(String[] args) {
        List<List<Book>> books = Arrays.asList(         
                Arrays.asList(                 
                        new Book("Windmills of the Gods", 7.0),
                        new Book("Tell me your dreams",9.0) ),         
                Arrays.asList(                 
                        new Book("There is a hippy on the highway", 5.0),
                        new Book("Easy come easy go", 5.0)) );  
        double d = books.stream()         // OUT: Stream<List<Book>>
                .flatMap(bs->bs.stream()) // OUT: Stream<Book>
                // DoubleStream mapToDouble(ToDoubleFunction)
                //  - ToDoubleFunction is a functional interface;
                //     - abstract method: double applyAsDouble(T value)
                //  - DoubleStream is a stream of double primitives
                .mapToDouble(book->book.getPrice())
                .sum();        
        System.out.println(d);// 26.0

//        long l = books.stream()             // OUT: Stream<List<Book>>        
//                .flatMap(bs->bs.stream())   // OUT: Stream<Book>
//                .count();                   // OUT: 4
//        System.out.println(l);// 4
    }
    
}
