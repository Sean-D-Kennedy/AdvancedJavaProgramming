package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2_1762 {
    public static void main(String[] args) {
          List<Item> l = Arrays.asList(                 
                  new Item(1, "Screw"),                 
                  new Item(2, "Nail"),                 
                  new Item(3, "Bolt")         
          );
//          l.stream()          // Option 1
//          .sorted((a, b)->a.getId().compareTo(b.getId()))     
//          .forEach(System.out::print); // Sorted by id. Output: ScrewNailBolt  

//            l.stream()          // Option 2
//            // Stream<Item> sorted(Comparator) 
//            .sorted(Comparator.comparing(a->a.getName())) // sorting by name
////            .map((item)->item.getName()) // mapping to a Stream<String>     
// //         .map(Item::getName) // method reference version     
//            .forEach(System.out::print); // Sorted by name, as we wanted. Output: BoltNailScrew  

//            l.stream()          // Option 3
//            .map((i)->i.getName())    // mapping to a Stream<String> 
//            .forEach(System.out::print); // Not sorted at all. Output: ScrewNailBolt  

            l.stream()          // Option 4
            .map((i)->i.getName())  // mapping to a Stream<String>
            .sorted()               // sort by the String's natural order
            .forEach(System.out::print); // Sorted by name, as we wanted. Output: BoltNailScrew  
    }  
}


