package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class AnotherBook{     
    private String title;     // implements Comparable
    private Double price;     // implements Comparable
    AnotherBook(String title, Double price){         
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public Double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}
}

public class ComparatorComparingExplained {
    public static void main(String[] args) {
        AnotherBook b1 = new AnotherBook("Java ", 5.0); 
        AnotherBook b2 = new AnotherBook("Text", 3.0);
        AnotherBook b3 = new AnotherBook("Alpha", 9.0);
        
        List<AnotherBook> books = new ArrayList<>();
        books.add(b1);books.add(b2);books.add(b3);
        books.forEach(System.out::println); // Java, Text, Alpha

        // Function<T, R>     R apply(T t)
        // String apply(AnotherBook)
        Function<AnotherBook, String> function = AnotherBook::getTitle; 
        
// API: 
// static <T,U extends Comparable<? super U>> 
//        Comparator<T> 
//        comparing(Function<? super T,? extends U> keyExtractor)
        Collections.sort(books, 
//                Comparator.comparing((AnotherBook b) -> b.getTitle())); // lambda syntax
//                Comparator.comparing(AnotherBook::getTitle));   // method reference syntax
                Comparator.comparing(function));   // method reference syntax
        books.forEach(System.out::println); // Alpha, Java, Text
        
        // Function<T,U>
        //   U apply(T)   == T is AnotherBook and U is String
        //   (AnotherBook b) -> b.getTitle()
        
        Comparator<AnotherBook> ct = Comparator.comparing(AnotherBook::getTitle);
    }
}
//  static <AnotherBook, String extends Comparable<? super String>>
//          Comparator<AnotherBook>
//          comparing(Function<? super AnotherBook,? extends String> keyExtractor)
