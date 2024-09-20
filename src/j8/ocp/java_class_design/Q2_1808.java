package j8.ocp.java_class_design;

// Q2_1304 has a Book class as well so commenting out here for the moment...

//package ocp.java_class_design;
//
//class Book{
//    private String isbn, title;
//
//    public Book(String isbn, String title) {
//        this.isbn = isbn;
//        this.title = title;
//    }
////    @Override
////    public boolean equals(Object o) throws Exception{
////        return true; 
////    }
//
//    //@Override
////    public boolean equals(Book o) {   // never invoked unless b1 and b2
////        return true;                  // are of type Book
////    }
//
////    @Override
////    public int equals(Book b){          // as above (never invoked)
////        return b.isbn.compareTo(this.isbn); 
////    }
//    
//    @Override
//    public boolean equals(Object b) 
//            throws NullPointerException{ // NullPointerException IS-A RuntimeException
//        return true; 
//    }
//}
//
//public class Q2_1808 {
//    public static void main(String[] args) {
//        Object b1 = new Book("1111", "Thinking in Java");
//        Object b2 = new Book("1111", "Java in 24 hours");
//        System.out.println(b1.equals(b2));
//    }    
//}
