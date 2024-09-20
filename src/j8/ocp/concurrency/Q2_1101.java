package j8.ocp.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Q2_1101 {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
                
        map.put("A", 1);// key -> value
        map.put("B", 2);
        
        //  V putIfAbsent(K key, V value)
        //    if (!map.containsKey(key))        
        //      return map.put(key, value);    
        //    else        
        //      return map.get(key);
        System.out.println("putIfAbsent...");
        System.out.println(map.putIfAbsent("X", 21));   // null
        System.out.println(map);                        // {A=1, B=2, X=21}
        System.out.println(map.putIfAbsent("X", 25));   // 21
        System.out.println(map);                        // {A=1, B=2, X=21}

        //  boolean remove(Object key, Object value)
        //    if (map.containsKey(key) && map.get(key).equals(value)) {        
        //       map.remove(key);        
        //       return true;    
        //    } else return false;
        System.out.println("\nremove...");
        System.out.println(map.remove("A", 3));         // false, key there but value not there
        System.out.println(map);                        // {A=1, B=2, X=21}
        System.out.println(map.remove("A", 1));         // true, key and value both there       
        System.out.println(map);                        // {B=2, X=21}
        
        //  boolean replace(K key, V oldValue, V newValue)
        //    if (map.containsKey(key) && map.get(key).equals(oldValue)) {        
        //      map.put(key, newValue);        
        //      return true;    
        //    } else return false;
        System.out.println("\nreplace...");
        System.out.println(map.replace("B", 99, 100));  // false, key there but oldValue not there
        System.out.println(map);                        // {B=2, X=21}
        System.out.println(map.replace("B", 2, 200));   // true, key and oldValue both there       
        System.out.println(map);                        // {B=200, X=21}
        
        // V remove(Object key)
        System.out.println("\nremove...");
        System.out.println(map.remove("Z"));            // null, key not present       
        System.out.println(map);                        // {B=200, X=21}
        System.out.println(map.remove("X"));            // 21 (value returned), mapping removed       
        System.out.println(map);                        // {B=200}
    }
}







/*
    public static Integer putIfAbs(ConcurrentMap<String, Integer> map, String key, Integer value){ 
        System.out.println(map.putIfAbsent("X", 21)); // null
        System.out.println(map.putIfAbsent("X", 21)); // 21

        if (!map.containsKey(key)) // !F == T 
            return map.put(key, value); // returns null
        else 
            return map.get(key); // key already there, return the 'value'
    }

*/