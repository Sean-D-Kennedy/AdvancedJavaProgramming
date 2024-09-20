package j8.ocp.generics_and_collections;

import java.util.Arrays;
import java.util.List;

//class Book{
class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    public Book(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public int compareTo(Book b){
      return this.title.compareTo(b.title); 
    }
}
public class Q2_1875 {
    public static void main(String[] args) {
        List<Book> books = getBooksByAuthor("Ludlum"); 
        books.stream()
             .sorted() // natural order sort
             .forEach(b->System.out.println(b.getTitle()+"; "+b.getIsbn())); //1 
    }
    public static List<Book> getBooksByAuthor(String author){
        List<Book> books = Arrays.asList(new Book("1122", "The Power of Now"), 
                                         new Book("1232", "Mindset"));
        return books;
    }
    
}
