package j8.concurrency.concurrent_collections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteCollections {
    public static void main(String[] args) {
        List<String> names = new CopyOnWriteArrayList<>();
        names.add("Ann");
        names.add("Brian");
        names.add("Carol");
        
        // API: "The snapshot style iterator method uses a reference 
        //      to the state of the array at the point that the iterator was created. 
        //      This array never changes during the lifetime of the iterator, so 
        //      interference is impossible and the iterator is guaranteed not to throw 
        //      ConcurrentModificationException.". 
        // "Ann"    -> "Ann" is output
        //          -> ["Ann", "Brian", "Carol", "Ann"] created
        // "Brian"  -> "Brian" is output
        //          -> ["Ann", "Brian", "Carol", "Ann", "Brian"] created
        // "Carol"  -> "Carol" is output
        //          -> ["Ann", "Brian", "Carol", "Ann", "Brian", "Carol"] created
        for(String name:names){
            System.out.println(name);
            names.add(name);
        }
        System.out.println(names);// [Ann, Brian, Carol, Ann, Brian, Carol]
        System.out.println("--------------------------------------");

        Set<String> uniqueNames = new CopyOnWriteArraySet<>();
        uniqueNames.add("Ann");
        uniqueNames.add("Brian");
        uniqueNames.add("Carol");
        // "Ann"    -> "Ann" is output
        //          -> ["Ann", "Brian", "Carol"] created
        // "Brian"  -> "Brian" is output
        //          -> ["Ann", "Brian", "Carol"] created
        // "Carol"  -> "Carol" is output
        //          -> ["Ann", "Brian", "Carol"] created
        for(String name:uniqueNames){
            System.out.println(name);
            uniqueNames.add(name);
        }
        System.out.println(uniqueNames);// [Ann, Brian, Carol]
        System.out.println("Size is "+uniqueNames.size());
    }
    
}
