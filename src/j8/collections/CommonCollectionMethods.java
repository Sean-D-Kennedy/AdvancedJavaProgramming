package j8.collections;

import java.util.Arrays;
import java.util.Collection;

public class CommonCollectionMethods {
    public static void main(String[] args) {
        // Lists allow duplicates
//        Collection<String> coll = new ArrayList<>();

        // asList() returns an unmodifiable collection
        //  => add() throws an UnsupportedOperationException
        Collection<String> coll = Arrays.asList("Lucy", "April", "Lucy");//immutable
        
        coll.add("Lucy");
        coll.add("April");
        coll.add("Lucy");
        System.out.println(coll);                 // [Lucy, April, Lucy]
        System.out.println(coll.remove("Lucy"));  // true
        System.out.println(coll);                 // [April, Lucy]
        System.out.println(coll.isEmpty());       // false
        System.out.println(coll.size());          // 2
        System.out.println(coll.contains("John"));// false
        System.out.println(coll.contains("Lucy"));// true
        // removeIf(Predicate) and Predicate == boolean test(T t)
        System.out.println(coll.removeIf(s -> s.startsWith("A")));// true
        coll.forEach(name -> System.out.println(name));    // [Lucy]
        coll.clear();
        coll.forEach(System.out::println); // nothing output
        
    }
    
}
