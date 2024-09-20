package j8.ocp.generics_and_collections;

import java.util.HashSet;
import java.util.Set;

enum SIZE{
    TALL, GRANDE, JUMBO;
}
class CoffeeMug{
    public static void main(String[] args) {
        Set<SIZE> set = new HashSet<>();
        set.add(SIZE.TALL);set.add(SIZE.JUMBO);set.add(SIZE.GRANDE);
        set.add(SIZE.TALL);set.add(SIZE.TALL);set.add(SIZE.JUMBO);
     
        for(SIZE s:set){
            System.out.println(s);
        }
    }
}

// correct GRANDE, TALL, JUMBO

public class Q2_1513 {
    
}
