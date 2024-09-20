package j8.ocp.java_class_design;

import java.util.*; 
class Book {     
    private String isbn;
    public Book(String isbn){ this.isbn = isbn; }          
    @Override
    public boolean equals(Object o){         
        return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
    } 
    // ... setters and getters    
    @Override
    public int hashCode(){return 100;}// every object goes into one BIG bucket
}       
class BookStore {     
    Map<Book, Integer> map = new HashMap<Book, Integer>();
    public BookStore(){         
        Book b = new Book("A111");
        map.put(b, 10);         
        b = new Book("B222");         
        map.put(b, 5);     
    }          
    Integer getNumberOfCopies(Book b){         
        return map.get(b);
    }      
    public static void main(String[] args){         
        BookStore bs = new BookStore();
        Book b = new Book("A111");         
        System.out.println(bs.getNumberOfCopies(b));
    }      
}
public class Q2_1304 {
    
}
