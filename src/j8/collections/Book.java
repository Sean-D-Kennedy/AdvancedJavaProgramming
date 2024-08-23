package j8.collections;

class Book{     
    private String title;     // implements Comparable
    private Double price;     // implements Comparable
    Book(String title, Double price){         
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public Double getPrice() {   return price;}
    public String toString() { return "\t" + title+ "\t" + price;}
}
