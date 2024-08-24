package j8.streams.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Q2_1846 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(        
                new Book("Atlas Shrugged", 10.0),         
                new Book("Freedom at Midnight", 5.0),         
                new Book("Gone with the wind", 5.0) );
        // API: 
        //   An object that maps keys to values. 
        //   A map cannot contain duplicate keys; each key can map to at most one value.
        Map<String, Double> bookMap = 
                           books.stream()
                                .collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice())); 
        //System.out.println("Map == "+bookMap);
        BiConsumer<String, Double> funcBC = (a, b)->{ //define the lambda (not executing yet)
            if(a.startsWith("A")){
                System.out.println(b);
            } 
        };
        bookMap.forEach(funcBC);// execute lambda;   Map::forEach(BiConsumer) 
        
        // option D
        // using a Set here as opposed to a Map
        Set<Entry<String, Double>> bookSet = bookMap.entrySet();
        Consumer<Map.Entry<String, Double>> funcC = (e)->{ 
            if(e.getKey().startsWith("A")){ 
                System.out.println(e.getValue()); 
            } 
        };
        bookSet.forEach(funcC); // Set::forEach(Consumer)
    }
}
