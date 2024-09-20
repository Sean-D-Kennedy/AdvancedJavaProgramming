package j11.ocp.working_with_java_data_types.lvti;

import java.util.ArrayList;
import java.util.List;

public class Q2_3064 {
    public static void main(String[] args) {
        // a)
        for(var x : System.getProperties().entrySet()){ // Set<Map.Entry<Object,Object>>
            // x is a Map.Entry<Object,Object>
            var m = x.getKey(); 
//            System.out.println(m);
        }

        // b)
        for(var x : System.getProperties().keySet()){ // Set<Object>
            // x is an Object
      //      var m = x.
        }

        // c)
        var obj = (String)null;
        
        // d)
//        var k = System.out::println;
        
        List<String> ls = new ArrayList<>();
        ls.add("s");
        ls.add("k");
        ls.forEach(System.out::println);
        
        // e)
        var _ = new ArrayList<>();

    }
    
}
