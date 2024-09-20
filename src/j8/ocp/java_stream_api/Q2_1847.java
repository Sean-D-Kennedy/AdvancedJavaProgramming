package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_1847 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(         
                new Book("Gone with the wind", 10.0),         
                new Book("Gone with the wind", 20.0),         
                new Book("Atlas Shrugged", 15.0) ); 
        
        books.stream()
//                .collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice())) //  IllegalStateException                  
                .collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice(), (v1,v2) -> v1*v2))                         
                .forEach((a, b)->System.out.println(a+" "+b)); 
    }
}
