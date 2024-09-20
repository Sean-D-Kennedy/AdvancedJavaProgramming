package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTypes {
    public static void main(String[] args) {    
        boundMethodReferences();        // bound
        unboundMethodReferences();      // unbound
        constructorMethodReferences();  // constructor
        staticMethodReferences();       // static
    }
    public static void boundMethodReferences(){
        String name = "SEAN";
        // Supplier<T>     
        //      T get() 
        Supplier<String> lower  = name::toLowerCase; // () -> name.toLowerCase()

        // No need to say which instance to call it on - the supplier is bound to name            
        System.out.println(lower.get());//sean
        
    }
    public static void unboundMethodReferences(){
        //   Function<T, R>
        //      R apply(T)
        //          String apply(String)
        Function<String, String> upper = String::toUpperCase; // s -> s.toUpperCase()

        // The function is unbound, so you need to specify which instance to call it on
        System.out.println(upper.apply("sean"));//SEAN
    }
    public static void constructorMethodReferences(){
        //  Function<T, R>
        //      R apply(T)
        //          List<String> apply(Integer)
        //  ArrayList(int initialCapacity)
        Function<Integer, List<String>> newAL = ArrayList::new; // x -> new ArrayList(x)
        List<String> ls1 = newAL.apply(10);  // size 10
        ls1.add("21"); 
        System.out.println(ls1);//[21]
    }
    public static void staticMethodReferences(){
        //  Static method references are considered UNBOUND also. An example static method 
        //  is Collections.sort(List)
        List<Integer> listOfNumbers = Arrays.asList(1,2,7,4,5);
        //  Consumer<T>
        //      void accept(T t)
        //          void accept(List<Integer>>)
        //  NB: Consumer takes one parameter => sort(List) is used, as opposed to sort(List, Comparator)
        Consumer<List<Integer>> sortMR = Collections::sort; // list -> Collections.sort(list)
        sortMR.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);// [1, 2, 4, 5, 7]
        X x = new X();
        x.accept("abc");
       listOfNumbers.forEach(x);
    }    
}
class X implements Consumer{

    @Override
    public void accept(Object arg0) {
        System.out.println("----"+arg0);
    }
    
}





/*
        List<String> names = Arrays.asList("Sean", "Mary", "John");
        names.forEach(name -> System.out.println(name)); // lambda
        names.forEach(System.out::println); // method reference
        
        

*/