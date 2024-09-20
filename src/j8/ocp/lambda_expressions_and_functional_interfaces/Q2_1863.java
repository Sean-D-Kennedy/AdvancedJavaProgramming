package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.Arrays;
import java.util.List;

class SomeBook {    
    private String title;
    private String genre;    
    SomeBook(String title, String genre){         
        this.title = title;
        this.genre = genre;    
    }    
    public String getTitle() {
        return title;
    }
} 
// Solution 1
//interface Reader{ 
//    void read(SomeBook b);    // lambda provides the implementation code
//    default void unread(SomeBook b){} 
//}
// Solution 2
interface Reader{ 
    default void read(SomeBook b){
        System.out.println("default read");
    } 
    void unread(SomeBook b); // lambda provides the implementation code
}
public class Q2_1863 {
    public static void main(String[] args) {
        List<SomeBook> books = Arrays.asList(         
                new SomeBook("Gone with the wind", "Fiction"),         
                new SomeBook("Bourne Ultimatum", "Thriller"),         
                new SomeBook("The Client", "Thriller") );
        
        // this lambda matches the ONE abstract method in the functional interface
        // Solution 1 - this is the "read"
        // Solution 2 - this is the "unread"
        Reader r = b->{     
            System.out.println("Reading book "+b.getTitle());   
        }; 
        // in this Consumer, we are calling the "read" method i.e. for the 2nd solution, we get
        // the default method implementation in the interface i.e. "default read"
        books.forEach(bk->r.read(bk));
    }
    
}
