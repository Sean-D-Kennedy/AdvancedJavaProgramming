package j11.ocp.streams_and_lambda.builtin_functional_interfaces;

import java.util.function.Supplier;

class Book{
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
public class Q2_1814 {
    public static void main(String[] args) {
        Book b1 = new Book("Java in 24 hrs", 30.0); 
        Book b2 = new Book("Thinking in Java", null); 
        Supplier s1a = b1::getPrice; // this also wotks for getTitle => <Object> on LHS 
        Supplier<Object> s1b = b1::getPrice; 
        Supplier<Number> s1c = b1::getPrice; 
        Supplier<Double> s1d = b1::getPrice; 
        Supplier s1e = () -> b1.getPrice(); 
        System.out.println(b1.getTitle()+" "+s1a.get()); 
        Supplier s2 = b2::getPrice; 
//        System.out.println(b2.getTitle()+" "+s2.getAsDouble());
    }
    
}
