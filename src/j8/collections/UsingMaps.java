package j8.collections;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class UsingMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(); // sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        System.out.println(map.containsKey("John"));    // true
        System.out.println(map.containsValue(18));      // true
        System.out.println(map.isEmpty());              // false
        System.out.println(map.get("John"));            // 18
        for(String name:map.keySet()){
            System.out.println(name); // Chris, John, Mary
        }
        for(Integer age:map.values()){ // sort is by keys
            System.out.println(age); // 33, 18, 21
        }
        System.out.println(map.containsKey("Paul"));    // false
        System.out.println(map.containsValue(21));      // true
        System.out.println(map.size());                 // 3
        map.clear();
        System.out.println(map.size());                 // 0

        // forEach()
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        // Chris maps to 33
        // John maps to 18
        // Mary maps to 21
        //   forEach(BiConsumer)
        //     BiConsumer<T,U>     void accept(T t, U u)
        map.forEach((k, v) -> System.out.println( k + " maps to "+ v));
        
        // Set<Map.Entry<K,​V> entrySet() - Map.Entry encapsulates a key-value pair.
        // go from a Map to a Set (an official Collection)
        // Chris -> 33
        // John  -> 18
        // Mary  -> 21
        map.entrySet().forEach(entry ->     //    forEach(Consumer)
                System.out.println(entry.getKey() + " -> "+ entry.getValue()));
     
        Set keys = map.keySet();        // [Chris, John, Mary]
        // putIfAbsent()
        map.put("Mike", null);          // {Chris=33, John=18, Mary=21, Mike=null}
        map.putIfAbsent("Chris", 99);   // {Chris=33, John=18, Mary=21, Mike=null}
        map.putIfAbsent("Mike", 55);    // {Chris=33, John=18, Mary=21, Mike=55}    
        map.putIfAbsent("Luke", 31);    // {Chris=33, John=18, Luke=31, Mary=21, Mike=55}

        // replace() and replaceAll
        Integer original = map.replace("Chris", 81);
        System.out.println(map);        // {Chris=81, John=18, Luke=31, Mary=21, Mike=55}
        // BiFunction<T, U, R>
        //   R apply(T t, U u) - 2 inputs and an output; all of which can be different types
        // replaceAll(BiFunction<K, V, V> fn) - note the return type is of type V also
        map.replaceAll((name, age) -> name.length());
        System.out.println(map);        // {Chris=5, John=4, Luke=4, Mary=4, Mike=4}

        // remove()
        map.remove("Mike");             // {Chris=5, John=4, Luke=4, Mary=4}
    }
}
