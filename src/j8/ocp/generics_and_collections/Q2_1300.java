package j8.ocp.generics_and_collections;

import java.util.*; 
public class Q2_1300 {     
    public static void main(String[] args) {       
        // put declaration here        
//        Map m = new TreeMap();// compiles but exception at runtime
//        Map<Object, Object> m = new TreeMap<Object, Object>();// compiles but exception at runtime
//        Map<Object, ?> m = new LinkedHashMap<Object, Object>();
//        Map m = new HashMap();  // pre-generics, ok
        Map<Object, ? super ArrayList> m = 
                          new LinkedHashMap<Object, Object>();// ok if lines 2,3 commented out 


        m.put("1", new ArrayList());   // 1 
//        m.put(1, new Object());    //2
    //    m.put(1.0, "Hello");     //3       
        System.out.println(m);     
    } 
}
