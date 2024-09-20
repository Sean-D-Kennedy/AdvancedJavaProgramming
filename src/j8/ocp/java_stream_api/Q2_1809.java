package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.List;

public class Q2_1809 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book("Thinking in Java", 30.0),  
                                         new Book("Java in 24 hrs", 20.0),   
                                         new Book("Java Recipies", 10.0)); 
        double averagePrice = books.stream()
                .filter(book->book.getPrice()>10)    
                // DoubleStream mapToDouble(ToDoubleFunction)
                //   ToDoubleFunction is a functional interface:
                //      double applyAsDouble(T value)
                .mapToDouble(book->book.getPrice())     
                // OptionalDouble average()  - terminal operation
                .average()
//                .getAsDouble(); 
                .orElse(0.0); // useful if filter filters out ALL of the Books
        System.out.println(averagePrice);       
    }
    
}
