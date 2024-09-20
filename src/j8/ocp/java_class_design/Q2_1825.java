package j8.ocp.java_class_design;

import java.util.ArrayList;
import java.util.List;

class PlaceHolder<K, V> {     
    private K k;
    private V v;     
    PlaceHolder(K k, V v){         
        this.k = k;
        this.v = v;     
    }     
    public K getK() { return k; }     
    public V getV() { return v; }  
    
    public static <X> PlaceHolder<X, X> getDuplicateHolder(X x){         
        return new PlaceHolder<X, X>(x, x);
    }
    // https://stackoverflow.com/questions/2781672/when-is-a-parameterized-method-call-useful
    public static <T> void fillListSafely(T... items){
        List<T> list = new ArrayList<T>();
        for(T t:items){
            list.add(t);
        }
        System.out.println(list);
    }
    public static void main(String[] args) {       
        PlaceHolder<String, String> ph0 = new PlaceHolder<>("a", "b");
        System.out.println(ph0.getK() + " " + ph0.getV()); // a b
        
        PlaceHolder<String, String> ph1 = PlaceHolder.getDuplicateHolder("b");//1
        System.out.println(ph1.getK() + " " + ph1.getV()); // b b
        
        PlaceHolder<Integer, Integer> ph2 = PlaceHolder.<Integer>getDuplicateHolder(3);
        System.out.println(ph2.getK() + " " + ph2.getV()); // 3 3

        PlaceHolder.fillListSafely("11", new Integer(23)); // not safe!
//        PlaceHolder.<String>fillListSafely("11", new Integer(23));
        
//        PlaceHolder<String, String> ph2a = PlaceHolder<String>.getDuplicateHolder("b"); //2       
        PlaceHolder<String, String> ph2a = PlaceHolder.<String>getDuplicateHolder("12"); //2       
//        PlaceHolder<String, String> ph3 = PlaceHolder<>.getDuplicateHolder("b"); //3       
//        PlaceHolder<> ph4 = new PlaceHolder<String, String>("a", "b"); //4       

        // Wildcard ? can only be used for reference declarations (LHS on next few lines)
        // List<?> and List<? extends Object> are identical - can refer to any type of object
        // List<Dog> means <Dog> and nothing else can be put in the list!
        //   List<Object> lo = new ArrayList<String>();
        // List<? extends Dog> means Dog, Terrier etc.. can go in the list
           List<? extends Object> lo = new ArrayList<String>();
           List<?> l = new ArrayList<String>();

        PlaceHolder<?, ?> ph5 = new PlaceHolder(10,10); //5            
        PlaceHolder<?, ?> ph5a = new PlaceHolder<>(10,10); //5            
        PlaceHolder<?, ?> ph5b = new PlaceHolder<>(10, "abc"); //5            
    } 
}
public class Q2_1825 {
    
}







//        PlaceHolder<String, String> ph6      = new PlaceHolder<>("22", "10"); //6 
