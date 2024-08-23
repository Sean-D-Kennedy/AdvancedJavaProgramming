package j8.collections.sorting;

public class Product implements Comparable<Product>{
    private Integer id;    

    public Product(Integer id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + '}';
    }
    // equal objects should have the same hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product otherProduct = (Product)obj;
            if(id == otherProduct.id)
                return true;
        }
        return false;
    }
    
    @Override
    public int compareTo(Product product){ // specifies "natural ordering" for Product
        // delegate to Integer which implements Comparable<Integer>
        return id.compareTo(product.id); 
//        return Integer.compare(id, product.id); // another option
//        return id-product.id;// sorts ascending by id
    }
    
}
