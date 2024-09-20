package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleSupplier;
// enthuware.ocpjp.v8.2.1813
class Book{     
    private String title;     
    private Double price;     
    Book(String title, Double price){         
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public Double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}
}
public class Q2_1813{
    public static void main(String[] args) {
       Book b = new Book("Java in 24 hrs", null); 
        // DoubleSupplier is a Functional interface (one abstract method):
        //     double getAsDouble()
        DoubleSupplier dsLE = () -> b.getPrice();// lambda syntax
        // Next line does not compile because : which price are we using?
        // Need to bind to a particular object reference
//        DoubleSupplier dsMR = Book::getPrice;       
        DoubleSupplier dsMR = b::getPrice;       // method reference syntax
        System.out.println(b.getTitle());
        System.out.println(b.getPrice()); 
        System.out.println(dsMR.getAsDouble());   // NullPointerException

    }
}