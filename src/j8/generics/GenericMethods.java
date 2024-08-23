package j8.generics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GenericMethods {

    public static <T> void genericMethod(T t){
        MyGeneric<T> myGen = new MyGeneric<>(t);
        System.out.println(myGen.getT()); 
    }
    public static <T, U, V> void register(T t, U u, V v){
        Register<T, U, V> register = new Register<>(t, u, v);
        System.out.println("Register: "+register.getName()+"; "+register.getAge()); 
    }
    public static <T> MyGeneric<T> createGeneric(T t){
        return new MyGeneric<>(t);
    }
    
    public static void main(String[] args) {
//        genericMethod("SK");    // SK
//        genericMethod(1.1);     // 1.1
//        
//        register(new Dog(), "Shep", 3);     // Register: Shep; 3
//        register(new Cat(), "Whiskers", 2); // Register: Whiskers; 2
//        
//        MyGeneric<Integer> myGenI = createGeneric(4);
//        System.out.println(myGenI.getT());  // 4

            test();
    }
    public static void test(){
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> iterator = numbers.iterator(); // immutable

        numbers.add(10);

        List<Integer> result = new LinkedList<>();
//        iterator.forEachRemaining(result::add);
        iterator.forEachRemaining(integer -> { result.add(integer);});
        System.out.println(result);// [1, 3, 5, 8]
    }
}


